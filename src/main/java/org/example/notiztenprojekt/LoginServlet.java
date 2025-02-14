package org.example.notiztenprojekt;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private final UserDAO userDAO = new UserDAO();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String benutzername = request.getParameter("benutzername");
        String password = request.getParameter("passwort");

        if (userDAO.getUser(benutzername, password)) {
            HttpSession session = request.getSession();
            session.setAttribute("benutzername", benutzername);
            response.sendRedirect("index.jsp");
        } else {
            response.sendRedirect("login.jsp?error=true");
        }
    }
}