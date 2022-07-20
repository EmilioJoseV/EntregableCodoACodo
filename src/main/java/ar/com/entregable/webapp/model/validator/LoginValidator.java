package ar.com.entregable.webapp.model.validator;

import ar.com.entregable.webapp.model.dto.LoginDTO;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;


public class LoginValidator {
    private LoginDTO loginRequest;

    public LoginValidator(LoginDTO loginRequest) {
        this.loginRequest = loginRequest;
    }

    public List<String> validateLogin(){
        List<String> errors = new ArrayList<String>();

        if (loginRequest.getUsername() == null || loginRequest.getUsername().equals("") || loginRequest.getUsername().equals(" ")){
            errors.add(Validations.EMPTY_USERNAME.getReason());
        }

        if (loginRequest.getPassword() == null || loginRequest.getPassword().equals("") || loginRequest.getPassword().equals(" ")){
            errors.add(Validations.EMPTY_PASSWORD.getReason());
        }

        return errors;
    }
}
