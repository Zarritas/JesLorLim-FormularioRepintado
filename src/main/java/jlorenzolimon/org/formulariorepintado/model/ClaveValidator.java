package jlorenzolimon.org.formulariorepintado.model;
import jakarta.validation.*;

class ClaveValidator implements ConstraintValidator<ValidarClave, DatosFormulario> {
    @Override
    public boolean isValid(DatosFormulario formulario, ConstraintValidatorContext context) {
        return formulario.getClave().equals(formulario.getConfirmarClave());
    }
}

