package com.desafioattus.repository;

import com.desafioattus.model.Pessoa;
import com.desafioattus.model.dto.PessoaDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;
import java.util.UUID;

public interface PessoaRepository extends JpaRepository<Pessoa, UUID> {

    @Query("SELECT new com.desafioattus.model.dto.PessoaDTO(p.id, p.nome, p.dataNascimento) FROM Pessoa p WHERE p.nome LIKE %:nome%")
    List<PessoaDTO> findDByNome(@Param("nome") String nome);

    List<Pessoa> findByNome(String nome);
}
