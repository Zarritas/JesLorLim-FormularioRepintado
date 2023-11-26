package jlorenzolimon.org.formulariorepintado.model.validaciones;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import jlorenzolimon.org.formulariorepintado.model.Colecciones;
import jlorenzolimon.org.formulariorepintado.model.Pais;

import java.util.Map;

public class CodigoPaisValidator implements ConstraintValidator<CodigoPaisValido, String> {

    private static final Map<String, Pais> listaPaises = Colecciones.getListaPaises();

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return listaPaises.containsKey(value);
    }
}