package jlorenzolimon.org.formulariorepintado.model;

import java.util.HashMap;
import java.util.Map;
public class Colecciones {
    private static final Map<String, String> listaGeneros = new HashMap<>();
    private static final Map<String, Pais> listaPaises = new HashMap<>();
    private static final Map<String, String> listaMusicas = new HashMap<>();
    private static final Map<String, String> listaAficiones = new HashMap<>();
    static{
        listaGeneros.put("F", "Femenino");
        listaGeneros.put("M", "Masculino");
        listaGeneros.put("O", "Otro");

        listaPaises.put("es",new Pais("España","Castellano","34",true,"espania.jpg"));
        listaPaises.put("fr",new Pais("Francia","Frances","33",false,"francia.jpg"));
        listaPaises.put("it",new Pais("Italia","Italiano","39",false,"italia.jpg"));
        listaPaises.put("pt",new Pais("Portugal","Portugués","351",false,"portugal.jpg"));
        listaPaises.put("en",new Pais("Reino unido","Ingl","44",true,"reino_unido.jpg"));

        listaMusicas.put("E","Electrónica");
        listaMusicas.put("F","Funky");
        listaMusicas.put("N","New age");
        listaMusicas.put("P","Pop");
        listaMusicas.put("R","Rock");

        listaAficiones.put("D","Deporte");
        listaAficiones.put("L","Lectura");
        listaAficiones.put("P","Pintura");
        listaAficiones.put("V","Viajes");
    }
    public static Map<String, String> getListaGeneros() {
        return listaGeneros;
    }
    public static Map<String, Pais> getListaPaises() {
        return listaPaises;
    }
    public static Map<String, String> getListaMusicas() {
        return listaMusicas;
    }
    public static Map<String, String> getListaAficiones() {
        return listaAficiones;
    }
}