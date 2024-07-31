package br.com.desafio.despesas_backend.dao.repository;

import br.com.desafio.despesas_backend.dao.entity.CategoriaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<CategoriaEntity, Long> {
}