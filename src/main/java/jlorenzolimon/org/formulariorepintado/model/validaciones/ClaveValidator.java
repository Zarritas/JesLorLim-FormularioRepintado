package jlorenzolimon.org.formulariorepintado.model.validaciones;
import jakarta.validation.*;
import jlorenzolimon.org.formulariorepintado.model.DatosFormulario;

class ClaveValidator implements ConstraintValidator<ValidarClave, DatosFormulario> {
    @Override
    public boolean isValid(DatosFormulario formulario, ConstraintValidatorContext context) {
        return formulario.getClave().equals(formulario.getConfirmarClave());
    }
}

