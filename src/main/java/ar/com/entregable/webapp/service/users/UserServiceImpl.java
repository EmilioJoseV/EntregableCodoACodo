package ar.com.entregable.webapp.service.users;

import ar.com.entregable.webapp.model.dao.LoginDAO;
import ar.com.entregable.webapp.model.dao.impl.LoginDAOImpl;
import ar.com.entregable.webapp.model.dto.LoginDTO;
import ar.com.entregable.webapp.model.exception.IncorrectPasswordException;
import ar.com.entregable.webapp.model.exception.UsernameNotFoundException;
import ar.com.entregable.webapp.model.sql.util.DataBaseConnection;
import java.sql.Connection;
import java.sql.SQLException;

public class UserServiceImpl implements UserService {

    private LoginDAO userSignIn;

    public UserServiceImpl() {
        this.userSignIn =new LoginDAOImpl();
    }

    @Override
    public Boolean login(LoginDTO loginDTO) throws UsernameNotFoundException, IncorrectPasswordException, SQLException {
        try(Connection connection = DataBaseConnection.getConnection()) {
            userSignIn.setConn(connection);
            if (connection.getAutoCommit()) {
                connection.setAutoCommit(false);
            }
            try {
                userSignIn.login(loginDTO);
                connection.commit();
                return true;
            } catch (SQLException e) {
                connection.rollback();
                return false;
            }

        }
    }


}
