package br.com.desafio.despesas_backend.services;

import br.com.desafio.despesas_backend.dto.MovimentacaoResponseDTO;

import java.util.List;

public interface MovimentacaoService {
    List<MovimentacaoResponseDTO> getMovimentacoes();
}
