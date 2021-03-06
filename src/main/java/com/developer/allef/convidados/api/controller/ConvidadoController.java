package com.developer.allef.convidados.api.controller;

import com.developer.allef.convidados.domain.model.Convidado;
import com.developer.allef.convidados.domain.service.ConvidadoService;
import com.developer.allef.convidados.domain.dto.ConvidadoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/v1/convidados")
public class ConvidadoController {

    @Autowired
    private ConvidadoService convidadoService;

    @Value("${app.message}")
    private String appMessage;

    @GetMapping("/message")
    public String getAppMessage(){
        return  appMessage;
    }



    @GetMapping
    public ResponseEntity<List<ConvidadoDTO>> getConvidados(){
        return ResponseEntity.ok(convidadoService.getConvidados());
    }

    @PostMapping
    public ResponseEntity postConvidado(@RequestBody Convidado convidado){
        ConvidadoDTO retorno = convidadoService.saveConvidado(convidado);
        URI localtion = getUri(retorno.getId());
        return ResponseEntity.created(localtion).build();
    }
    private URI getUri(Long id){
        return ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(id).toUri();
    }
}
