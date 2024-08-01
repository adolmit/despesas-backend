package br.com.desafio.despesas_backend.services.impl;

import br.com.desafio.despesas_backend.dao.repository.OrgaoRepository;
import br.com.desafio.despesas_backend.dto.OrgaoResponseDTO;
import br.com.desafio.despesas_backend.services.OrgaoService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrgaoServiceImpl implements OrgaoService {

    private final OrgaoRepository orgaoRepository;

    public OrgaoServiceImpl(OrgaoRepository orgaoRepository){
        this.orgaoRepository=orgaoRepository;
    }

    @Override
    public List<OrgaoResponseDTO> getOrgaos() {
        return this.orgaoRepository.findAll()
                .stream()
                .map(it -> OrgaoResponseDTO.builder()
                        .id(it.getId())
                        .nome(it.getNome())
                        .build()
                )
                .collect(Collectors.toList());

    }
}
