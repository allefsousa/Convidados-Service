package com.developer.allef.convidados.domain;

import lombok.Data;

@Data
public class Convidado {
    private Long id;
    private String name;
    private Boolean statusConfirmacao;

}
