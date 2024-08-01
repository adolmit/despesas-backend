package br.com.desafio.despesas_backend.services;

import br.com.desafio.despesas_backend.dto.MovimentacaoPageDTO;

public interface MovimentacaoService {
    MovimentacaoPageDTO getMovimentacoesPagination(Integer page, Integer size);
}
