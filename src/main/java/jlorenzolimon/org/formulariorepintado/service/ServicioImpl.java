package jlorenzolimon.org.formulariorepintado.service;

import jlorenzolimon.org.formulariorepintado.model.Colecciones;
import jlorenzolimon.org.formulariorepintado.model.Usuario;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class ServicioImpl implements Servicio{
    public Object devuelvePaises(){
        return Colecciones.getListaPaises();
    }
    public Object devuelvePaisPorClave(String clave){
        return Colecciones.getListaPaises().get(clave);
    }

    public Object devuelveAficiones(){
        return Colecciones.getListaAficiones();
    }
    public Object devuelveAficionPorClave(String clave){
        return Colecciones.getListaAficiones().get(clave);
    }

    public Object devuelveMusicas(){
        return Colecciones.getListaMusicas();
    }
    public Object devuelveMusicaPorClave(String clave){
        return Colecciones.getListaMusicas().get(clave);
    }

    public Object devuelveGeneros(){
        return Colecciones.getListaGeneros();
    }
    public Object devuelveGeneroPorClave(String clave){
        return Colecciones.getListaGeneros().get(clave);
    }

    public Object devuelvePaisesDos(){
        return Colecciones.getListaPaisesDos();
    }
    public Object devuelvePaisDosPorClave(String clave){
        return Colecciones.getListaPaisesDos().get(clave);
    }

    public Map<String, String> devuelveCredenciales(){return Colecciones.getCredenciales();}
}
