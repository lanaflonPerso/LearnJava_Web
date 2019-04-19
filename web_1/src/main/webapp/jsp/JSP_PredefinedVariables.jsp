<%--

  Source: https://www.youtube.com/watch?v=-Sviw8xSEFg&index=19&list=PL786bPIlqEjSoaZjtS5y6hQrUWOzs72Jl

--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Predefined Variables JSP</title>
</head>
<body>
    Predefined Variables JSP
    <br>

    <%= request.getMethod() %>
    <br>

    <%--<%= response.setStatus(HttpServletResponse.SC_OK) %>--%>
    <br>

    <%= session.getAttribute("one") %>
    <br>

    <%= application.getAttribute("") %>
    <br>

    <%= application.getServerInfo() %>
    <br>

    <%= application.getServletContextName() %>
    <br>

    <%= config.getServletContext() %>
    <br>

</body>
</html>
