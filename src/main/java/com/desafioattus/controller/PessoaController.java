package com.desafioattus.controller;

import com.desafioattus.model.dto.PessoaDTO;
import com.desafioattus.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(("/pessoa"))
public class PessoaController {

    @Autowired
    private PessoaService pessoaService;

    @PostMapping
    public ResponseEntity<PessoaDTO> adicionaPessoa(@RequestBody PessoaDTO pessoaDTO){

        PessoaDTO criarPessoa = pessoaService.adicionarPessoa(pessoaDTO);

        return new ResponseEntity<>(criarPessoa, HttpStatus.CREATED);
    }

    @GetMapping("/consultar/{nome}")
    public ResponseEntity<List<PessoaDTO>> consultarPessoaPorNome(@PathVariable String nome) {
        List<PessoaDTO> pessoasDTO = pessoaService.consultarPessoaPorNome(nome);
        return new ResponseEntity<>(pessoasDTO, HttpStatus.OK);
    }

}


