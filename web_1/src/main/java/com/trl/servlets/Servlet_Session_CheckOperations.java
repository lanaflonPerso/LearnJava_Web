package com.trl.servlets;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * Sources:
 *     1. https://www.youtube.com/watch?v=4FGrC2obvMs&list=PLwwk4BHih4fjstwgKAHPAuUcjpRUiRh5k&index=18
 * */
@WebServlet(name = "Servlet_Session_CheckOperations", urlPatterns = "/s_session_checkOperations")
public class Servlet_Session_CheckOperations extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter writer = response.getWriter();

        try {
            writer.println("<html>");
            writer.println("<head>");
            writer.println("<title>Servlet CheckAttributeServlet</title>");
            writer.println("</head>");
            writer.println("<body>");

            HttpSession session = request.getSession(true);

            Object sessionAttributes = session.getAttribute("formula");

            if (sessionAttributes instanceof ArrayList){
                ArrayList listAttributes = (ArrayList) sessionAttributes;
                writer.println("<h1>Список операций:</h1>");
                for (Object attribute : listAttributes) {
                    writer.println("<h3>"+attribute+"</h3>");
                }
                
            }else{
                writer.println("<h1>Операции не найдены</h1>");
            }

        } finally {
            writer.println("</body>");
            writer.println("</html>");
            writer.close();
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
