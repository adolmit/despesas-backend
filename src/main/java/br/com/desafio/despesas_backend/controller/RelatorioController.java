package br.com.desafio.despesas_backend.controller;

import br.com.desafio.despesas_backend.dto.*;
import br.com.desafio.despesas_backend.services.MovimentacaoService;
import br.com.desafio.despesas_backend.services.RelatorioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/relatorios")
public class RelatorioController {
    private final RelatorioService relatorioService;

    public RelatorioController(RelatorioService relatorioService){
        this.relatorioService=relatorioService;
    }

    @GetMapping(value="/mes")
    public ResponseEntity<List<RelatorioMesDTO>> getReporteMes(){
        return new ResponseEntity<>(this.relatorioService.getReportByMonth(), HttpStatus.OK);
    }

    @GetMapping(value="/categoria")
    public ResponseEntity<List<RelatorioCategoriaDTO>> getReporteCategoria(){
        return new ResponseEntity<>(this.relatorioService.getReportByCategory(), HttpStatus.OK);
    }

    @GetMapping(value="/fonte")
    public ResponseEntity<List<RelatorioFonteDTO>> getRelatorioFonte(){
        return new ResponseEntity<>(this.relatorioService.getReportBySource(), HttpStatus.OK);
    }
}
