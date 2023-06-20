package com.example.javawebapptraiining;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.*;
//import com.example.javawebapptraiining.Credential;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "LoginServlet", value = "/Login-servlet")
public class LoginServlet extends HttpServlet {
  @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

    }
    @Override
    protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
      String username =request.getParameter("username");
        String password =request.getParameter("password");
        BufferedReader credentialReader= Files.newBufferedReader(Paths.get("C:\\Users\\Harsh\\IdeaProjects\\Bootcamp\\Javawebapptraiining\\data\\credentials.csv"));
        String Line;
      List<Credential> credentialList =new ArrayList<>();
      while((Line=credentialReader.readLine())!=null)
      {
        String[] credentialData=Line.split(",");
        credentialList.add(new Credential(credentialData[0], credentialData[1]));
      }
      Optional<Credential> matchedCredential =credentialList.stream().
              filter(credential -> credential.getUsername().equals(username)).findAny();

        PrintWriter writer=response.getWriter();
        if (matchedCredential.isPresent())
        {
            if (matchedCredential.get().getPassword().equals(password)){
              writer.println("welcome to the PC");

        }
            else{
              writer.println("The password is incorrect");
            }
            writer.println();
        }


    }

    public void destroy() {
    }
}