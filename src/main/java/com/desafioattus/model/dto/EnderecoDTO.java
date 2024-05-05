package com.desafioattus.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EnderecoDTO {

    private UUID id;

    @NotBlank(message = "Logradouro é obrigatório")
    private String logradouro;

    @NotBlank(message = "Cep é obrigatório")
    private String cep;

    private int numero;

    @NotBlank(message = "Cidade é obrigatório")
    private String cidade;

    @NotBlank(message = "Estado é obrigatório")
    private String estado;

}
