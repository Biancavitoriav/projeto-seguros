package com.example.projetoseguros.repositories;

import com.example.projetoseguros.model.Cpf;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CpfRepository extends MongoRepository<Cpf, String> {
}
