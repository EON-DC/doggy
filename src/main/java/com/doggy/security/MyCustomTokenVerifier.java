package com.doggy.security;

import com.doggy.auth.ApplicationUserRole;
import com.google.common.base.Strings;
import com.google.common.collect.Sets;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MyCustomTokenVerifier extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String token = request.getHeader(HttpHeaders.AUTHORIZATION);
        if (Strings.isNullOrEmpty(token) || !token.equals("success")) {
            filterChain.doFilter(request, response);
            return;
        }
        Authentication authentication = new UsernamePasswordAuthenticationToken(
                "park",
                "1234",
                ApplicationUserRole.USER.getSimpleGrantedAuthorities()
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        filterChain.doFilter(request, response);
    }
}
