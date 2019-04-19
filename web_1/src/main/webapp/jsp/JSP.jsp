<%--
  Sources:
        1. https://www.youtube.com/watch?v=x75BDvhiY68&list=PL786bPIlqEjSoaZjtS5y6hQrUWOzs72Jl&index=16
        2. https://www.youtube.com/watch?v=hJjNm6-bpTw&list=PLwwk4BHih4fjstwgKAHPAuUcjpRUiRh5k&index=29
        3. https://www.youtube.com/watch?v=by0nOT1mALg&list=PL786bPIlqEjSoaZjtS5y6hQrUWOzs72Jl&index=17
--%>
<%@ page import="com.trl.JSPHelper" %>
<%@ page import="java.util.Date" %>

<%@ page contentType="text/html" pageEncoding="UTF-8" language="java" %>

<html>
<head>
    <title>Hello World JSP</title>
</head>
<body>

<h1>Hello from MyFirstJSP</h1>
<br>

<!-- Comment HTML-->
<%-- Comment JSP--%>

<%--=================================== Takoi cod nazuvaetsa declaration =======================================--%>
<%-- declaration prenaznachaetsa dlia obiavlenia peremennux ili methodov ili drugix chastei coda--%>
<%! int a = 5; %>
<%!
    private void method() {
        System.out.println("method()");
    }
%>


<%--===================================== Etoto cod nazuvaetsa expresion. ======================================--%>
<%-- espresion dolzno vozvrashchat string ili kakimto obrazom prevrashchatsa ve string --%>

<%= a + 1 + 2 %>
<br>

<%= new Date() %>
<br>

<%= JSPHelper.subtract(10, 5) %>
<br>


<%--============== Skreplets eto eto neposredstvenno cod cotorui mu mozem vstavliat v stranicy JSP =============--%>
<%
    class Student {
        private String name;

        public Student(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
%>

<%= new Student("Juan").getName() %>
<br>


<%--======================================== Interesnoe svoistvo ===============================================--%>
<% if (Math.random() > 0.5) { %>

hello

<% } %>
<br>

<% method(); %>
<br>

</body>
</html>


<%--

<% java cod %>  eti skobki nazivaytsa skripletu

<%@ page import="" %>  tak delaetsa import

<%@taglib url="", prefix=""%> pozvoliaet podcluchat storonnie tegi s opredilonnoi funccionalnostiy

<% %>  visov klasa, methoda ...
<%! %> obiavlenie peremennoi.
<%= %> prisvaienie znachenia.

JSTL(Java Server Pages Standart Tag Library) standartnaia biblioteka tegov
EL(Expression Language) dostup k obiektam ili dannum bez ispolzovania skrepletov, chasto ispolzyetsa s JSTL.

Document JSP ispolzuetsa xml i tegi, etot format bolie strogii
Stranica JSP ispolzyetsa java i tegi

Java Bean
Enterprise Java Bean

--%>