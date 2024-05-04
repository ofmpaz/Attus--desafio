package com.desafioattus.controller;

import com.desafioattus.model.Endereco;
import com.desafioattus.model.dto.EnderecoDTO;
import com.desafioattus.service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(("/endereco"))
public class EnderecoController {

    @Autowired
    EnderecoService enderecoService;

    @PostMapping
    public ResponseEntity<EnderecoDTO> adicionaEndereo(@RequestBody EnderecoDTO enderecoDTO){

        EnderecoDTO criaEndereco = enderecoService.cadastrarEndereco(enderecoDTO);

        return new ResponseEntity<>(criaEndereco, HttpStatus.CREATED);
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

}
