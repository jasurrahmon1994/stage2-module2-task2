package com.example.servlet;

import com.example.Users;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Object user = req.getAttribute("user");
        if(user != null){
            req.getRequestDispatcher("/login.jsp").forward(req, resp);
        } else {
            req.getRequestDispatcher("/user/hello.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = (String) req.getAttribute("login");
        String password = (String) req.getAttribute("password");
        List<String> users = Users.getInstance().getUsers();
        String userFound = null;
        boolean isAuth = false;
        for (String user : users) {
            if(user == login){
                isAuth = true;
                userFound = user;
            }
        }
        if(isAuth && password == ""){
            req.getSession().setAttribute("user", userFound);
            req.getRequestDispatcher("/user/hello.jsp").forward(req, resp);
        } else {
            req.getRequestDispatcher("/login.jsp");
        }
    }
}
