package ar.com.entregable.webapp.model.dao;

import ar.com.entregable.webapp.model.dto.LoginDTO;
import ar.com.entregable.webapp.model.exception.IncorrectPasswordException;
import ar.com.entregable.webapp.model.exception.UsernameNotFoundException;

import java.sql.Connection;
import java.sql.SQLException;

public interface LoginDAO{
    void setConn(Connection conn);
    Boolean login(LoginDTO loginDTO) throws SQLException, UsernameNotFoundException, IncorrectPasswordException;
}
