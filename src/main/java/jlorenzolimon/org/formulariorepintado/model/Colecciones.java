package jlorenzolimon.org.formulariorepintado.model;

import lombok.*;

import java.util.HashMap;
import java.util.Map;

public class Colecciones {
    @Getter
    private static final Map<String, String> listaGeneros = new HashMap<>();
    @Getter
    private static final Map<String, Pais> listaPaises = new HashMap<>();
    @Getter
    private static final Map<String, String> listaMusicas = new HashMap<>();
    @Getter
    private static final Map<String, String> listaAficiones = new HashMap<>();
    @Getter
    private static final Map<String, String> listaPaisesDos = new HashMap<>();
    @Getter
    private static final Map<Usuario, String> credenciales = new HashMap<>();
    static{
        listaGeneros.put("F", "Femenino");
        listaGeneros.put("M", "Masculino");
        listaGeneros.put("O", "Otro");

        listaPaises.put("ES",new Pais("España","Castellano","34",true,"espania.jpg"));
        listaPaises.put("FR",new Pais("Francia","Frances","33",false,"francia.jpg"));
        listaPaises.put("IT",new Pais("Italia","Italiano","39",false,"italia.jpg"));
        listaPaises.put("PT",new Pais("Portugal","Portugués","351",false,"portugal.jpg"));
        listaPaises.put("EN",new Pais("Reino unido","Ingles","44",true,"reino_unido.jpg"));

        listaMusicas.put("E","Electrónica");
        listaMusicas.put("F","Funky");
        listaMusicas.put("N","New age");
        listaMusicas.put("P","Pop");
        listaMusicas.put("R","Rock");

        listaAficiones.put("D","Deporte");
        listaAficiones.put("L","Lectura");
        listaAficiones.put("P","Pintura");
        listaAficiones.put("V","Viajes");

        listaPaisesDos.put("ES","España");
        listaPaisesDos.put("FR","Francia");
        listaPaisesDos.put("IT","Italia");
        listaPaisesDos.put("PT","Portugal");

        credenciales.put(new Usuario("admin"),"admin");
        credenciales.put(new Usuario("user"),"user");
        credenciales.put(new Usuario("patata") ,"patata");
    }

}