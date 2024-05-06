package com.desafioattus.model;

import jakarta.persistence.*;
import lombok.Data;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity
@Table(schema = "SYS", name = "TB_PESSOA")
@Data
public class Pessoa {

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        @Column(name = "ID_PESSOA", unique = true, nullable = false)
        private UUID id;

        @Column(name = "Nome", nullable = false)
        private String nome;

        @Column(name = "DataNascimento")
        private Date dataNascimento;

        @OneToMany(mappedBy = "pessoa", cascade = CascadeType.ALL)
        private List<Endereco> enderecos;
}