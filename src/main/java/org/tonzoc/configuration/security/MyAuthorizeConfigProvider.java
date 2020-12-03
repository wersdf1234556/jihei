package org.tonzoc.configuration.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;
import org.springframework.stereotype.Component;
import org.tonzoc.configuration.IntelliSiteProperties;

@Component
public class MyAuthorizeConfigProvider implements AuthorizeConfigProvider {

    @Autowired
    private IntelliSiteProperties intelliSiteProperties;

    @Override
    public void config(ExpressionUrlAuthorizationConfigurer<HttpSecurity>.ExpressionInterceptUrlRegistry config) {

        if (intelliSiteProperties.getPermitAll()) {
            config.anyRequest().permitAll();
        } else {
            config.anyRequest().access("@myAuthorityService.check(authentication, request)");
        }

    }
}
