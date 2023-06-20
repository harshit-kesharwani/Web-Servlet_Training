package com.example.javawebapptraiining;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "SummationServlet", value = "/Summation-servlet")
public class SummationServlet extends HttpServlet {


    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int num1 = Integer.parseInt(request.getParameter("num1"));
        int num2 = Integer.parseInt(request.getParameter("num2"));
        PrintWriter writer = response.getWriter();
        writer.println("<html><body><h1> you entered number "+num1+"and "+num2+"and their sum is "+(num1+num2)+"</h1><body><html>");
        writer.flush();
        //http://localhost:8080/Javawebapptraiining-1.0-SNAPSHOT/Summation-servlet?num1=20&num2=30
    }
    public void destroy() {
    }
}
