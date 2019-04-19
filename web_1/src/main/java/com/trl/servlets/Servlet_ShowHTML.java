package com.trl.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "Servlet_ShowHTML", urlPatterns = "/s_showHTML")
public class Servlet_ShowHTML extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            out.println("<html>"
                    + "<head>"
                    + "<meta http-equiv=\"content-type\" content=\"text/html; charset=UTF-8\">"
                    + "<title>Документ</title>"
                    + "</head>"
                    + "<body>"
                    + "<table width=\"450\" border=\"0\" cellpadding=\"0\" cellspacing=\"15\">"
                    + "<tr>"
                    + " <td colspan=\"2\" align=\"center\"><strong><font color=\"#FF0000\" size=\"5\">Секретный документ</font></strong></td>"
                    + " </tr>"
                    + " <tr>"
                    + "   <td width=\"150\" rowspan=\"2\"><img src=\"images/java.png\" alt=\"\" width=\"119\" height=\"222\"></td>"
                    + "  <td width=\"340\" height=\"99\"><table width=\"300\" border=\"1\" align=\"left\" cellpadding=\"15\" cellspacing=\"0\">"
                    + "    <tr>"
                    + "      <th align=\"left\"><font color=\"#006699\"> <strong>Имя</strong></font></th>"
                    + "    <th align=\"left\"><font color=\"#006699\"><strong>Телефон</strong></font></th>"
                    + "  </tr>"
                    + "  <tr>"
                    + "    <td>Петр</td>"
                    + "   <td>555444</td>"
                    + " </tr>"
                    + " <tr>"
                    + "   <td>Иван</td>"
                    + "   <td>111222</td>"
                    + " </tr>"
                    + "  </table></td>"
                    + " </tr>"
                    + " <tr>"
                    + "  <td>"
                    + "<ul>"
                    + " <li>Текстовый документ 1</li>"
                    + " <li>Текстовый документ 1</li>"
                    + " <li>Текстовый документ 1</li>"
                    + " </ul>    "
                    + " </td>"
                    + "</tr>"
                    + "  <tr>"
                    + "  <td colspan=\"2\"><p align=\"center\"><font color=\"#999999\">Тестовый проект 2013 г</font></p></td>"
                    + "  </tr>"
                    + "</table>"
                    + "</body>"
                    + "</html>");
        } finally {
            out.close();
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
