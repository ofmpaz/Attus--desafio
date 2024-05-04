package com.desafioattus.controller;

import com.desafioattus.model.dto.EnderecoDTO;
import com.desafioattus.service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
