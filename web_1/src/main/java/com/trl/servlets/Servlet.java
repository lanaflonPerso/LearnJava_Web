package com.trl.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Sources:
 *      1. https://www.youtube.com/watch?v=FE7ygm8CTaY&list=PL786bPIlqEjSoaZjtS5y6hQrUWOzs72Jl&index=1
 *      2. https://www.youtube.com/watch?v=yVTVwWb7Jt4&list=PL786bPIlqEjSoaZjtS5y6hQrUWOzs72Jl&index=2
 *      3. https://www.youtube.com/watch?v=25HcpCHgQ70&index=3&list=PL786bPIlqEjSoaZjtS5y6hQrUWOzs72Jl
 *      4. https://www.youtube.com/watch?v=9HSl6ZyQbQ0&list=PL786bPIlqEjSoaZjtS5y6hQrUWOzs72Jl&index=4
 *      5. https://www.youtube.com/watch?v=OIos3v6Fn84&list=PL786bPIlqEjSoaZjtS5y6hQrUWOzs72Jl&index=5
 *
 *      1. https://www.youtube.com/watch?v=PUTUhrnkjvo&list=PLwwk4BHih4fjstwgKAHPAuUcjpRUiRh5k&index=12
 *      2. https://www.youtube.com/watch?v=BzA_DDt7tto&list=PLwwk4BHih4fjstwgKAHPAuUcjpRUiRh5k&index=14
 *      3. https://www.youtube.com/watch?v=CVcki3qXbLE&index=15&list=PLwwk4BHih4fjstwgKAHPAuUcjpRUiRh5k
 *      4. https://www.youtube.com/watch?v=9fVKpk0egwA&list=PLwwk4BHih4fjstwgKAHPAuUcjpRUiRh5k&index=16
 *      5. https://www.youtube.com/watch?v=hqoozY1sfg0&list=PLwwk4BHih4fjstwgKAHPAuUcjpRUiRh5k&index=23
 * */
@WebServlet(name = "Servlet", urlPatterns = "/servlet")
public class Servlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try (PrintWriter writer = response.getWriter()) {
            writer.write("Hello Servlet_MyFirst !!!");
        }
    }
}
