package com.desafioattus.mapper;

import com.desafioattus.model.Endereco;
import com.desafioattus.model.dto.EnderecoDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel =  "spring")
public interface EnderecoMapper {

    Endereco paraEndereco (EnderecoDTO enderecoDTO);

    EnderecoDTO paraEnderecoDTO (Endereco endereco);

    List<EnderecoDTO> paraEnderecoDTOs(List<Endereco> enderecos);
}
