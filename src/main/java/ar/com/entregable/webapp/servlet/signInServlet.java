package ar.com.entregable.webapp.servlet;

import ar.com.entregable.webapp.model.dto.LoginDTO;
import ar.com.entregable.webapp.model.exception.IncorrectPasswordException;
import ar.com.entregable.webapp.model.exception.UsernameNotFoundException;
import ar.com.entregable.webapp.service.users.UserService;
import ar.com.entregable.webapp.service.users.UserServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet(name = "signIn", urlPatterns = {"/signIn","/login"})
public class signInServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        resp.sendRedirect(req.getContextPath() + "/pages/signIn.html");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        LoginDTO loginDto =  new LoginDTO();
        loginDto.setUsername(req.getParameter("username"));
        loginDto.setPassword(req.getParameter("password"));
        loginDto.setPassword(req.getParameter("keepSession"));
        UserService service = new UserServiceImpl();
        try {
            if (service.login(loginDto)) {
                //User succesfully logged in.
                resp.sendRedirect("logueado");
            }
        } catch (SQLException e) {
            //In case of DataBase error
            try (PrintWriter out = resp.getWriter()) {
                out.println(e.getMessage());
            }

        } catch (UsernameNotFoundException e) {
            //In case of Username not found
            resp.sendRedirect(e.getMessage());
        } catch (IncorrectPasswordException e) {
            //In case of Incorrect password
            resp.sendRedirect(e.getMessage());
        }


    }
}
