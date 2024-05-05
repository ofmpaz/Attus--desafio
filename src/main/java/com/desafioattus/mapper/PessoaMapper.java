package com.desafioattus.mapper;

import com.desafioattus.model.Endereco;
import com.desafioattus.model.Pessoa;
import com.desafioattus.model.dto.EnderecoDTO;
import com.desafioattus.model.dto.PessoaDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel =  "spring")
public interface PessoaMapper {

    EnderecoMapper enderecoMapper = Mappers.getMapper(EnderecoMapper.class);
    Pessoa paraPessoa (PessoaDTO pessoaDTO);

    PessoaDTO paraPessoaDTO (Pessoa pessoa);
    Endereco paraEndereco(EnderecoDTO enderecoDTO);
}
