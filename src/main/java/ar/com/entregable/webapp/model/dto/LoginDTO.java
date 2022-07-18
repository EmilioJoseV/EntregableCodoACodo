package ar.com.entregable.webapp.model.dto;

import lombok.Data;
import lombok.Setter;

@Data
@Setter
public class LoginDTO {
    private String username;
    private String password;
    private Boolean keepSession;
}
