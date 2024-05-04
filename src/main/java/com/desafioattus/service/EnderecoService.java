package com.desafioattus.service;

import com.desafioattus.mapper.EnderecoMapper;
import com.desafioattus.model.Endereco;
import com.desafioattus.model.dto.EnderecoDTO;
import com.desafioattus.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class EnderecoService {

    @Autowired
    EnderecoMapper enderecoMapper;

    @Autowired
    EnderecoRepository enderecoRepository;

    public EnderecoDTO cadastrarEndereco(EnderecoDTO enderecoDTO){

        Endereco endereco = enderecoMapper.paraEndereco(enderecoDTO);

        Endereco novoEndereco = enderecoRepository.save(endereco);

        EnderecoDTO novoEnderecoDTO = enderecoMapper.paraEnderecoDTO(novoEndereco);

        return novoEnderecoDTO;
    }

    public List<Endereco> findByLogradouroContaining(String logradouro) {
        return enderecoRepository.findByLogradouroContaining(logradouro);
    }

    public List<Endereco> buscarTodosEnderecos(){
        return enderecoRepository.findAll();
    }


}
