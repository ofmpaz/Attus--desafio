package com.desafioattus.controller;

import com.desafioattus.model.Pessoa;
import com.desafioattus.repository.EnderecoRepository;
import com.desafioattus.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(("/pessoa"))
public class PessoaController {


    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    EnderecoRepository enderecoRepository;

    @GetMapping("/buscaTodasPessoas")
    public ResponseEntity<List<Pessoa>> TodasPessoas(){
        try{
            List<Pessoa> listaPessoa = new ArrayList<>();
            pessoaRepository.findAll().forEach(listaPessoa::add);

            if(listaPessoa.isEmpty()){
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(listaPessoa, HttpStatus.OK);
        }
        catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }

    @GetMapping("/buscaPessoaPorId/{id}")
    public ResponseEntity<Pessoa> buscaPessoaPorId(@PathVariable Long id) {
        Optional<Pessoa> pessoa = pessoaRepository.findById(id);

        if (pessoa.isPresent()) {
            return new ResponseEntity(pessoa.get(), HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @PostMapping("/addPessoa")
    public ResponseEntity<Pessoa> adicionarPessoa(@RequestBody Pessoa pessoa){
        Pessoa pessoaObj = pessoaRepository.save(pessoa);

        return new ResponseEntity<>(pessoaObj, HttpStatus.CREATED);
    }
    @PutMapping("/atualizarPessoa/{id}")
    public ResponseEntity<Pessoa> atualizarPessoa(@PathVariable Long id, @RequestBody Pessoa novaPessoa){
        Optional<Pessoa> antigaPessoa = pessoaRepository.findById(id);

        if(antigaPessoa.isPresent()){
            Pessoa pessoaAtualizada = antigaPessoa.get();
            pessoaAtualizada.setNome(novaPessoa.getNome());
            pessoaAtualizada.setDataNascimento(novaPessoa.getDataNascimento());

            Pessoa pessoaObjeto = pessoaRepository.save(pessoaAtualizada);
            return new ResponseEntity<>(pessoaObjeto, HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}