package jlorenzolimon.org.formulariorepintado.model;


import lombok.*;
import jakarta.validation.constraints.*;

import java.time.LocalDate;
import java.util.List;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Formulario {
    private int iteraciones;
    @NotNull
    @NotEmpty
    private String nombre;
    @NotNull
    @NotEmpty
    @Pattern(regexp ="(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*\\p{Punct})[A-Za-z\\d\\p{Punct}]{6,12}")
    private String clave;
    @NotNull
    @NotEmpty
    private String confirmarClave;
    @NotNull
    private String generoSeleccionado;
    @NotNull
    private LocalDate fechaNacimiento;
    private int edad;
    private String prefijoTelefonicoPais;
    private int telefonoMovil;
    private String email;
    private String url;
    @NotNull
    private List<String> paisSleccionado;
    private List<String> archivosSeleccionados;
    private List<String> musicasSeleccionadas;
    private List<String> aficionesSelecionadas;
    private String comentarios;
    private boolean licencia;

}
