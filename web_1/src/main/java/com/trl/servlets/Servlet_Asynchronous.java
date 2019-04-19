package com.trl.servlets;

import javax.servlet.AsyncContext;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// Source: https://www.youtube.com/watch?v=K-Z8mJ3ZECQ&list=PL786bPIlqEjSoaZjtS5y6hQrUWOzs72Jl&index=15

@WebServlet(name = "Servlet_Asynchronous", urlPatterns = "/s_asynchronous", asyncSupported = true)
public class Servlet_Asynchronous extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        AsyncContext asyncContext = req.getAsyncContext();
        asyncContext.start(() -> {
            // a wait event
            System.out.println("hell from Asynchronous Servlets ");
        });

        asyncContext.complete();
    }
}
