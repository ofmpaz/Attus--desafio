package com.desafioattus.controller;


import com.desafioattus.model.Endereco;
import com.desafioattus.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(("/endereco"))
public class EnderecoController {

    @Autowired
    EnderecoRepository enderecoRepository;

    @GetMapping("/buscaTodosEnderecos")
    public ResponseEntity<List<Endereco>> todosEnderecos(){
        try{
            List<Endereco> listaEnderecos = new ArrayList<>();
            enderecoRepository.findAll().forEach(listaEnderecos::add);

            if(listaEnderecos.isEmpty()){
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(listaEnderecos, HttpStatus.OK);
        }
        catch(Exception ex){

            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/buscaEnderecoPorId/{id}")
    public ResponseEntity<Endereco> buscaEnderecoPorId(@PathVariable Long id){
        Optional<Endereco> endereco = enderecoRepository.findById(id);

        if(endereco.isPresent()){
            return new ResponseEntity<>(endereco.get(), HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/addEndereco")
    public ResponseEntity<Endereco> adcionarEndereco (@RequestBody Endereco endereco){
        Endereco enderecoObj = enderecoRepository.save(endereco);

        return new ResponseEntity<>(enderecoObj, HttpStatus.CREATED);
    }

    @PutMapping("/atualizaEndereco/{id}")
    public ResponseEntity<Endereco> atulizarEndereco(@PathVariable Long id, @RequestBody Endereco novoEndereco){
        Optional<Endereco> antigoEndereco = enderecoRepository.findById(id);

        if(antigoEndereco.isPresent()){
            Endereco enderecoAtualizado = antigoEndereco.get();
            enderecoAtualizado.setLogradouro(novoEndereco.getLogradouro());
            enderecoAtualizado.setCidade(novoEndereco.getCidade());
            enderecoAtualizado.setEstado(novoEndereco.getEstado());
            enderecoAtualizado.setCep(novoEndereco.getCep());
            enderecoAtualizado.setNumero(novoEndereco.getNumero());

            Endereco enderecoObj = enderecoRepository.save(enderecoAtualizado);
            return new ResponseEntity<>(enderecoObj, HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
