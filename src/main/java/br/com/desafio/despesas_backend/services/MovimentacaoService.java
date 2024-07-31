package br.com.desafio.despesas_backend.services;

import br.com.desafio.despesas_backend.dto.MovimentacaoPageDTO;
import br.com.desafio.despesas_backend.dto.ReporteMesDTO;

import java.util.List;

public interface MovimentacaoService {

    MovimentacaoPageDTO getMovimentacoesPagination(Integer page, Integer size);
    List<ReporteMesDTO> getReportByMonth();
}
