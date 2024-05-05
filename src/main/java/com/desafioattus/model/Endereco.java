package com.desafioattus.model;

import jakarta.persistence.*;
import lombok.Data;
import java.util.UUID;

@Entity
@Table(schema = "SYS", name = "TB_ENDERECO")
@Data
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "Logradouro", nullable = false)
    private String logradouro;

    @Column(name = "Cep", nullable = false)
    private String cep;

    @Column(name = "numero")
    private int numero;

    @Column(name = "Cidade", nullable = false)
    private String cidade;

    @Column(name = "Estado", nullable = false)
    private String estado;

    @ManyToOne // Define a relação muitos para um com Pessoa
    @JoinColumn(name = "pessoa_id") // Nome da coluna que armazena o ID da pessoa
    private Pessoa pessoa; // Campo que representa a pessoa associada ao endereço

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }
}