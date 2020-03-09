package com.developer.allef.convidados.domain;


import com.developer.allef.convidados.api.exception.ObjectNotFoundException;
import com.developer.allef.convidados.domain.dto.ConvidadoDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ConvidadoService {
    private Logger logger = LoggerFactory.getLogger(ConvidadoService.class);

    @Autowired
    private ConvidadoRepository convidadoRepository;

    public ConvidadoDTO saveConvidado(Convidado convidado){
        return  ConvidadoDTO.create(convidado);
    }

    public List<ConvidadoDTO> getConvidados() {
        List<ConvidadoDTO> convidadoDTOList = convidadoRepository.findAll().stream().map(ConvidadoDTO::create).collect(Collectors.toList());
        if (convidadoDTOList.size() == 0){
            throw new ObjectNotFoundException("Nenhum Convidado Cadastrado");
        }
        return convidadoDTOList;
    }
}
