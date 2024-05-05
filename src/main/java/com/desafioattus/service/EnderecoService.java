package com.desafioattus.service;

import com.desafioattus.mapper.EnderecoMapper;
import com.desafioattus.model.Endereco;
import com.desafioattus.model.Pessoa;
import com.desafioattus.model.dto.EnderecoDTO;
import com.desafioattus.model.dto.PessoaDTO;
import com.desafioattus.repository.EnderecoRepository;
import com.desafioattus.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.stream.events.EndElement;
import java.util.List;
import java.util.UUID;


@Service
public class EnderecoService {

    @Autowired
    EnderecoMapper enderecoMapper;

    @Autowired
    EnderecoRepository enderecoRepository;

    @Autowired
    PessoaRepository pessoaRepository;

    public EnderecoDTO cadastrarEnderecoAssociado(UUID pessoaId, EnderecoDTO enderecoDTO) {
        Pessoa pessoa = pessoaRepository.findById(pessoaId)
                .orElseThrow(() -> new RuntimeException("Pessoa com ID " + pessoaId + " não encontrada"));

        Endereco endereco = enderecoMapper.paraEndereco(enderecoDTO);
        endereco.setPessoa(pessoa); // Associa o endereço à pessoa

        Endereco novoEndereco = enderecoRepository.save(endereco);

        return enderecoMapper.paraEnderecoDTO(novoEndereco);
    }


    public List<Endereco> findByLogradouroContaining(String logradouro) {
        return enderecoRepository.findByLogradouroContaining(logradouro);
    }

    public List<Endereco> buscarTodosEnderecos(){
        return enderecoRepository.findAll();
    }

    public EnderecoDTO atualizarEndereco(String logradouro, EnderecoDTO enderecoDTO) {
        List<Endereco> enderecos = enderecoRepository.findByLogradouroContaining(logradouro);

        if (enderecos.isEmpty()) {
            throw new RuntimeException("Nenhum endereço encontrado para o logradouro " + enderecos);
        }

        Endereco endereco = enderecos.get(0);
        endereco.setLogradouro(enderecoDTO.getLogradouro());
        endereco.setEstado(enderecoDTO.getEstado());
        endereco.setCidade(enderecoDTO.getCidade());
        endereco.setCep(enderecoDTO.getCep());
        endereco.setNumero(enderecoDTO.getNumero());

        Endereco enderecoAtualizado = enderecoRepository.save(endereco);
        return enderecoMapper.paraEnderecoDTO(enderecoAtualizado);
    }
}
