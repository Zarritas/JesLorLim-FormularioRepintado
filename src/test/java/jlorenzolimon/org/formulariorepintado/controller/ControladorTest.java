package jlorenzolimon.org.formulariorepintado.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class ControladorTest {
    private static final String CONTROLADOR = "http://localhost:8080/formulario";

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void giveUrl_whenGetRequest_thenFindGetResponse() throws Exception {
        String textoSolicitud = CONTROLADOR+"/ex/foos";
        String textoEsperado="Get some foos";

        MockHttpServletRequestBuilder builder = get(textoSolicitud);
        ResultMatcher contentMatcher = content().string(textoEsperado);

        this.mockMvc.perform(builder).andExpect(contentMatcher).andExpect(status().isOk());
    }

    @Test
    public void postUrl_whenGetRequest_thenFindGetResponse() throws Exception {
        String textoSolicitud = CONTROLADOR+"/ex/foos";
        String textoEsperado="Post some foos";

        MockHttpServletRequestBuilder builder = post(textoSolicitud);
        ResultMatcher contentMatcher = content().string(textoEsperado);

        this.mockMvc.perform(builder).andExpect(contentMatcher)
                .andExpect(status().isOk());
    }

    @Test
    public void saludoUrl_whenGetRequest_thenFindGetResponse() throws Exception {
        String textoSolicitud = CONTROLADOR + "/saludo";

        String nombreVistaEsperada = "saludo";
        String tipoContendioEsperado = "text/html";
        String juegoCaracteresEsperado = "charset=UTF-8";

        MockHttpServletRequestBuilder builder = get(textoSolicitud)
                .header("Accept",tipoContendioEsperado);
        this.mockMvc.perform(builder)
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content()
                        .contentType(tipoContendioEsperado+";"+juegoCaracteresEsperado)
                )
                .andExpect(view().name(nombreVistaEsperada));

    }
}
