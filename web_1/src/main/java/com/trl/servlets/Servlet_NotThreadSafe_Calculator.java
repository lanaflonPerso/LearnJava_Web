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
 *     1. https://www.youtube.com/watch?v=0bCj7lqGzbA&list=PLwwk4BHih4fjstwgKAHPAuUcjpRUiRh5k&index=20
 */
@WebServlet(name = "Servlet_NotThreadSafe_Calculator", urlPatterns = "/s_notThreadSafe_calculator")
public class Servlet_NotThreadSafe_Calculator extends HttpServlet {

    // las variables estaticas y variables de class no son tread safe
    // variables locales son tread safe
    // Esta variable hace este servlet not thread safe
    private ArrayList<String> listOperations = new ArrayList<>();

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

            // получение типа операции
            OperationType operType = OperationType.valueOf(operation.toUpperCase());

            // калькуляция
            double result = Calculator.calcResult(operType, one, two);

            // для новой сессии создаем новый список
//             if (session.isNew()) {
            if (session.getAttribute("formula") == null) {
                listOperations.clear();
            } else {
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
            // предупреждение пользователю в случае ошибки
            writer.println("<h3 style=\"color:red;\">Возникла ошибка. Проверьте параметры</h3>");
            writer.println("<h3>Имена параметров должны быть one, two, operation</h3>");
            writer.println("<h3>Operation должен принимать 1 из 4 значений: add, subtract, multiply, divide</h3>");
            writer.println("<h3>Значения one и two должны быть числами</h3>");
            writer.println("<h1>Пример</h1>");
            writer.println("<h3>?one=1&two=3&operation=add</h3>");

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