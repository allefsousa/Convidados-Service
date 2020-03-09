package com.developer.allef.convidados.domain.repository;

import com.developer.allef.convidados.domain.dto.ConvidadoDTO;
import com.developer.allef.convidados.domain.model.Convidado;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ConvidadoRepository extends MongoRepository<Convidado,String> {

}
