package jlorenzolimon.org.formulariorepintado.model.validaciones;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.time.LocalDate;
import java.time.Period;

class FnacValidator implements ConstraintValidator<ValidarFnac, LocalDate> {
    @Override
    public boolean isValid(LocalDate localDate, ConstraintValidatorContext context) {
        return Period.between(localDate,LocalDate.now()).getYears()>18;
    }
}

