<%@ page import="com.trl.Calculator" %>
<%@ page import="com.trl.OperationType" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>JSP_NotThreadSafe_Calculator</title>
</head>
<body>
<%
    try {
        ServletContext servletContext = request.getServletContext();
        ArrayList<String> listOperations;

        // считывание параметров
        double one = Double.parseDouble(request.getParameter("one"));
        double two = Double.parseDouble(request.getParameter("two"));
        String operation = String.valueOf(request.getParameter("operation"));

        servletContext.log("value one = " + one);
        servletContext.log("value two = " + two);
        servletContext.log("value operation = " + operation);

        // определение или создание сессии
        session = request.getSession(true);

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
%>

<h1>ID вашей сессии равен: <%= session.getId() %>
</h1>

<h3>Список операций (всего: <%= listOperations.size() %>
</h3>

<%
    for (String oper : listOperations) {
%>

<h3>" <%= oper %>
</h3>

<%
    }
%>

<%

    } catch (Exception ex) {
        // предупреждение пользователю в случае ошибки
%>

<h3 style='color:red;'>Возникла ошибка. Проверьте параметры</h3>
<h3>Имена параметров должны быть one, two, operation</h3>
<h3>Operation должен принимать 1 из 4 значений: add, subtract, multiply, divide</h3>
<h3>Значения one и two должны быть числами</h3>"
<h1>Пример:</h1>"
<h3>?one=1&two=3&operation=add</h3>

<%
    }
%>

</body>
</html>

