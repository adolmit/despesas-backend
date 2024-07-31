package br.com.desafio.despesas_backend.services.impl;

import br.com.desafio.despesas_backend.dao.repository.MovimentacaoRepository;
import br.com.desafio.despesas_backend.dto.*;
import br.com.desafio.despesas_backend.services.RelatorioService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RelatorioServiceImpl implements RelatorioService {
    private final MovimentacaoRepository movimentacaoRepository;

    public RelatorioServiceImpl(MovimentacaoRepository movimentacaoRepository){
        this.movimentacaoRepository=movimentacaoRepository;
    }

    @Override
    public List<RelatorioMesDTO> getReportByMonth() {
        return this.movimentacaoRepository.getReportByMonth();
    }

    @Override
    public List<RelatorioCategoriaDTO> getReportByCategory() {
        return this.movimentacaoRepository.getReportByCategory();
    }

    @Override
    public List<RelatorioFonteDTO> getReportBySource() {
        return this.movimentacaoRepository.getReportBySource();
    }
}
