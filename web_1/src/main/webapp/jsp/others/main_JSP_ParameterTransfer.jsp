<%--
  Sources:
--%>

<%@ page contentType="text/html" pageEncoding="UTF-8" language="java" %>

<html>
<head>
    <title></title>
</head>
<body>
<h1>

    <%-- Dlya toho chtobu pravelno otobrazalis simvolu ruskie nado zadat etot parameter--%>
    <% request.setCharacterEncoding("UTF-8"); %>

    Hello <%= request.getParameter("username") %>
    <br>

    <%-- Java cod--%>
    <%--You password <%= request.getParameter("password") %>--%>

    <%-- Tags ili Expression Language --%>
    You password ${param["password"]}

</h1>
</body>
</html>


<%--

--%>