package br.com.desafio.despesas_backend.services.impl;

import br.com.desafio.despesas_backend.dao.repository.FonteRepository;
import br.com.desafio.despesas_backend.dto.FonteResponseDTO;
import br.com.desafio.despesas_backend.services.FonteService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FonteServiceImpl implements FonteService {
    private final FonteRepository fonteRepository;

    public FonteServiceImpl(FonteRepository fonteRepository){
        this.fonteRepository=fonteRepository;
    }

    @Override
    public List<FonteResponseDTO> getFontes() {
        return this.fonteRepository.findAll()
                .stream()
                .map(it -> FonteResponseDTO.builder()
                        .id(it.getId())
                        .nome(it.getNome())
                        .build()
                )
                .collect(Collectors.toList());

    }
}
