package com.desafioattus.service;

import com.desafioattus.mapper.PessoaMapper;
import com.desafioattus.model.Pessoa;
import com.desafioattus.model.dto.PessoaDTO;
import com.desafioattus.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PessoaService {

    @Autowired
    PessoaRepository pessoaRepository;

    @Autowired
    PessoaMapper pessoaMapper;

    public PessoaDTO adicionarPessoa(PessoaDTO pessoaDTO) {

        Pessoa pessoa = pessoaMapper.paraPessoa(pessoaDTO);

        Pessoa registraPessoa = pessoaRepository.save(pessoa);

        PessoaDTO registrarPessoaDTO = pessoaMapper.paraPessoaDTO(registraPessoa);

        return registrarPessoaDTO;
    }

}
