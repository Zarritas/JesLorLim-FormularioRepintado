package jlorenzolimon.org.formulariorepintado.model;

import jakarta.validation.GroupSequence;
import jakarta.validation.constraints.*;
import jlorenzolimon.org.formulariorepintado.model.validaciones.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.List;
@AllArgsConstructor @NoArgsConstructor
@Data
@ValidarClave
@EdadNumerica
@EmailOTelefono
public class DatosFormulario {
    @NotBlank
    private String nombre;
    @Size(min = 6,max = 12)
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?]).*$")
    private String clave;
    @NotBlank
    private String confirmarClave;
    @NotBlank
    private String genero;
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @NotNull
    @ValidarFnac
    private LocalDate fechaNacimiento;
    @NotNull
    private Integer edad;
    @NotNull
    private String prefijoTelefonico;
    @NotNull
    private String telefono;
    @NotNull
    private String email;
    @NotNull
    private String url;
    @NotNull
    @NotBlank
    @CodigoPaisValido
    private String siglasPais;
    @NotNull
    private List<String> archivos;
    private List<String> musicasSeleccionadas;
    private List<String> aficionesSelecionadas;
    @NotNull
    private String comentarios;
    @NotNull
    @AssertTrue
    private Boolean licencia;
}
