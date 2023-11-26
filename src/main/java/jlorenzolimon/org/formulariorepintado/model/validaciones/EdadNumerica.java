package jlorenzolimon.org.formulariorepintado.model.validaciones;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = EdadNumericaValidator.class)
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface EdadNumerica {

    String message() default "El valor debe ser numérico y coincidir con la edad calculada.";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
