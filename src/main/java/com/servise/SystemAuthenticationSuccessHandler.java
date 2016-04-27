package com.servise;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SystemAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    public void onAuthenticationSuccess(HttpServletRequest req,
                                        HttpServletResponse res, Authentication auth)
            throws IOException, ServletException {
        String ROLE = String.valueOf(auth.getAuthorities());
        if (ROLE.equals("[ROLE_ADMIN]")){
            res.sendRedirect(req.getContextPath() + "/AdminPage");
        }
        if (ROLE.equals("[ROLE_USER]")){
            res.sendRedirect(req.getContextPath() + "/MainPage");
        }

    }

}