package ar.com.entregable.webapp.model.validator;

import lombok.Getter;

@Getter
public enum Validations {
    EMPTY_USERNAME(1, "El campo de usuario es vacio"),
    EMPTY_PASSWORD(2, "El campo contraseña es vacio");

    private final Integer id;
    private final String reason;
    Validations(Integer id, String reason) {
        this.id = id;
        this.reason = reason;
    }
}
