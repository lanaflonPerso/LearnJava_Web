package com.trl.servlets;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Source:
 *      https://www.youtube.com/watch?v=3QiWYrkBnjg&list=PL786bPIlqEjSoaZjtS5y6hQrUWOzs72Jl&index=8
 * */
@WebServlet(name = "Servlet_URLParameters", urlPatterns = "/s_URLParameters")
public class Servlet_URLParameters extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
// ---------------------------------------------------------------------------------------------------------------------
        String one = req.getParameter("one");
        String two = req.getParameter("two");
        resp.getWriter().write(
                    "<html>" +
                            "<head>" +
                                "<title>This is title</title>" +
                            "</head>" +
                            "<body>" +
                                "one = " + one +
                                " two = " + two +
                                "<form action='urlPS' method='post'>" +
                                    "<input type='text' name= 'one'/>" +
                                    "<input type='text' name= 'two'/>" +
                                    "<input type='submit' name='submit'/>" +
                                "</form>" +
                            "</body" +
                        "</html>"

        );

// ---------------------------------------------------------------------------------------------------------------------
        // http://localhost:8080/urlPS?valueOne=1&valueTwo=2&valueThree=3
//        String value1 = req.getParameter("valueOne");
//        String value2 = req.getParameter("valueTwo");
//        String value3 = req.getParameter("valueThree");
//        System.out.println(value1);
//        System.out.println(value2);
//        System.out.println(value3);

// ---------------------------------------------------------------------------------------------------------------------
        // http://localhost:8080/urlPS?valueOne=1&valueOne=11&valueTwo=2&valueThree=3
//        String[] values = req.getParameterValues("valueOne");
//        System.out.println(Arrays.toString(values));

// ---------------------------------------------------------------------------------------------------------------------
        // http://localhost:8080/urlPS?valueOne=1&valueOne=11&valueTwo=2&valueThree=3
//        Enumeration<String> parameterNames = req.getParameterNames();
//        while (parameterNames.hasMoreElements()) {
//            System.out.println(parameterNames.nextElement());
//        }

        // http://localhost:8080/urlPS?valueOne=1&valueOne=11&valueTwo=2&valueThree=3
//        Enumeration<String> parameterNames = req.getParameterNames();
//        while (parameterNames.hasMoreElements()) {
//            String paramName = parameterNames.nextElement();
//            System.out.println(paramName + " = " + req.getParameter(paramName));
//        }

//        Map<String, String[]> parameterMap = req.getParameterMap();
//        for (String key : parameterMap.keySet()) {
//            System.out.println(key + " = " + Arrays.toString(parameterMap.get(key)));
//        }
// ---------------------------------------------------------------------------------------------------------------------
        // http://localhost:8080/urlPS?valueOne=1&valueOne=11&valueTwo=2&valueThree=3
//        System.out.println(req.getQueryString());
// ---------------------------------------------------------------------------------------------------------------------
//        System.out.println(req.getRequestURL());
//        System.out.println(req.getRequestURI());
//        System.out.println(req.getRequestedSessionId());
//        System.out.println(req.getServletPath());
//        System.out.println(req.getServletContext());
//        System.out.println(req.getHttpServletMapping());
//        System.out.println(req.getRemoteHost());
//        System.out.println(req.getRemoteUser());
//        System.out.println(req.getRemoteAddr());
//        System.out.println(req.getRemotePort());
//        System.out.println(req.getLocalPort());

// ---------------------------------------------------------------------------------------------------------------------
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        // pered tem ka vuzuvat method doPost v methode doGet nado smenit ety stroky "<form action='urlPS' method='get'>"
        // na "<form action='urlPS' method='post'>"
        doGet(req, resp);
    }
}
