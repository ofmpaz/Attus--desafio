package com.desafioattus.controller;

import com.desafioattus.model.Endereco;
import com.desafioattus.model.dto.EnderecoDTO;
import com.desafioattus.service.EnderecoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(("/endereco"))
public class EnderecoController {

    @Autowired
    EnderecoService enderecoService;

    @PostMapping("/associar")
    public ResponseEntity<EnderecoDTO> cadastrarEnderecoAssociado(
            @RequestParam("pessoaId") UUID pessoaId,
            @RequestBody EnderecoDTO enderecoDTO) {

        EnderecoDTO novoEndereco = enderecoService.cadastrarEnderecoAssociado(pessoaId, enderecoDTO);

        return new ResponseEntity<>(novoEndereco, HttpStatus.CREATED);
    }


    @GetMapping("/buscarPorLogradouro")
    public ResponseEntity<List<Endereco>> buscaEnderecoPorLogradouro(@RequestParam("logradouro") String logradouro) {
        List<Endereco> enderecoDTOS = enderecoService.findByLogradouroContaining(logradouro);
        return ResponseEntity.ok(enderecoDTOS);
    }

    @GetMapping("/buscarTodos")
    public ResponseEntity<List<Endereco>> buscarTodosEnderecos() {
        List<Endereco> enderecos = enderecoService.buscarTodosEnderecos();
        return ResponseEntity.ok(enderecos);
    }

    @PutMapping("/atualizaEndereco")
    public ResponseEntity<EnderecoDTO> atualizarEndereco(
            @RequestParam("logradouro") String logradouro,
            @RequestBody @Valid EnderecoDTO enderecoDTO) {

        EnderecoDTO enderecoAtualizado = enderecoService.atualizarEndereco(logradouro, enderecoDTO);

        return new ResponseEntity<>(enderecoAtualizado, HttpStatus.OK);
    }

}
