package jlorenzolimon.org.formulariorepintado.model;

import lombok.*;

import java.util.Objects;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class Usuario {
    private int numero;
    private String nombre;
    public Usuario(String nombre) {
        this.nombre = nombre;
    }
    public void incrementarNumero(){
        numero++;
    }

    @Override
    public String toString() {
        return nombre+":"+numero;
    }
}
