package jlorenzolimon.org.formulariorepintado.service;

import jlorenzolimon.org.formulariorepintado.model.Colecciones;
import jlorenzolimon.org.formulariorepintado.model.Pais;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Map;


@SpringBootTest
@AutoConfigureMockMvc
public class ServicioTest {
    @Autowired
    Servicio mi_servicio;

    @Test
    public void cuando_busque_paises_me_devuelve_paises(){
        Object paises = mi_servicio.devuelvePaises();
        Map<String, Pais> paisesMap = Colecciones.getListaPaises();
        assert (paises.equals(paisesMap));
    }
    @Test
    public void cuando_busque_aficiones_me_devuelve_aficiones(){
        Object aficiones = mi_servicio.devuelveAficiones();
        Map<String, String> aficionesMap = Colecciones.getListaAficiones();
        assert (aficiones.equals(aficionesMap));
    }
    @Test
    public void cuando_busque_paises_dos_me_devuelve_paises_dos(){
        Object paisesDos = mi_servicio.devuelvePaisesDos();
        Map<String, String> paisesDosMap = Colecciones.getListaPaisesDos();
        assert (paisesDos.equals(paisesDosMap));
    }
    @Test
    public void cuando_busque_generos_me_devuelve_generos(){
        Object generos = mi_servicio.devuelveGeneros();
        Map<String, String> generosMap = Colecciones.getListaGeneros();
        assert (generos.equals(generosMap));
    }
    @Test
    public void cuando_busque_musicas_me_devuelve_musicas(){
        Object musicas = mi_servicio.devuelveMusicas();
        Map<String, String> musicasMap = Colecciones.getListaMusicas();
        assert (musicas.equals(musicasMap));
    }
}
