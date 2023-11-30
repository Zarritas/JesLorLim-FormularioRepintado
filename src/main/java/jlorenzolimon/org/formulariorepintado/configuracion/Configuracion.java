package jlorenzolimon.org.formulariorepintado.configuracion;

import jlorenzolimon.org.formulariorepintado.Controller.interceptor.RequestInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class Configuracion implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registroInterceptores) {
        registroInterceptores.addInterceptor(new RequestInterceptor());
    }
}