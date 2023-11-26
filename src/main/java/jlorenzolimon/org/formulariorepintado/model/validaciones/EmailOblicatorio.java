package jlorenzolimon.org.formulariorepintado.model.validaciones;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import jlorenzolimon.org.formulariorepintado.model.DatosFormulario;

public class EmailOblicatorio implements ConstraintValidator<EmailOTelefono, DatosFormulario> {
    @Override
    public boolean isValid(DatosFormulario value, ConstraintValidatorContext context) {
        if (value.getTelefono().isEmpty() && value.getEmail().isEmpty())
            return false;
        if (value.getTelefono().isEmpty())
            return value.getEmail().matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+(.)[a-zA-Z]{2,}$");
        if (value.getEmail().isEmpty())
            return value.getTelefono().matches("^\\d{9}$");

        return true;
    }
}
