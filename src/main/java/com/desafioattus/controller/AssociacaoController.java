package com.desafioattus.controller;

import com.desafioattus.model.Endereco;
import com.desafioattus.model.Pessoa;
import com.desafioattus.repository.EnderecoRepository;
import com.desafioattus.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/associar")
public class AssociacaoController {

    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    private EnderecoRepository enderecoRepository;

    @PostMapping("/{pessoaId}/associarEndereco")
    public ResponseEntity<String> associarEndereco(@RequestBody Endereco endereco,
                                                   @PathVariable Long pessoaId) {

        Pessoa pessoa = pessoaRepository.findById(pessoaId)
                .orElseThrow(() -> new RuntimeException("Pessoa não encontrada com ID: " + pessoaId));
        endereco.setPessoa(pessoa);

        enderecoRepository.save(endereco);

        pessoaRepository.save(pessoa);

        return ResponseEntity.ok("Endereço associado!");
    }

    @PutMapping("/{pessoaId}/marcarEnderecoPrincipal/{enderecoId}")
    public ResponseEntity<String> marcarEnderecoPrincipal(@PathVariable Long pessoaId,
                                                          @PathVariable Long enderecoId) {

        Pessoa pessoa = pessoaRepository.findById(pessoaId)
                .orElseThrow(() -> new RuntimeException("Pessoa não encontrada com ID: " + pessoaId));

        Endereco endereco = enderecoRepository.findById(enderecoId)
                .orElseThrow(() -> new RuntimeException("Endereço não encontrado com ID: " + enderecoId));

        if (endereco.getPessoa() == null) {
            endereco.setPessoa(pessoa);
        }
        pessoa.setEnderecoPrincipal(endereco);
        pessoaRepository.save(pessoa);

        return ResponseEntity.ok("Endereço definido como principal!");
    }
}

