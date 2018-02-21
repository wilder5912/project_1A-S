/*
package com.storeArticle.store.controller.config;


import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.security.Principal;

@Component
public class CustomFilter implements Filter {

 private int i=0;
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("Init::called");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("doFilter::called");

        HttpServletRequest request = (HttpServletRequest) servletRequest;

        String userPrincipal = request.getHeader("Authorization");//getUserPrincipal();

        if(null != userPrincipal){
            i=0;
        }
        if( i < 2){
            i++;
            System.out.println("userPrinciple::"+userPrincipal);
            filterChain.doFilter(servletRequest, servletResponse);

        }

    }

    @Override
    public void destroy() {
        System.out.println("Destroy::called");

    }
}
*/
