package com.desafioattus.repository;

import com.desafioattus.model.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface EnderecoRepository extends JpaRepository<Endereco, UUID> {

}
