package jlorenzolimon.org.formulariorepintado.Controller;
import jakarta.validation.Valid;
import jlorenzolimon.org.formulariorepintado.model.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import static jlorenzolimon.org.formulariorepintado.model.Colecciones.*;

import java.util.ArrayList;
import java.util.Map;
@Controller
@RequestMapping("formulario")
public class Controlador {
    @ModelAttribute("iteraciones")
    private Integer iteraciones(){
        Integer iteraciones = 0;
        iteraciones++;
        return iteraciones;
    }
    @ModelAttribute("lista_generos")
    private Map<String, String> devuelveListaGeneros(){
        return getListaGeneros();
    }
    @ModelAttribute("lista_paises")
    private Map<String, Pais> devuelveListaPaises(){
        return getListaPaises();
    }
    @ModelAttribute("lista_aficiones")
    private Map<String, String> devuelveListaAficiones(){
        return getListaAficiones();
    }
    @ModelAttribute("lista_musicas")
    private Map<String, String> devuelveListaMusicas(){
        return getListaMusicas();
    }

    @GetMapping("devuelve")
    public String devuelveFormulario( @ModelAttribute("formulario") DatosFormulario formulario){
        formulario.setNombre("Lola");
        formulario.setPrefijoTelefonico("33");
        formulario.setSiglasPais("pt");
        formulario.setMusicasSeleccionadas( new ArrayList<>(){{
            add("F");
            add("R");
        }});
        formulario.setAficionesSelecionadas( new ArrayList<>(){{
            add("D");
            add("V");
            add("P");
        }});
        return "formulario";
    }
    @PostMapping("recibe-parametros")
    public String recibeParametrosYRepinta(Model modelo,
                                   @Valid @ModelAttribute("formulario") DatosFormulario repintado,
                                   BindingResult resultadoVinculadoParametros){
        String mensajeEnFormulario;

        if (resultadoVinculadoParametros.hasErrors()) {mensajeEnFormulario = "El formulario tiene errores.";}else{mensajeEnFormulario = "El formulario NO tiene errores";}

        modelo.addAttribute("mensaje",mensajeEnFormulario);

        return "formulario";
    }
}