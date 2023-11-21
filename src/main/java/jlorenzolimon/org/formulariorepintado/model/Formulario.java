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
    private Integer iteraciones;
    private String nombre;
    private String clave;
    private String confirmarClave;
    private String generoSeleccionado;
    private LocalDate fechaNacimiento;
    private Integer edad;
    private String prefijoTelefonicoPais;
    private Integer telefonoMovil;
    private String email;
    private String url;
    private List<String> paisSleccionado;
    private List<String> archivosSeleccionados;
    private List<String> musicasSeleccionadas;
    private List<String> aficionesSelecionadas;
    private String comentarios;
    private Boolean licencia;
}
