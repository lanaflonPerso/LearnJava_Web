package com.trl.servlets;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;

/**
 * Source:
 *      https://www.youtube.com/watch?v=W9oYh61BC3E&list=PL786bPIlqEjSoaZjtS5y6hQrUWOzs72Jl&index=7
 * */
@WebServlet(name = "Servlet_ThreadSafe", urlPatterns = "/s_threadSafe")
public class Servlet_ThreadSafe extends HttpServlet {

    private int count = 0;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        synchronized (this){
            for (int i = 0; i < 1_000_000; i++) {
                count++;
            }
            System.out.println(count);
            System.out.println(Thread.currentThread().getName());
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 2; i++) {
            new Thread(() -> {
                try {
                    URLConnection urlConnection = new URL("http://localhost:8080/tss").openConnection();
                    urlConnection.getInputStream();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
}
