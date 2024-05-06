package com.desafioattus.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Entity
@Table(schema = "SYS", name = "TB_PESSOA")
@Data
public class Pessoa {

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        @Column(name = "ID_PESSOA", unique = true, nullable = false)
        private Long id;

        @Column(name = "Nome", nullable = false)
        private String nome;

        @Column(name = "DataNascimento")
        private Date dataNascimento;

        @OneToMany(mappedBy = "pessoa", cascade = CascadeType.ALL)
        @JsonManagedReference
        private List<Endereco> enderecos;

        @ManyToOne
        @JoinColumn(name = "endereco_principal_id")
        private Endereco enderecoPrincipal;

        public void adicionarEndereco(Endereco endereco) {
                if (endereco != null) {
                        endereco.setPessoa(this);
                        if (this.enderecos == null) {
                                this.enderecos = new ArrayList<>();
                        }
                        this.enderecos.add(endereco);
                }
        }
}