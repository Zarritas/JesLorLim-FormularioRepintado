package jlorenzolimon.org.formulariorepintado.model;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.time.LocalDate;
import java.time.Period;

class FnacValidator implements ConstraintValidator<ValidarFnac, DatosFormulario> {
    @Override
    public boolean isValid(DatosFormulario formulario, ConstraintValidatorContext context) {
        return Period.between(formulario.getFechaNacimiento(),LocalDate.now()).getYears()>18;
    }
}

