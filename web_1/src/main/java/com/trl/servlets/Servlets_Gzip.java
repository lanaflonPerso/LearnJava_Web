package com.trl.servlets;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.zip.GZIPOutputStream;

/**
 * Source:
 *     https://www.youtube.com/watch?v=lU8np4ShQVc&index=11&list=PL786bPIlqEjSoaZjtS5y6hQrUWOzs72Jl
 * */
@WebServlet(name = "Servlets_Gzip", urlPatterns = "/s_Gzip")
public class Servlets_Gzip extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        if (req.getHeader("Accept-Encoding").contains("gzip")) {
            PrintWriter printWriter = new PrintWriter(new GZIPOutputStream(resp.getOutputStream()));
            printWriter.write("hello world");
        }
    }
}
