package br.com.desafio.despesas_backend.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MovimentacaoResponseDTO {
    long id;
    Integer ano;
    String mes;
    CategoriaResponseDTO categoria;
    OrgaoResponseDTO orgao;
    ModalidadeResponseDTO modalidade;
    FonteResponseDTO fonte;
}
