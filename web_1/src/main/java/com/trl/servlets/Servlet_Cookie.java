package com.trl.servlets;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Sources:
 *      1. https://www.youtube.com/watch?v=5lEqd2eN_AU&index=13&list=PL786bPIlqEjSoaZjtS5y6hQrUWOzs72Jl
 *      2. https://www.youtube.com/watch?v=383PfQh6qrg&list=PLwwk4BHih4fjstwgKAHPAuUcjpRUiRh5k&index=27
 * */
@WebServlet(name = "Servlet_Cookie", urlPatterns = "/s_cookie")
public class Servlet_Cookie extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {

        Cookie[] cookies = req.getCookies();

        for (Cookie cookie : cookies) {
            System.out.println(cookie.getName());
            System.out.println(cookie.getValue());
            System.out.println(cookie.getMaxAge());
        }

        Cookie cookie = new Cookie("cookieName2", "cookieValue2");
//        cookie.setMaxAge(5);
        cookie.setPath("/sc");
        resp.addCookie(cookie);
    }
}
