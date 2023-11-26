package jlorenzolimon.org.formulariorepintado.model.validaciones;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = EmailOblicatorio.class)
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface EmailOTelefono {
    String message() default "Es oblicatorio el campo telefono";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
