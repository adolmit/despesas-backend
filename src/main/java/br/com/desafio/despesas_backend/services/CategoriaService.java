package br.com.desafio.despesas_backend.services;

import br.com.desafio.despesas_backend.dto.CategoriaResponseDTO;

import java.util.List;

public interface CategoriaService {
    List<CategoriaResponseDTO> getCategorias();
}
