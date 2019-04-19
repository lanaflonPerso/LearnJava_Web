package com.trl.servlets;

import com.trl.TestObject;

import javax.servlet.ServletException;
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
 *      1. https://www.youtube.com/watch?v=cD8s5hiniys&list=PLwwk4BHih4fjstwgKAHPAuUcjpRUiRh5k&index=22
 */
@WebServlet(name = "Servlet_ErrorPage_CheckOperations", urlPatterns = "/s_errorPage_checkOperations")
public class Servlet_ErrorPage_CheckOperations extends HttpServlet {

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

            Object attr = session.getAttribute("formula");

            if (attr instanceof ArrayList){
                ArrayList list = (ArrayList) attr;
                writer.println("<h1>Список операций:</h1>");
                for (Object str : list) {
                    writer.println("<h3>"+str+"</h3>");
                }
                
            }else{
                writer.println("<h1>Операции не найдены</h1>");
            }
            writer.println("<h1>"+((TestObject)request.getServletContext().getAttribute("obj")).getName()+"</h1>");

        } finally {
            writer.println("</body>");
            writer.println("</html>");
            writer.close();
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
