package jlorenzolimon.org.formulariorepintado.model;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({FIELD})
@Retention(RUNTIME)
@Constraint(validatedBy = FnacValidator.class)
@Documented
public @interface ValidarFnac {

    String message() default "La edad es menor a 18 años.";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };

}
