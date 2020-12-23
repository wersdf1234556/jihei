package org.tonzoc.configuration.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.expression.OAuth2WebSecurityExpressionHandler;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.tonzoc.configuration.IntelliSiteProperties;

@Configuration
@EnableResourceServer
public class MyResourceServerConfig extends ResourceServerConfigurerAdapter {

    Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private IntelliSiteProperties intelliSiteProperties;

    @Autowired
    private AuthenticationSuccessHandler meterageAuthenticationSuccessHandler;

    @Autowired
    private AuthenticationFailureHandler meterageAuthenticationFailureHandler;

    @Autowired
    private AuthorizeConfigManager authorizeConfigManager;

    @Autowired
    private OAuth2WebSecurityExpressionHandler expressionHandler;

    @Override
    public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
        resources.expressionHandler(expressionHandler);
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {

        http.cors();

        http.csrf().disable();

        http.headers().frameOptions().disable();

        authorizeConfigManager.config(http.authorizeRequests());

        http.formLogin()
                .loginProcessingUrl(intelliSiteProperties.getLoginProcessingUrl())
                .permitAll()
                .successHandler(meterageAuthenticationSuccessHandler)
                .failureHandler(meterageAuthenticationFailureHandler);

    }

    @Bean
    CorsConfigurationSource corsConfigurationSource() {

        CorsConfiguration configuration = new CorsConfiguration();
        configuration.addAllowedOrigin("*"); // 1允许任何域名使用
        configuration.addAllowedHeader("*"); // 2允许任何头
        configuration.addAllowedMethod("*"); // 3允许任何方法（post、get等）

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);

        return source;
    }
}
