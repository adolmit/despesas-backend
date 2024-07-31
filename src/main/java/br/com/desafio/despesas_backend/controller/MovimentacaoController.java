package br.com.desafio.despesas_backend.controller;

import br.com.desafio.despesas_backend.dto.MovimentacaoResponseDTO;
import br.com.desafio.despesas_backend.services.MovimentacaoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/movimentacoes")
public class MovimentacaoController {
    private final MovimentacaoService movimentacaoService;

    public MovimentacaoController(MovimentacaoService movimentacaoService){
        this.movimentacaoService=movimentacaoService;
    }
    @GetMapping
    public ResponseEntity<List<MovimentacaoResponseDTO>> getMovimentacoes(){
        return new ResponseEntity<>(this.movimentacaoService.getMovimentacoes(), HttpStatus.OK);
    }
}
