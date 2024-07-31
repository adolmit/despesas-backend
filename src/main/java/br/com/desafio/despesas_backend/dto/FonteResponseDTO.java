package br.com.desafio.despesas_backend.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class FonteResponseDTO {
    long id;
    String nome;
}

