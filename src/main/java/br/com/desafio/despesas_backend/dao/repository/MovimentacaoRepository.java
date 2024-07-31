package br.com.desafio.despesas_backend.dao.repository;

import br.com.desafio.despesas_backend.dao.entity.MovimentacaoEntity;
import br.com.desafio.despesas_backend.dto.ReporteMesDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MovimentacaoRepository extends JpaRepository<MovimentacaoEntity, Long> {
    @Query("select  m.mes AS reporteMes, sum(m.valor) AS reporteValor from MovimentacaoEntity AS m group by m.mes order by m.mes ASC")
    List<ReporteMesDTO> getReportByMonth();
}
