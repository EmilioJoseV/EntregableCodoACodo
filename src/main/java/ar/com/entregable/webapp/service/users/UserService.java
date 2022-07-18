package ar.com.entregable.webapp.service.users;

import ar.com.entregable.webapp.model.dto.LoginDTO;
import ar.com.entregable.webapp.model.exception.IncorrectPasswordException;
import ar.com.entregable.webapp.model.exception.UsernameNotFoundException;

import java.sql.SQLException;

public interface UserService {
    Boolean login(LoginDTO loginDTO) throws SQLException, UsernameNotFoundException, IncorrectPasswordException;

}
