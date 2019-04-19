package com.trl.servlets;

import com.trl.Calculator;
import com.trl.OperationType;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Source:
 * 1. https://www.youtube.com/watch?v=kd4t3jINjec&list=PLwwk4BHih4fjstwgKAHPAuUcjpRUiRh5k&index=25
 */
@WebServlet(name = "Servlet_VisibilityAttributes_ServletContext_Calculator", urlPatterns = "/s_visibilityAttributes_servletContext_calculator")
public class Servlet_VisibilityAttributes_ServletContext_Calculator extends HttpServlet {

    public static final String SESSION_MAP = "sessionMap";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {

        Map<String, List> sessionMap = (Map<String, List>) request.getServletContext().getAttribute(SESSION_MAP);

        if (sessionMap == null) {
            sessionMap = new HashMap<>();
        }

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

            // определение или создание сессии
            HttpSession session = request.getSession(true);

            // получение типа операции
            OperationType operType = OperationType.valueOf(operation.toUpperCase());

            // калькуляция
            double result = Calculator.calcResult(operType, one, two);

            ArrayList<String> listOperations;

            // для новой сессии создаем новый список
//            if (session.isNew()) {
            if (session.getAttribute("formula") == null) {
                listOperations = new ArrayList<>();
            } else { // иначе получаем список из атрибутов сессии
                listOperations = (ArrayList<String>) session.getAttribute("formula");
            }

            // добавление новой операции в список и атрибут сессии
            listOperations.add(one + " " + operType.getStringValue() + " " + two + " = " + result);
            session.setAttribute("formula", listOperations);

            writer.println("<table cellpadding=\"20\">");
            writer.println("<tr>");
            writer.println("<td style=\"vertical-align:top;\">");


            // вывод всех операций
            writer.println("<h1>" + session.getId() + "</h1>");

            for (String oper : listOperations) {
                writer.println("<h3>" + oper + "</h3>");
            }

            sessionMap.put(session.getId(), listOperations);
            getServletContext().setAttribute(SESSION_MAP, sessionMap);


            writer.println("</td>");
            writer.println("<td style=\"vertical-align:top;\">");

            for (Map.Entry<String, List> entry : sessionMap.entrySet()) {
                String sessionId = entry.getKey();
                List listOper = entry.getValue();

                writer.println("<h1 style=\"color:red\">" + sessionId + "</h1>");

                for (Object str : listOper) {
                    writer.println("<h3>" + str + "</h3>");
                }
            }

            writer.println("</td>");
            writer.println("</tr>");
            writer.println("</table>");

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
