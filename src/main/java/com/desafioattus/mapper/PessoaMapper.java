package com.desafioattus.mapper;

import com.desafioattus.model.Pessoa;
import com.desafioattus.model.dto.PessoaDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel =  "spring")
public interface PessoaMapper {

    Pessoa paraPessoa (PessoaDTO pessoaDTO);
}
