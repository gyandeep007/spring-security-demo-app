package com.example.springsecuritydemoapp.security;

import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.www.BasicAuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Component
public class SpringSecurityDemoAuthenticationEntryPoint extends BasicAuthenticationEntryPoint {
        @Override
        public void commence(HttpServletRequest request, HttpServletResponse response,
                AuthenticationException authException) throws IOException {
            response.addHeader("WWW-Authenticate", "Basic realm=\"" + this.getRealmName() + "\"");
        //    response.sendError(HttpStatus.UNAUTHORIZED.value(), HttpStatus.UNAUTHORIZED.getReasonPhrase());
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            PrintWriter writer = response.getWriter();
            writer.println("Basic Authentication required. Please supply appropriate credentials");
        }

    @Override
    public void afterPropertiesSet() {
            setRealmName("basicRealm");
        super.afterPropertiesSet();
    }
}
