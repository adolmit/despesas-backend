package br.com.desafio.despesas_backend.services;

import br.com.desafio.despesas_backend.dto.RelatorioFonteDTO;
import br.com.desafio.despesas_backend.dto.RelatorioCategoriaDTO;
import br.com.desafio.despesas_backend.dto.RelatorioMesDTO;

import java.util.List;

public interface RelatorioService {
    List<RelatorioMesDTO> getReportByMonth();
    List<RelatorioCategoriaDTO> getReportByCategory();
    List<RelatorioFonteDTO> getReportBySource();
}
