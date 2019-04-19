package com.trl.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

/**
 * Sources:
 *      1. https://www.youtube.com/watch?v=4FGrC2obvMs&list=PLwwk4BHih4fjstwgKAHPAuUcjpRUiRh5k&index=18
 * */
@WebServlet(name = "Servlet_Parameter", urlPatterns = "/s_parameter")
public class Servlet_Parameter extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter writer = response.getWriter();
        Enumeration<String> parameterNames = request.getParameterNames();

        try {
            writer.println("<html>");
            writer.println("<head>");
            writer.println("<title>Servlet ShowImage</title>");
            writer.println("</head>");
            writer.println("<body>");

            while (parameterNames.hasMoreElements()){
                String parameterName = parameterNames.nextElement();
                writer.println("<h1>Parametro '" + parameterName + "' = " + request.getParameter(parameterName) + " </h1>");
            }

            writer.println("</body>");
            writer.println("</html>");
        } finally {
            writer.close();
        }
    }

}
