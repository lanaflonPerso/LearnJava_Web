package com.trl.servlets;

import com.trl.Calculator;
import com.trl.OperationType;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * Source:
 * 1. https://www.youtube.com/watch?v=kd4t3jINjec&list=PLwwk4BHih4fjstwgKAHPAuUcjpRUiRh5k&index=25
 */
@WebServlet(name = "Servlet_VisibilityAttributes_ServletRequest_Calculator", urlPatterns = "/s_visibilityAttributes_servletRequest_calculator")
public class Servlet_VisibilityAttributes_ServletRequest_Calculator extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {

        PrintWriter writer = response.getWriter();

        writer.println("<html>");
        writer.println("<head>");
        writer.println("<title>Servlet CalcServlet</title>");
        writer.println("</head>");
        writer.println("<body>");

        try {
            // считывание параметров
            double one = Double.parseDouble(request.getParameter("one"));
            double two = Double.parseDouble(request.getParameter("two"));
            String operation = request.getParameter("operation");

            // получение типа операции
            OperationType operType = OperationType.valueOf(operation.toUpperCase());

            // калькуляция
            double result = Calculator.calcResult(operType, one, two);

            ArrayList<String> listOperations;

            // для новой сессии создаем новый список
//            if (session.isNew()) {
            if (request.getAttribute("formula") == null) {
                listOperations = new ArrayList<>();
            } else { // иначе получаем список из атрибутов сессии
                listOperations = (ArrayList<String>) request.getAttribute("formula");
            }

            // добавление новой операции в список и атрибут сессии
            listOperations.add(one + " " + operType.getStringValue() + " " + two + " = " + result);
            request.setAttribute("formula", listOperations);

            writer.println("<table cellpadding=\"20\">");
            writer.println("<tr>");
            writer.println("<td style=\"vertical-align:top;\">");


            // вывод всех операций
            writer.println("<h1>" + request.toString() + "</h1>");

            for (String oper : listOperations) {
                writer.println("<h3>" + oper + "</h3>");
            }

        } catch (Exception ex) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST);
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
        return "Сервлет - калькулятор";
    }

}
