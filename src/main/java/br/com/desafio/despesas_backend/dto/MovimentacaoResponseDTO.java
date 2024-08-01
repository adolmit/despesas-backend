package br.com.desafio.despesas_backend.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MovimentacaoResponseDTO {
    long id;
    Integer ano;
    Integer mes;
    CategoriaResponseDTO categoria;
    OrgaoResponseDTO orgao;
    ModalidadeResponseDTO modalidade;
    FonteResponseDTO fonte;
    Double valor;
}
