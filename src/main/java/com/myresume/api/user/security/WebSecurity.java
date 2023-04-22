package com.myresume.api.user.security;

import com.myresume.api.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurity extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserService userService;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private Environment environment;

    @Value("${login.url.path:}")
    private String loginURL;

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        //       CorsConfiguration corsConfiguration = new CorsConfiguration();
//        corsConfiguration.setAllowedHeaders(Arrays.asList("Authorization", "Content-Type"));
//        corsConfiguration.setAllowedOrigins(Arrays.asList("http://localhost:3000", "http://localhost:8015"));
//        corsConfiguration.setAllowedMethods(Arrays.asList("HEAD", "GET", "POST", "PUT", "DELETE", "OPTIONS", "PATCH"));
//        corsConfiguration.setAllowCredentials(true);
//        corsConfiguration.setExposedHeaders(Arrays.asList("Authorization", "token", "userId"));

        httpSecurity
                .headers().frameOptions().sameOrigin()
                .and()
                .csrf().disable()
//                .cors().configurationSource(request -> corsConfiguration)
//                .and()
                .authorizeRequests().antMatchers("/**").permitAll()
                .and()
                .addFilter(getAuthenticationFilter());
    }

    private AuthenticationFilter getAuthenticationFilter() throws Exception {
        AuthenticationFilter authenticationFilter = new AuthenticationFilter(userService, environment, authenticationManager());
        //authenticationFilter.setAuthenticationManager(authenticationManager());
        authenticationFilter.setFilterProcessesUrl(loginURL);
        return authenticationFilter;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder managerBuilder) throws Exception {
        managerBuilder.userDetailsService(userService).passwordEncoder(bCryptPasswordEncoder);
    }
}
