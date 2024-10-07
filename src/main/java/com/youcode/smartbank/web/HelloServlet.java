package com.youcode.smartbank.web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/HelloServlet")
public class HelloServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Set the response content type
        response.setContentType("text/html");

        // Get the writer to send the response
        PrintWriter out = response.getWriter();

        // Send a simple "Hello, World!" message
        out.println("<html><body>");
        out.println("<h1>Hello, World! This is a test servlet.</h1>");
        out.println("</body></html>");
    }
}
