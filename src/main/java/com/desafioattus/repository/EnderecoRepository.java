package com.desafioattus.repository;

import com.desafioattus.model.Endereco;
import com.desafioattus.model.dto.EnderecoDTO;;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;
import java.util.UUID;

public interface EnderecoRepository extends JpaRepository<Endereco, UUID> {

    List<Endereco> findByLogradouroContaining(String logradouro);
}
