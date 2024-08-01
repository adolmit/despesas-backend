package br.com.desafio.despesas_backend.services.impl;

import br.com.desafio.despesas_backend.dao.repository.CategoriaRepository;
import br.com.desafio.despesas_backend.dto.CategoriaResponseDTO;
import br.com.desafio.despesas_backend.services.CategoriaService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoriaServiceImpl implements CategoriaService {

    private final CategoriaRepository categoriaRepository;

    public CategoriaServiceImpl(CategoriaRepository categoriaRepository){
        this.categoriaRepository=categoriaRepository;
    }

    @Override
    public List<CategoriaResponseDTO> getCategorias() {
        return this.categoriaRepository.findAll()
                .stream()
                .map(it -> CategoriaResponseDTO.builder()
                        .id(it.getId())
                        .nome(it.getNome())
                        .build()
                )
                .collect(Collectors.toList());
    }
}
