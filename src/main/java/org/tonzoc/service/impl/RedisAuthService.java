package org.tonzoc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.redis.RedisTokenStore;
import org.springframework.stereotype.Service;
import org.tonzoc.configuration.IntelliSiteProperties;
import org.tonzoc.model.UserModel;
import org.tonzoc.service.IRedisAuthService;
import org.tonzoc.service.IUserService;

import java.util.Collection;

@Service("redisAuthService")
public class RedisAuthService implements IRedisAuthService {

    @Autowired
    private IUserService userService;

    @Autowired
    private TokenStore tokenStore;

    @Autowired
    private IntelliSiteProperties intelliSiteProperties;

    public UserModel getCurrentUser() throws Exception {

        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        UserModel userModel = userService.getByName(userDetails.getUsername());

        return userModel;
    }

    public void logout() throws Exception {

        UserModel userModel = getCurrentUser();

        doLogout(userModel);

    }

    public void logout(String username) throws Exception {

        UserModel userModel = userService.getByName(username);

        doLogout(userModel);

    }

    private void doLogout(UserModel userModel) {

        RedisTokenStore redisTokenStore = (RedisTokenStore) tokenStore;

        Collection<OAuth2AccessToken> tokens = redisTokenStore.findTokensByClientIdAndUserName(intelliSiteProperties.getClientId(), userModel.getName());

        for (OAuth2AccessToken token : tokens) {

            redisTokenStore.removeAccessToken(token);
        }
    }
}