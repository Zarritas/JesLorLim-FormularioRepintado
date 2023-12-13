package jlorenzolimon.org.formulariorepintado.Controller;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import jlorenzolimon.org.formulariorepintado.model.*;
import jlorenzolimon.org.formulariorepintado.service.ServicioImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import static java.lang.Integer.parseInt;
import static jlorenzolimon.org.formulariorepintado.model.Colecciones.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
@Controller
@RequestMapping("formulario")
public class Controlador {

    @Autowired
    ServicioImpl mi_servicio;

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

    @GetMapping(value= "manejo-cookie")
    @ResponseBody
    public String manejoCookie(Model model,
                               HttpServletResponse respuestaHttp,
                               @CookieValue(name="contador", defaultValue="1") String contenido) {
        int num=0;
        try {
            if (!contenido.equals("0")) {
                num = parseInt(contenido);
                num++;
                contenido = String.valueOf(num);
            }
        }catch (Exception e) {
            return "Error con las Cookies";
        }
        Cookie miCookie = new Cookie("contador", contenido);
        respuestaHttp.addCookie(miCookie);

//        ResponseCookie responseCookie = ResponseCookie.from("miCookie", String.valueOf(num)).build();
//        ResponseEntity.ok().header(HttpHeaders.SET_COOKIE, responseCookie.toString()).build();

        return "El valor de la cookie es " + contenido;
    }

    private String contenidoCookie ="";
    private String usuario = "";
    private final ArrayList<Usuario> lista = new ArrayList<>();
    private int num;
    @GetMapping("login")
    public String login(){
        return "Cookies/Usuario";
    }
    @PostMapping(value = "Usuario")
    public String Usuario(@RequestParam String usuario,
                          @CookieValue(name="usuario", defaultValue="") String contenido) {
        if (contenido.isEmpty()) {
            this.usuario = usuario;
            lista.clear();
        }
        this.usuario = usuario;
        this.num = 1;
        if (!mi_servicio.devuelveCredenciales().containsKey(usuario)) {
            return "Cookies/Usuario";
        }else {
            return "Cookies/Clave";
        }
    }



    @PostMapping(value = "Clave")
    public String clave(Model model,
                          HttpServletResponse respuestaHttp,
                          @RequestParam String passw) {
        if (!mi_servicio.devuelveCredenciales().containsValue(passw)) {
            return "Cookies/Clave";
        }else {
            iniciosDeSesion();
            Cookie miCookie = new Cookie("usuario", contenidoCookie);
            respuestaHttp.addCookie(miCookie);
            model.addAttribute("sesion","Bienvenido " + usuario);
            return "Cookies/Sesion";
        }

    }
    public boolean iniciosDeSesion(){

        String [] usuarios = usuario.split("#");
        for (int i = 0; i < usuarios.length ; i++) {
            String [] partes = usuario.split("!");
            lista.add(new Usuario(parseInt(partes[0]), partes[1]));
        }


        return false;
    }
}