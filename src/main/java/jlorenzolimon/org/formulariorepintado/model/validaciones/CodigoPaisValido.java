package jlorenzolimon.org.formulariorepintado.model.validaciones;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = CodigoPaisValidator.class)
@Target({ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface CodigoPaisValido {

    String message() default "El código de país no es válido";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}