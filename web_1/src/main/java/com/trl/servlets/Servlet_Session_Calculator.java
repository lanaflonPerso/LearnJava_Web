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

/**
 * Sources:
 * 1. https://www.youtube.com/watch?v=4FGrC2obvMs&list=PLwwk4BHih4fjstwgKAHPAuUcjpRUiRh5k&index=18
 */
@WebServlet(name = "Servlet_Session_Calculator", urlPatterns = "/s_session_calculator")
public class Servlet_Session_Calculator extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {

        ArrayList<String> listOperations;

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        out.println("<html>");
        out.println("<head>");
        out.println("<title>Servlet CalcServlet</title>");
        out.println("</head>");
        out.println("<body>");

        try {

            // считывание параметров
            double one = Double.parseDouble(request.getParameter("one"));
            double two = Double.parseDouble(request.getParameter("two"));
            String operation = String.valueOf(request.getParameter("operation"));

            // определение или создание сессии
            HttpSession session = request.getSession(true);

            // получение типа операции
            OperationType operType = OperationType.valueOf(operation.toUpperCase());

            // калькуляция
            double result = Calculator.calcResult(operType, one, two);

            // для новой сессии создаем новый список
//             if (session.isNew()) {
            if (session.getAttribute("formula") == null) {
                listOperations = new ArrayList<>();
            } else {
                listOperations = (ArrayList<String>) session.getAttribute("formula");
            }

            // добавление новой операции в список и атрибут сессии
            listOperations.add(one + " " + operType.getStringValue() + " " + two + " = " + result);
            session.setAttribute("formula", listOperations);

            // вывод всех операций
            out.println("<h1>ID вашей сессии равен: " + session.getId() + "</h1>");
            out.println("<h3>Список операций (всего:" + listOperations.size() + ") </h3>");

            for (String oper : listOperations) {
                out.println("<h3>" + oper + "</h3>");
            }

        } catch (Exception ex) {
            // предупреждение пользователю в случае ошибки
            out.println("<h3 style=\"color:red;\">Возникла ошибка. Проверьте параметры</h3>");
            out.println("<h3>Имена параметров должны быть one, two, operation</h3>");
            out.println("<h3>Operation должен принимать 1 из 4 значений: add, subtract, multiply, divide</h3>");
            out.println("<h3>Значения one и two должны быть числами</h3>");
            out.println("<h1>Пример</h1>");
            out.println("<h3>?one=1&two=3&operation=add</h3>");

        } finally {
            out.println("</body>");
            out.println("</html>");
            out.close();
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