package ar.com.entregable.webapp.servlet;

import ar.com.entregable.webapp.model.dto.LoginDTO;
import ar.com.entregable.webapp.model.exception.IncorrectPasswordException;
import ar.com.entregable.webapp.model.exception.UsernameNotFoundException;
import ar.com.entregable.webapp.model.validator.LoginValidator;
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
import java.util.List;

@WebServlet(name = "signIn", urlPatterns = {"/signin","/login"})
public class signInServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html;charset=UTF-8");
        resp.sendRedirect(req.getContextPath() + "/pages/signin.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        LoginDTO loginDto =  new LoginDTO();
        loginDto.setUsername(req.getParameter("username"));
        loginDto.setPassword(req.getParameter("password"));
        loginDto.setKeepSession(Boolean.parseBoolean(req.getParameter("keepSession")));

        UserService service = new UserServiceImpl();
        LoginValidator validator = new LoginValidator(loginDto);
        List<String> errorsList = validator.validateLogin();

        try {
            if(errorsList.isEmpty()){
                if (service.login(loginDto)) {
                    //Redirect to dashboard page.
                    getServletContext().getRequestDispatcher("/index.html").forward(req,resp);
                }
            }else{
                //Error list here...
                req.setAttribute("errors",errorsList);
                getServletContext().getRequestDispatcher("/pages/signin.jsp").forward(req,resp);
            }
        } catch (SQLException e) {
            try (PrintWriter out = resp.getWriter()) {
                out.println(e.getMessage());
            }
        } catch (UsernameNotFoundException | IncorrectPasswordException e) {
            req.setAttribute("errorResponse",e);
            getServletContext().getRequestDispatcher("/pages/signin.jsp").forward(req,resp);
        }
    }
}
