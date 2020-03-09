package com.developer.allef.convidados.domain;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface ConvidadoRepository extends MongoRepository<Convidado,String> {
}
