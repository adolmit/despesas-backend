package br.com.desafio.despesas_backend.dao.repository;

import br.com.desafio.despesas_backend.dao.entity.MovimentacaoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovimentacaoRepository extends JpaRepository<MovimentacaoEntity, Long> {
}
