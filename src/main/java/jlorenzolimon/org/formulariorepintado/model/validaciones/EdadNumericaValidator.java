package jlorenzolimon.org.formulariorepintado.model.validaciones;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import jlorenzolimon.org.formulariorepintado.model.DatosFormulario;

import java.time.LocalDate;
import java.time.Period;

public class EdadNumericaValidator implements ConstraintValidator<EdadNumerica, DatosFormulario> {


    @Override
    public boolean isValid(DatosFormulario datosFormulario, ConstraintValidatorContext context) {

        // Verifica si el valor es numérico
        if (!esNumero(String.valueOf(datosFormulario.getEdad()))) {
            return false;
        }
        if(datosFormulario.getFechaNacimiento()==null)
            return false;

        // Obtiene la edad calculada a partir del campo fecha de nacimiento
        int edadCalculada = calcularEdadDesdeFechaDeNacimiento(datosFormulario.getFechaNacimiento());

        // Compara el valor numérico con la edad calculada
        return Integer.parseInt(String.valueOf(datosFormulario.getEdad())) == edadCalculada;
    }

    private boolean esNumero(String valor) {
        try {
            Integer.parseInt(valor);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private int calcularEdadDesdeFechaDeNacimiento(LocalDate fechaNacimiento) {
        // Calcula la edad a partir de la fecha de nacimiento
        LocalDate fechaActual = LocalDate.now();
        Period periodo = Period.between(fechaNacimiento, fechaActual);
        return periodo.getYears();
    }
}