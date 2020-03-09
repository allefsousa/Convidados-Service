package com.developer.allef.convidados.domain.dto;

import com.developer.allef.convidados.domain.model.Convidado;
import lombok.Data;
import org.modelmapper.ModelMapper;

@Data
public class ConvidadoDTO {
    private Long id;
    private String name;
    private Boolean statusConfirmacao;


    public static ConvidadoDTO create(Convidado convidado){
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(convidado,ConvidadoDTO.class);
    }

}
