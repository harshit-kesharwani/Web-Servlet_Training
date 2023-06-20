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

@WebServlet(name = "SignupServlet", value = "/Signup-servlet")
public class SignupServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

    }
    @Override
    protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        BufferedReader credentialReader = Files.newBufferedReader(Paths.get("C:\\Users\\Harsh\\IdeaProjects\\Bootcamp\\Javawebapptraiining\\data\\credentials.csv"));
        String Line;
        List<Credential> credentialList = new ArrayList<>();
        while ((Line = credentialReader.readLine()) != null) {
            String[] credentialData = Line.split(",");
            credentialList.add(new Credential(credentialData[0], credentialData[1]));
        }
        credentialList.add(new Credential(username, password));
        BufferedWriter credentialWritter = Files.newBufferedWriter(Paths.get("C:\\Users\\Harsh\\IdeaProjects\\Bootcamp\\Javawebapptraiining\\data\\credentials.csv"));
        for (Credential credential : credentialList) {
            credentialWritter.write(credential.getUsername() + "," + credential.getPassword());
            credentialWritter.newLine();

        }
        credentialWritter.flush();
    }}