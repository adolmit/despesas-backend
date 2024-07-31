package br.com.desafio.despesas_backend.services.impl;

import br.com.desafio.despesas_backend.dao.repository.ModalidadeRepository;
import br.com.desafio.despesas_backend.dto.ModalidadeResponseDTO;
import br.com.desafio.despesas_backend.services.ModalidadeService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ModalidadeServiceImpl implements ModalidadeService {
    private final ModalidadeRepository modalidadeRepository;

    public ModalidadeServiceImpl(ModalidadeRepository modalidadeRepository){
        this.modalidadeRepository=modalidadeRepository;
    }

    @Override
    public List<ModalidadeResponseDTO> getModalidades() {
        return this.modalidadeRepository.findAll()
                .stream()
                .map(it -> ModalidadeResponseDTO.builder()
                        .id(it.getId())
                        .nome(it.getNome())
                        .build()
                )
                .collect(Collectors.toList());

    }
}
