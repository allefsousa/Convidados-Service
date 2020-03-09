package com.developer.allef.convidados.api;

import com.developer.allef.convidados.domain.Convidado;
import com.developer.allef.convidados.domain.ConvidadoService;
import com.developer.allef.convidados.domain.dto.ConvidadoDTO;
import org.springframework.beans.factory.annotation.Autowired;
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
