package br.com.desafio.despesas_backend.dao.repository;

import br.com.desafio.despesas_backend.dao.entity.OrgaoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrgaoRepository extends JpaRepository<OrgaoEntity, Long> {
}
