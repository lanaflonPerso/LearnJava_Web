package com.trl.servlets;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Source:
 *      https://www.youtube.com/watch?v=wlovEKKl_Kw&list=PL786bPIlqEjSoaZjtS5y6hQrUWOzs72Jl&index=9
 * */
@WebServlet(name = "Servlets_CrossSiteScripting", urlPatterns = "/s_crossSiteScripting")
public class Servlets_CrossSiteScripting extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String one = req.getParameter("one");
        one = one == null ? "" : one.replaceAll("<", "&lt").replaceAll(">", "&gt");
        resp.getWriter().write(
                "<html>" +
                        "<head>" +
                            "<title>This is title</title>" +
                        "</head>" +
                        "<body>" +
                            "one = " + one +
                            "<form action='scss' method='post'>" +
                                "<textarea name= 'one'></textarea>" +
                                "<input type='submit' name='submit'/>" +
                            "</form>" +
                        "</body" +
                    "</html>"

        );
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        // pered tem ka vuzuvat method doPost v methode doGet nado smenit ety stroky "<form action='urlPS' method='get'>"
        // na "<form action='urlPS' method='post'>"
        doGet(req, resp);
    }
}
