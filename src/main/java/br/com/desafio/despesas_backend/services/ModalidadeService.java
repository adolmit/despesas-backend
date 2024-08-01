package br.com.desafio.despesas_backend.services;

import br.com.desafio.despesas_backend.dto.ModalidadeResponseDTO;

import java.util.List;

public interface ModalidadeService {
    List<ModalidadeResponseDTO> getModalidades();
}
