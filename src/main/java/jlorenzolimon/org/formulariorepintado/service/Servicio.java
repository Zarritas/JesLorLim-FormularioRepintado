package jlorenzolimon.org.formulariorepintado.service;

import jlorenzolimon.org.formulariorepintado.model.Colecciones;

import java.util.HashMap;
import java.util.Map;

public interface Servicio {
    public Object devuelvePaises();
    public Object devuelvePaisPorClave(String clave);

    public Object devuelveAficiones();
    public Object devuelveAficionPorClave(String clave);

    public Object devuelveMusicas();
    public Object devuelveMusicaPorClave(String clave);

    public Object devuelveGeneros();
    public Object devuelveGeneroPorClave(String clave);

    public Object devuelvePaisesDos();
    public Object devuelvePaisDosPorClave(String clave);
    public Map<String, String> devuelveCredenciales();
}
