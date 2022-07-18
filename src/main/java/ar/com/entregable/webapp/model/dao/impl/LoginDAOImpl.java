package ar.com.entregable.webapp.model.dao.impl;

import ar.com.entregable.webapp.model.dao.LoginDAO;
import ar.com.entregable.webapp.model.dto.LoginDTO;
import ar.com.entregable.webapp.model.exception.IncorrectPasswordException;
import ar.com.entregable.webapp.model.exception.UsernameNotFoundException;
import lombok.NoArgsConstructor;

import java.sql.*;

@NoArgsConstructor
public class LoginDAOImpl implements LoginDAO {
    private Connection connection;

    @Override
    public void setConn(Connection conn) {
        this.connection = conn;
    }

    @Override
    public Boolean login(LoginDTO loginDTO) throws UsernameNotFoundException, IncorrectPasswordException, SQLException {
        try (PreparedStatement statement = connection
                .prepareStatement("SELECT username,password FROM users u WHERE u.username = ?")) {
            statement.setString(1, loginDTO.getUsername());
            try (ResultSet rs = statement.executeQuery()) {
                if (rs.next()) {
                    if (loginDTO.getUsername().equalsIgnoreCase(rs.getString("username"))) {
                        //TODO Encrypt-Decrypt password
                        if (loginDTO.getPassword().equals(rs.getString("password"))) {
                            return createSession(loginDTO);
                        } else {
                            throw new IncorrectPasswordException("Incorrect password!");
                        }
                    }
                }else {
                    throw new UsernameNotFoundException("Username not found!");
                }
            }
        }
        return false;
    }

    private Boolean createSession(LoginDTO loginDTO) throws SQLException {
        try(PreparedStatement statement =  connection.prepareStatement("INSERT INTO sessions (username,keep_session) VALUES (?,?)")){
            statement.setString(1,loginDTO.getUsername());
            statement.setBoolean(2,loginDTO.getKeepSession());
            if (statement.executeUpdate() == 0){
                return true;
            }else{
                return false;
            }
        }
    }

}
