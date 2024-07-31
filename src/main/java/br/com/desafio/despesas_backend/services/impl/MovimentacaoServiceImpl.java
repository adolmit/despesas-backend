package br.com.desafio.despesas_backend.services.impl;

import br.com.desafio.despesas_backend.dao.entity.MovimentacaoEntity;
import br.com.desafio.despesas_backend.dao.repository.MovimentacaoRepository;
import br.com.desafio.despesas_backend.dto.*;
import br.com.desafio.despesas_backend.services.MovimentacaoService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MovimentacaoServiceImpl implements MovimentacaoService {
    private final MovimentacaoRepository movimentacaoRepository;

    public MovimentacaoServiceImpl(MovimentacaoRepository movimentacaoRepository){
        this.movimentacaoRepository=movimentacaoRepository;
    }

    @Override
    public MovimentacaoPageDTO getMovimentacoesPagination(Integer page, Integer size) {
        Page<MovimentacaoEntity> pageMovimentacao =this.movimentacaoRepository.findAll(PageRequest.of(page-1,size));

        return
                MovimentacaoPageDTO.builder()
                        .nroPaginas(pageMovimentacao.getTotalPages())
                        .nroElementos(pageMovimentacao.getTotalElements())
                        .data(
                                pageMovimentacao.get()
                                        .map(it -> MovimentacaoResponseDTO.builder()
                                                .id(it.getId())
                                                .ano(it.getAno())
                                                .mes(it.getMes())
                                                .categoria(
                                                        CategoriaResponseDTO.builder()
                                                                .id(it.getCategoria().getId())
                                                                .nome(it.getCategoria().getNome())
                                                                .build()
                                                )
                                                .orgao(
                                                        OrgaoResponseDTO.builder()
                                                                .id(it.getOrgao().getId())
                                                                .nome(it.getOrgao().getNome())
                                                                .build()
                                                )
                                                .modalidade(
                                                        ModalidadeResponseDTO.builder()
                                                                .id(it.getModalidade().getId())
                                                                .nome(it.getModalidade().getNome())
                                                                .build()
                                                )
                                                .fonte(
                                                        FonteResponseDTO.builder()
                                                                .id(it.getFonte().getId())
                                                                .nome(it.getFonte().getNome())
                                                                .build()
                                                )
                                                .valor(it.getValor())
                                                .build()
                                        )
                                        .collect(Collectors.toList())
                        )
                        .build();
    }

    @Override
    public List<ReporteMesDTO> getReportByMonth() {
        return this.movimentacaoRepository.getReportByMonth();
    }
}
