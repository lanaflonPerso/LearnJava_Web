package com.trl.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

// Source: https://www.youtube.com/watch?v=b7zZ876wsFM&list=PL786bPIlqEjSoaZjtS5y6hQrUWOzs72Jl&index=12
//         https://en.wikipedia.org/wiki/List_of_HTTP_status_codes
//         https://ru.wikipedia.org/wiki/%D0%A1%D0%BF%D0%B8%D1%81%D0%BE%D0%BA_%D0%BA%D0%BE%D0%B4%D0%BE%D0%B2_%D1%81%D0%BE%D1%81%D1%82%D0%BE%D1%8F%D0%BD%D0%B8%D1%8F_HTTP
@WebServlet(name = "Servlet_ReturnStatus", urlPatterns = "/s_returnStatus")
public class Servlet_ReturnStatus extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        resp.setStatus(200);
//        resp.setStatus(HttpServletResponse.SC_OK);
//        resp.sendRedirect("/hs");
//        resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "my resp error message");

//        resp.setHeader("Refresh", "1");
//        System.out.println("Hello");
//        resp.setHeader("Refresh", "5;URL=https://google.com");
        resp.containsHeader("Refresh");
//        resp.setContentType("");
//        resp.setContentLength(1000);

//        resp.setIntHeader("Refresh", 1);
    }
}
