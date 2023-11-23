package jlorenzolimon.org.formulariorepintado.model;

import jakarta.validation.constraints.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.List;
@AllArgsConstructor @NoArgsConstructor
@Data
@ValidarClave
public class DatosFormulario {
    @NotBlank
    private String nombre;
    @Size(min = 6,max = 12)
    @Pattern(regexp ="(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*\\p{Punct})[A-Za-z\\d\\p{Punct}]")
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
    private Integer telefono;
    @NotNull
    private String email;
    @NotNull
    private String url;
    @NotBlank
    private String siglasPais;
    @NotNull
    private List<String> archivos;
    @NotNull
    private List<String> musicasSeleccionadas;
    @NotNull
    private List<String> aficionesSelecionadas;
    @NotNull
    private String comentarios;
    @NotNull
    private Boolean licencia;
}
