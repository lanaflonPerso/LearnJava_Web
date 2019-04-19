package com.trl.servlets;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Enumeration;

/**
 * Source:
 *     https://www.youtube.com/watch?v=vxrnKBNTfJI&index=14&list=PL786bPIlqEjSoaZjtS5y6hQrUWOzs72Jl
 * */
@WebServlet(name = "Servlet_Session2", urlPatterns = "/s_session2")
public class Servlet_Session2 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        HttpSession session = req.getSession();
        Enumeration<String> attributeNames = session.getAttributeNames();
        while (attributeNames.hasMoreElements()) {
            String attributeName = attributeNames.nextElement();
            System.out.println(attributeName + " = " + session.getAttribute(attributeName));
        }

        // add attribute
        session.setAttribute("one", "two");
        System.out.println(session.getMaxInactiveInterval());
    }
}
