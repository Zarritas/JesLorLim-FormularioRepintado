package jlorenzolimon.org.formulariorepintado.Controller;
import jakarta.validation.Valid;
import jlorenzolimon.org.formulariorepintado.model.*;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import static jlorenzolimon.org.formulariorepintado.model.Colecciones.*;

import java.util.Arrays;
import java.util.Map;
@Controller
@RequestMapping("formulario")
public class Controlador {
    private int iteraciones=1;
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
    public String devuelveFormulario(@ModelAttribute("formulario") DatosFormulario datosFormulario) {
        datosFormulario.setNombre("Lola");
        datosFormulario.setPrefijoTelefonico("33");
        datosFormulario.setSiglasPais("pt");
        datosFormulario.setMusicasSeleccionadas(Arrays.asList("F", "R"));
        datosFormulario.setAficionesSelecionadas(Arrays.asList("D", "V", "P"));

        return "formulario";
    }
    @PostMapping("recibe-parametros")
    public String recibeParametrosYRepinta(Model modelo,
                                   @Valid @ModelAttribute("formulario") DatosFormulario datosFormulario,
                                   BindingResult resultadoVinculadoParametros){

        if (resultadoVinculadoParametros.hasErrors()) {
            modelo.addAttribute("mensaje_malo","ALERTA: Formulario con errores");
        }else{
            modelo.addAttribute("mensaje_bueno","ALELUYA: Formulario sin errores");
        }


        iteraciones++;
        modelo.addAttribute("iteracion",iteraciones);

        return "formulario";
    }
}