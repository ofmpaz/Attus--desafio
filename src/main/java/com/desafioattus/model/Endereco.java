package com.desafioattus.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(schema = "SYS", name = "TB_ENDERECO")
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "Logradouro")
    private String logradouro;

    @Column(name = "cidade")
    private String cidade;

    @Column(name = "estado" )
    private String estado;

    @Column(name = "cep")
    private String cep;

    @Column(name = "numero" )
    private int numero;
}
