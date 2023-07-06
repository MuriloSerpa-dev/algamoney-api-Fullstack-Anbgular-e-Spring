package com.algaworks.algamoney.api.listener;

import com.algaworks.algamoney.api.event.RecursoCriadoEvent;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.context.ApplicationListener;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

public class RecursoCriadoListener implements ApplicationListener<RecursoCriadoEvent> {
    @Override
    public void onApplicationEvent(RecursoCriadoEvent event) {
        HttpServletResponse response = event.getResponse();
        Long codigo = event.getCodigo();
        adicionarHeaderLocation(response, codigo);
    }

    private static void adicionarHeaderLocation(HttpServletResponse response, Long codigo) {
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{codigo}").buildAndExpand
                (codigo).toUri();
        response.setHeader("Location",uri.toASCIIString());
    }
}
