package org.tonzoc.configuration.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.tonzoc.exception.NotOneResultFoundException;
import org.tonzoc.model.UserModel;
import org.tonzoc.service.IUserService;

@Component("myUserDetailsService")
public class MyUserDetailsService implements UserDetailsService {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private IUserService userService;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        logger.info("登录用户名：" + username);

        UserModel userModel = null;
        try {
            userModel = userService.getByName(username);
        } catch (NotOneResultFoundException e) {
            e.printStackTrace();
        }

        /**
         *
         * TODO 添加用户是否已经登录的验证，以及处理逻辑
         *
         */


        String password = userModel.getPassword();

        return new User(username, password,
                true, true, true, true,
                AuthorityUtils.NO_AUTHORITIES);
    }
}
