package com.developer.allef.convidados.domain.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "nome_convidados")
public class Convidado {

    @Id
    private Long id;
    private String name;
    private Boolean statusConfirmacao;

}
