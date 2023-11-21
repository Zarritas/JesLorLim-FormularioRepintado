package jlorenzolimon.org.formulariorepintado.model;

import lombok.*;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class Pais {
    private String pais, idioma, prefijoTelefonoPais;
    private Boolean muestraIdioma;
    private String nombreArchivoBandera;

}
