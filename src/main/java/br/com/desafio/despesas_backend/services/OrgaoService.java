package br.com.desafio.despesas_backend.services;

import br.com.desafio.despesas_backend.dto.OrgaoResponseDTO;

import java.util.List;

public interface OrgaoService {
    List<OrgaoResponseDTO> getOrgaos();
}
