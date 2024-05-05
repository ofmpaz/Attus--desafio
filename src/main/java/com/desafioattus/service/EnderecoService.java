package com.desafioattus.service;

import com.desafioattus.mapper.EnderecoMapper;
import com.desafioattus.model.Endereco;
import com.desafioattus.model.Pessoa;
import com.desafioattus.model.dto.EnderecoDTO;
import com.desafioattus.model.dto.PessoaDTO;
import com.desafioattus.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.stream.events.EndElement;
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
