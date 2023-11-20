package jlorenzolimon.org.formulariorepintado.Controller;

import jakarta.validation.Valid;
import jlorenzolimon.org.formulariorepintado.model.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import static jlorenzolimon.org.formulariorepintado.model.Colecciones.*;

import java.util.Map;

@Controller
public class Controlador {
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

    @GetMapping("formulario")
    public String formulario( @ModelAttribute("formulario") Formulario formulario){
        return "formulario";
    }
    @PostMapping("repintado")
    public String recibeParametros(Model modelo,
                                   @Valid @ModelAttribute("formulario") Formulario repintado,
                                   BindingResult resultadoVinculadoParametros){
        String mensajeEnFormulario;
        if (resultadoVinculadoParametros.hasErrors()) {
            mensajeEnFormulario = "El formulario tiene errores.";
        }else {
            mensajeEnFormulario = "El formulario NO tiene errores";
        }
        modelo.addAttribute("mensaje",mensajeEnFormulario);

        return "formulario";
    }
}
