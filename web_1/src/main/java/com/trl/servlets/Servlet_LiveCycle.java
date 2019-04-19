package com.trl.servlets;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Source:
 *         https://www.youtube.com/watch?v=0G9RwERp0TU&index=6&list=PL786bPIlqEjSoaZjtS5y6hQrUWOzs72Jl
 * */
@WebServlet(name = "Servlet_LiveCycle", urlPatterns = "/s_liveCycle")
public class Servlet_LiveCycle extends HttpServlet {

    @Override
    public void init() {
        System.out.println("init() method");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        System.out.println("doGet() method");
        String s = "<html>" +
                       "<head>" +
                            "<title>This is title</title>" +
                       "</head>" +
                       "<body>" +
                            "Hello World Body" +
                       "</body" +
                   "</html>";
        resp.getWriter().write(s);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        System.out.println("doPost() method");
        doGet(req, resp);
    }

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        System.out.println("service() method");
        super.service(req, res);
    }

    @Override
    public void destroy() {
        System.out.println("destroy() method");
    }
}
