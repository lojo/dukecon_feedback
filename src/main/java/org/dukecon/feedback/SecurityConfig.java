package org.dukecon.feedback;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import static org.springframework.security.oauth2.client.web.OAuth2AuthorizationRequestRedirectFilter.DEFAULT_AUTHORIZATION_REQUEST_BASE_URI;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Value("${keycloak-client.realm}")
    final String realm = null;

    /**
     * Configures OAuth Login with Spring Security 5.
     *
     * Thanks to Michael Simons for providing such a nice example in
     * http://info.michael-simons.eu/2017/12/28/use-keycloak-with-your-spring-boot-2-application/
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
            .anyRequest().permitAll()
            .and()
            // This is the point where OAuth2 login of Spring 5 gets enabled
            .oauth2Login()
            .loginPage(DEFAULT_AUTHORIZATION_REQUEST_BASE_URI + "/" + realm);
    }
}
