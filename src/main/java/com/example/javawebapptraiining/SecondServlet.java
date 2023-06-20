package com.example.javawebapptraiining;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "SecondServlet", value = "/Second-servlet")
public class SecondServlet extends HttpServlet {


    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter writer =response.getWriter();
        writer.println("This is to test second servlet response");
        writer.flush();
    }

    public void destroy() {
    }
}