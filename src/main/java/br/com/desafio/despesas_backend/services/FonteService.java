package br.com.desafio.despesas_backend.services;

import br.com.desafio.despesas_backend.dto.FonteResponseDTO;

import java.util.List;

public interface FonteService {
    List<FonteResponseDTO> getFontes();
}
