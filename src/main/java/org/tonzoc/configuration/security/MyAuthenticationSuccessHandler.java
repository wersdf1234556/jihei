package org.tonzoc.configuration.security;

import org.apache.commons.collections4.MapUtils;
import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.common.exceptions.UnapprovedClientAuthenticationException;
import org.springframework.security.oauth2.provider.*;
import org.springframework.security.oauth2.provider.token.AuthorizationServerTokenServices;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;
import org.tonzoc.configuration.security.support.SimpleResponse;
import org.tonzoc.service.IUserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Base64;

@Component("meterageAuthenticationSuccessHandler")
public class MyAuthenticationSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private ClientDetailsService clientDetailsService;

    @Autowired
    private IUserService userService;

    @Autowired
    private AuthorizationServerTokenServices authorizationServerTokenServices;

    private String contentType = "application/json;charset=UTF-8";

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException {

        try {

            ClientDetails clientDetails = checkClientDetails(request);

            OAuth2AccessToken oAuth2AccessToken = getoAuth2AccessToken(authentication, clientDetails);

//            User user = (User)authentication.getPrincipal();
//            UserModel userModel = userService.getName(user.getUsername());
//            LoginModel loginModel = new LoginModel(userModel.getId(),"","",Long.parseLong("0"),userModel.getName()+"登录成功");
//            loginService.save(loginModel);

            writeResponse(response, oAuth2AccessToken);


        } catch (Exception exception) {

            writeException(response, exception);
        }

    }

    private void writeResponse(HttpServletResponse response, OAuth2AccessToken oAuth2AccessToken) throws IOException {
        response.setContentType(contentType);
        response.getWriter().write(objectMapper.writeValueAsString(oAuth2AccessToken));

        logger.info("登录成功");
    }

    private void writeException(HttpServletResponse response, Exception exception) throws IOException {
        response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        response.setContentType(contentType);
        response.getWriter().write(objectMapper.writeValueAsString(new SimpleResponse("system_error", exception.getMessage())));
    }

    private OAuth2AccessToken getoAuth2AccessToken(Authentication authentication, ClientDetails clientDetails) {
        TokenRequest tokenRequest = new TokenRequest(MapUtils.EMPTY_SORTED_MAP, clientDetails.getClientId(), clientDetails.getScope(), "custom");

        OAuth2Request oAuth2Request = tokenRequest.createOAuth2Request(clientDetails);

        OAuth2Authentication oAuth2Authentication = new OAuth2Authentication(oAuth2Request, authentication);

        return authorizationServerTokenServices.createAccessToken(oAuth2Authentication);
    }

    private ClientDetails checkClientDetails(HttpServletRequest request) throws IOException {
        String header = request.getHeader("Authorization");

        if (header == null || !header.toLowerCase().startsWith("basic ")) {
            throw new UnapprovedClientAuthenticationException("请求头中无client信息");
        }

        String[] tokens = extractAndDecodeHeader(header, request);
        assert tokens.length == 2;

        String clientId = tokens[0];
        String clientSecret = tokens[1];

        ClientDetails clientDetails = clientDetailsService.loadClientByClientId(clientId);

        if (clientDetails == null) {
            throw new UnapprovedClientAuthenticationException("clientId对应的信息不存在：" + clientId);
        } else if (!passwordEncoder.matches(clientSecret, clientDetails.getClientSecret())) {
            throw new UnapprovedClientAuthenticationException("clientSecret不匹配：" + clientId);
        }
        return clientDetails;
    }

    private String[] extractAndDecodeHeader(String header, HttpServletRequest request)
            throws IOException {

        byte[] base64Token = header.substring(6).getBytes("UTF-8");
        byte[] decoded;
        try {
            decoded = Base64.getDecoder().decode(base64Token);
        } catch (IllegalArgumentException e) {
            throw new BadCredentialsException(
                    "Failed to decode basic authentication token");
        }

        String token = new String(decoded, "UTF-8");

        int delim = token.indexOf(":");

        if (delim == -1) {
            throw new BadCredentialsException("Invalid basic authentication token");
        }
        return new String[]{token.substring(0, delim), token.substring(delim + 1)};
    }
}