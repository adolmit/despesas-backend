package br.com.desafio.despesas_backend.dao.repository;

import br.com.desafio.despesas_backend.dao.entity.MovimentacaoEntity;
import br.com.desafio.despesas_backend.dto.RelatorioFonteDTO;
import br.com.desafio.despesas_backend.dto.RelatorioCategoriaDTO;
import br.com.desafio.despesas_backend.dto.RelatorioMesDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MovimentacaoRepository extends JpaRepository<MovimentacaoEntity, Long> {
    @Query("select  m.mes AS relatorioMes, sum(m.valor) AS relatorioValor from MovimentacaoEntity AS m " +
            " group by m.mes order by m.mes ASC")
    List<RelatorioMesDTO> getReportByMonth();

    @Query("select  C.nome AS relatorioCategoria, sum(m.valor) AS relatorioValor from MovimentacaoEntity AS m " +
            "inner join m.categoria C " +
            "group by C.nome order by C.nome ASC")
    List<RelatorioCategoriaDTO> getReportByCategory();


    @Query("select  F.nome AS relatorioFonte, sum(m.valor) AS relatorioValor from MovimentacaoEntity AS m " +
            "inner join m.fonte F " +
            "group by F.nome order by F.nome ASC")
    List<RelatorioFonteDTO> getReportBySource();

}
