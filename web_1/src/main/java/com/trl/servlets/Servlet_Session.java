package com.trl.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "Servlet_Session", urlPatterns = "/s_session")
public class Servlet_Session extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);

        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter writer = resp.getWriter();

        try {
            writer.println("<html>");
            writer.println("<head>");
            writer.println("<title>Servlet ShowImage</title>");
            writer.println("</head>");
            writer.println("<body>");

            writer.println("sesion");

            writer.println("</body>");
            writer.println("</html>");
        } finally {
            writer.close();
        }
    }
}
