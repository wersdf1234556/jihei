package org.tonzoc.configuration.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;
import org.tonzoc.model.AuthorityModel;
import org.tonzoc.model.UserModel;
import org.tonzoc.service.IUserService;
import org.tonzoc.service.IAuthorityService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Component
public class MyAuthorityService {

    @Autowired
    private IUserService userService;

    @Autowired
    private IAuthorityService authorityService;

    private AntPathMatcher antPathMatcher = new AntPathMatcher();

    public boolean check(Authentication authentication, HttpServletRequest request) throws Exception {

        List<AuthorityModel> defaultAuthorityModel = authorityService.listDefault();

        for (AuthorityModel authorityModel : defaultAuthorityModel) {
            if (antPathMatcher.match(authorityModel.getTargetUrl(), request.getRequestURI())) {
                return true;
            }
        }

        Object principal = authentication.getPrincipal();

        if (principal != null && principal instanceof UserDetails) {

            String name = ((UserDetails) principal).getUsername();

            UserModel userModel = userService.getByName(name);

            List<AuthorityModel> authorityModels = authorityService.listByUser(userModel.getGuid());

            // TODO 通配符匹配问题
            for (AuthorityModel authorityModel : authorityModels) {
                if (antPathMatcher.match(authorityModel.getTargetUrl(), request.getRequestURI())) {
                    return true;
                }
            }

        }

        return false;
    }

}