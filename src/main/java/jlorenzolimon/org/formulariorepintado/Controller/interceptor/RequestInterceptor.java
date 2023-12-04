package jlorenzolimon.org.formulariorepintado.Controller.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component
public class RequestInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest solicitudHttp,
                             HttpServletResponse respuestaHttp,
                             Object object)  {
        System.out.println("1 - pre handle.");
        System.out.println("METHOD type:" + solicitudHttp.getMethod());
        System.out.println("Request URI: " + solicitudHttp.getRequestURI());
        System.out.println("Servlet PATH: " + solicitudHttp.getServletPath());
        //check which controller method is requested
        if(object instanceof HandlerMethod){
            //can be added different logics
            Class<?> controllerClass = ((HandlerMethod) object).getBeanType();
            String methodName = ((HandlerMethod) object).getMethod().getName();
            System.out.println("Controller name: " + controllerClass.getName());
            System.out.println("Method name:" + methodName);
        }
        // incrementando contador
//        Integer contadorModificado = Integer.parseInt(solicitudHttp.getParameter("contador"))+1;
//        solicitudHttp.setAttribute("contadorModificado",contadorModificado);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest solicitudHttp,
                           HttpServletResponse respuestaHttp,
                           Object object,
                           ModelAndView model){
        System.out.println("2 - post handle.");
        //respuestaHttp.setStatus(404);
    }

    @Override
    public void afterCompletion(HttpServletRequest solicitudHttp,
                                HttpServletResponse respuestaHttp,
                                Object object,
                                Exception exception){
        if(exception != null){
            //exception handle part
            System.out.println("ERROR ERROR ERROR!!!!!!!!!!");
        }
        System.out.println("3 - after completion.");
    }
}
