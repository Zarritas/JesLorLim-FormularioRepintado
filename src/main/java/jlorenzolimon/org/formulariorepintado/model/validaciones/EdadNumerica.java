package jlorenzolimon.org.formulariorepintado.model.validaciones;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = EdadNumericaValidator.class)
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface EdadNumerica {

    String message() default "La edad debe ser la misma que la calculada en su fecha de nacimiento";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
