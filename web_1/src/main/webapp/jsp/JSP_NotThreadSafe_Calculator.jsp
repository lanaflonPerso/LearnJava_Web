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
%>

<%!
    ArrayList<String> listOperations;
    double one;
    double two;
    String operation;
    OperationType operType;
    double result;
%>

<%
    one = Double.parseDouble(request.getParameter("one"));
    two = Double.parseDouble(request.getParameter("two"));
    operation = String.valueOf(request.getParameter("operation"));

    session = request.getSession(true);

    operType = OperationType.valueOf(operation.toUpperCase());

    result = Calculator.calcResult(operType, one, two);

    if (session.getAttribute("formula") == null) {
        listOperations = new ArrayList<>();
    } else {
        listOperations = (ArrayList<String>) session.getAttribute("formula");
    }

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

<h3>"
    <%= oper %>
</h3>

<%
    }
%>

<%
    } catch (Exception ex) {
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

