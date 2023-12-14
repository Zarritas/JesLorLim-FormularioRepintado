package jlorenzolimon.org.formulariorepintado.Controller;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import jlorenzolimon.org.formulariorepintado.model.Usuario;
import jlorenzolimon.org.formulariorepintado.service.ServicioImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

import static java.lang.Integer.parseInt;
@Controller
@RequestMapping("cookies")
public class ControladorCookies {
    @Autowired
    ServicioImpl mi_servicio;
    @ModelAttribute("credenciales")

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

        return "El valor de la cookie es " + contenido;
    }



    @GetMapping("login")
    public String login(){
        return "Cookies/Usuario";
    }

    @PostMapping(value = "Usuario")
    public String Usuario(@RequestParam String nombre,
                          @ModelAttribute("usuario") Usuario usuario) {
        usuario.setNombre(nombre);
        if (!mi_servicio.devuelveCredenciales().containsKey(usuario)) {
            return "Cookies/Usuario";
        }else {
            return "Cookies/Clave";
        }
    }


    @PostMapping(value = "Clave")
    public String clave(@RequestParam String passw,
                        @ModelAttribute("usuario") Usuario usuario) {
        if (!mi_servicio.devuelveCredenciales().containsValue(passw)) {
            return "Cookies/Clave";
        }else {
            String contenidoCookie = usuario.getNombre();
            Cookie miCookie = new Cookie("inicios de sesion", usuario.getNombre());
            iniciosDeSesion();
            return "Cookies/Sesion";
        }

    }

    public void iniciosDeSesion(){
    }
}