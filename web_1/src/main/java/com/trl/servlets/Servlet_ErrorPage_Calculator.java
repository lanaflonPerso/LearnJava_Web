package com.trl.servlets;

import com.trl.Calculator;
import com.trl.OperationType;
import com.trl.TestObject;

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
 *      1. https://www.youtube.com/watch?v=yz0ZX-RblNg&index=21&list=PLwwk4BHih4fjstwgKAHPAuUcjpRUiRh5k
 *      2. https://www.youtube.com/watch?v=cD8s5hiniys&list=PLwwk4BHih4fjstwgKAHPAuUcjpRUiRh5k&index=22
 */
@WebServlet(name = "Servlet_ErrorPage_Calculator", urlPatterns = "/s_errorPage_calculator")
public class Servlet_ErrorPage_Calculator extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {

        response.setContentType("text/html;charset=UTF-8");
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
            String operation = String.valueOf(request.getParameter("operation"));

            // определение или создание сессии
            HttpSession session = request.getSession(true);
            
            request.getServletContext().setAttribute("obj", new TestObject("TestName"));

            // получение типа операции
            OperationType operType = OperationType.valueOf(operation.toUpperCase());

            // калькуляция
            double result = Calculator.calcResult(operType, one, two);
            
            ArrayList<String> listOperations;

            // для новой сессии создаем новый список
//             if (session.isNew()) {
            if (session.getAttribute("formula") == null) {
                listOperations = new ArrayList<>();
            } 
            else { // иначе получаем список из атрибутов сессии
                listOperations = (ArrayList<String>) session.getAttribute("formula");
            }

            // добавление новой операции в список и атрибут сессии
            listOperations.add(one + " " + operType.getStringValue() + " " + two + " = " + result);
            session.setAttribute("formula", listOperations);

            // вывод всех операций
            writer.println("<h1>ID вашей сессии равен: " + session.getId() + "</h1>");
         
            writer.println("<h3>Список операций (всего:" + listOperations.size() + ") </h3>");

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