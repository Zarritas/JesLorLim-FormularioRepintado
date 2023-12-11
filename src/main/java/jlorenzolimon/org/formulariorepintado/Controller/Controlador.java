package jlorenzolimon.org.formulariorepintado.Controller;
import jakarta.validation.Valid;
import jlorenzolimon.org.formulariorepintado.model.*;
import jlorenzolimon.org.formulariorepintado.service.ServicioImpl;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    ServicioImpl mi_servicio;

    //Creacion de las Colecciones
    @ModelAttribute("lista_generos")
    private Map<String, String> devuelveListaGeneros() {
        return getListaGeneros();
    }

    @ModelAttribute("lista_paises")
    private Map<String, Pais> devuelveListaPaises() {
        return getListaPaises();
    }

    @ModelAttribute("lista_aficiones")
    private Map<String, String> devuelveListaAficiones() {
        return getListaAficiones();
    }

    @ModelAttribute("lista_musicas")
    private Map<String, String> devuelveListaMusicas() {
        return getListaMusicas();
    }

    //Metodo desde el que empieza el formulario nada más cargamos la web
    @GetMapping("devuelve")
    public String devuelveFormulario(Model model, @ModelAttribute("formulario") DatosFormulario datosFormulario) {
        //Valores por defecto
        datosFormulario.setNombre("Lola");
        datosFormulario.setPrefijoTelefonico("33");
        datosFormulario.setSiglasPais("pt");
        datosFormulario.setMusicasSeleccionadas(Arrays.asList("F", "R"));
        datosFormulario.setAficionesSelecionadas(Arrays.asList("D", "V", "P"));
        model.addAttribute("iteracion", 1);
        return "formulario";
    }

    //Metodo al que llama el formulario en el submit
    @PostMapping("recibe-parametros")
    public String recibeParametrosYRepinta(
            Model modelo,
            @RequestParam int iteracion,
            @Valid @ModelAttribute("formulario") DatosFormulario datosFormulario,
            BindingResult resultadoVinculadoParametros) {
        //Mensajes de error en caso de que los tengamos
        if (resultadoVinculadoParametros.hasErrors()) {
            modelo.addAttribute("mensaje_malo", "ALERTA: Formulario con errores");
        } else {
            modelo.addAttribute("mensaje_bueno", "ALELUYA: Formulario sin errores");
        }
        //Incrementacion de iteraciones y añadirlas al formulario
        iteracion++;
        modelo.addAttribute("iteracion", iteracion);

        return "formulario";
    }

    @PostMapping("hola-amigo")
    @ResponseBody
    //curl -i -X POST http://localhost:8080/formulario/hola-amigo
    public String saludoPersonalizado(@RequestParam String nombre) {
        return "Hola " + nombre;
    }

    @GetMapping("saludo")
    //curl -i http://localhost:8080/formulario/saludo
    public String saludo() {
        return "saludo";
    }

    @GetMapping("/ex/foos")
    @ResponseBody
    //curl -i http://localhost:8080/formulario/ex/foos
    public String getFoosBySimplePath() {
        return "Get some foos";
    }

    @PostMapping("/ex/foos")
    @ResponseBody
    //curl -i -X POST http://localhost:8080/formulario/ex/foos
    public String postFoosBySimplePath() {
        return "Post some foos";
    }


    @GetMapping("devuelve-paises-dos")
    @ResponseBody
    //curl -i -X POST http://localhost:8080/formulario/devuelve-paises-dos
    public Object devuelvePaisesDos(String clave) {
        if (clave != null)
            return mi_servicio.devuelvePaisDosPorClave(clave);
        else
            return mi_servicio.devuelvePaisesDos();
    }
    @GetMapping("devuelve-musicas")
    @ResponseBody
    //curl -i -X POST http://localhost:8080/formulario/devuelve-musicas
    public Object devuelveMusicas(String clave) {
        if (clave != null)
            return mi_servicio.devuelveMusicaPorClave(clave);
        else
            return mi_servicio.devuelveMusicas();
    }
    @GetMapping("devuelve-aficiones")
    @ResponseBody
    //curl -i -X POST http://localhost:8080/formulario/devuelve-aficiones
    public Object devuelveAficiones(String clave) {
        if (clave != null)
            return mi_servicio.devuelveAficionPorClave(clave);
        else
            return mi_servicio.devuelveAficiones();
    }
    @GetMapping("devuelve-paises")
    @ResponseBody
    //curl -i -X POST http://localhost:8080/formulario/devuelve-paises
    public Object devuelvePaises(String clave) {
        if (clave != null)
            return mi_servicio.devuelvePaisPorClave(clave);
        else
            return mi_servicio.devuelvePaises();
    }
    @GetMapping("devuelve-generos")
    @ResponseBody
    //curl -i -X POST http://localhost:8080/formulario/devuelve-generos
    public Object devuelveGeneros(String clave) {
        if (clave != null)
            return mi_servicio.devuelveGeneroPorClave(clave);
        else
            return mi_servicio.devuelveGeneros();
    }
}