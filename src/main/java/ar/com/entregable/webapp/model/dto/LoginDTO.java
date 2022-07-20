package ar.com.entregable.webapp.model.dto;

import lombok.Data;
import lombok.Setter;

import java.io.Serializable;

@Data
@Setter
public class LoginDTO implements Serializable {
    private String username;
    private String password;
    private Boolean keepSession;
}
