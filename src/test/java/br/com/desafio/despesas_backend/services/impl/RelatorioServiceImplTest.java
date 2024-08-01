package br.com.desafio.despesas_backend.services.impl;

import br.com.desafio.despesas_backend.dao.entity.CategoriaEntity;
import br.com.desafio.despesas_backend.dao.repository.CategoriaRepository;
import br.com.desafio.despesas_backend.dao.repository.MovimentacaoRepository;
import br.com.desafio.despesas_backend.dto.CategoriaResponseDTO;
import br.com.desafio.despesas_backend.dto.RelatorioMesDTO;
import br.com.desafio.despesas_backend.services.CategoriaService;
import br.com.desafio.despesas_backend.services.RelatorioService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.projection.ProjectionFactory;
import org.springframework.data.projection.SpelAwareProxyProjectionFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class RelatorioServiceImplTest {
    @Mock
    private MovimentacaoRepository repository;

    private RelatorioService service;

    @BeforeEach
    void setUp() {
        service = new RelatorioServiceImpl(repository);
    }

    @Test
    @DisplayName("Dado uma lista de movimentacoes Quando solicito o relatorio por mes Entao deve obter do banco de dados")
    public void dadoUmaListaDeMovimentacoesQuandoSolicitoORelatorioPorMesEntaoDeveObterDoBancoDeDados() {
        //given
        final List<RelatorioMesDTO> relatorio = relatorioMes();

        //when
        service.getReportByMonth();

        //then
        verify(repository, times(1))
                .getReportByMonth();
    }

    @Test
    @DisplayName("Dado uma lista de movimentacoes Quando solicito o relatorio por mes Entao deve retornar a mesma quantidade de elementos do banco")
    public void dadoUmaListaDeMovimentacoesQuandoSolicitoORelatorioPorMesEntaoDeveObterRetornarAMesmaQuantidadeDeElementosDoBanco() {
        //given
        final List<RelatorioMesDTO> relatorio = relatorioMes();
        when(repository.getReportByMonth()).thenReturn(relatorio);

        //when
        List<RelatorioMesDTO> response = service.getReportByMonth();

        //then
        assertEquals(response.size(),relatorio.size());
    }

    private List<RelatorioMesDTO> relatorioMes() {
        ProjectionFactory factory = new SpelAwareProxyProjectionFactory();
        RelatorioMesDTO relatorio1 = factory.createProjection(RelatorioMesDTO.class);
        relatorio1.setRelatorioMes("1");
        relatorio1.setRelatorioValor(new BigDecimal("1001.1"));

        RelatorioMesDTO relatorio2 = factory.createProjection(RelatorioMesDTO.class);
        relatorio2.setRelatorioMes("1");
        relatorio2.setRelatorioValor(new BigDecimal("1001.1"));

        List<RelatorioMesDTO> response = new ArrayList<>();
        response.add(relatorio1);
        response.add(relatorio2);

        return response;
    }
}