package com.desafioattus.mapper;

import com.desafioattus.model.Endereco;
import com.desafioattus.model.dto.EnderecoDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel =  "spring")
public interface EnderecoMapper {

    Endereco paraEndereco (EnderecoDTO enderecoDTO);

    EnderecoDTO paraEnderecoDTO (Endereco endereco);


}
