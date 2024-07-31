package br.com.desafio.despesas_backend.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;
@Data
@Builder
public class MovimentacaoPageDTO {
    int nroPaginas;
    long nroElementos;
    List<MovimentacaoResponseDTO> data;
}