package com.trl.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "Servlet_Document", urlPatterns = "/s_document")
public class Servlet_Document extends HttpServlet {


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter writer = response.getWriter();
        writer.println("<!DOCTYPE html>");
        writer.println("<html>");
        writer.println("<head>");
        writer.println("<meta http-equiv='content-type' content='text/html' charset='UTF-8'>");
        writer.println("<title>Document</title>");
        writer.println("<link href='" + request.getContextPath() + "/css/StyleDocument.css'" + " rel='stylesheet' type='text/css'>");
        writer.println("</head>");
        writer.println("<body>");
        writer.println("<div class='main'>");
        writer.println("<div class='abzac'>Secret document</div>");
        writer.println("<div class='content'>");
        writer.println("<div class='small_column'>");
        writer.println("<img src='" + request.getContextPath() + "/images/java.png'" + " alt='' width='119' height='222'>");
        writer.println("</div>");
        writer.println("<div class='big_column'>");
        writer.println("<div>");
        writer.println("<table>");
        writer.println("<tr>");
        writer.println("<th>Name</th>");
        writer.println("<th>Phone</th>");
        writer.println("</tr>");
        writer.println("<tr>");
        writer.println("<td>Peter</td>");
        writer.println("<td>555444</td>");
        writer.println("</tr>");
        writer.println("<tr>");
        writer.println("<td>Ivan</td>");
        writer.println("<td>111222</td>");
        writer.println("</tr>");
        writer.println("</table>");
        writer.println("</div>");
        writer.println("<div>");
        writer.println("<ul>");
        writer.println("<li>Text Document 1</li>");
        writer.println("<li>Text Document 1</li>");
        writer.println("<li>Text Document 1</li>");
        writer.println("</ul>");
        writer.println("</div>");
        writer.println("</div>");
        writer.println("</div>");
        writer.println("<div class='footer'>Text Document 2013 yer</div>");
        writer.println("</div>");
        writer.println("</body>");
        writer.println("</html>");
    }
}
