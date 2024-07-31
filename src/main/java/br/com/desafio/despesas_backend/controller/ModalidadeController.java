package br.com.desafio.despesas_backend.controller;

import br.com.desafio.despesas_backend.dto.ModalidadeResponseDTO;
import br.com.desafio.despesas_backend.services.ModalidadeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/modalidades")
public class ModalidadeController {
    private final ModalidadeService modalidadeService;

    public ModalidadeController(ModalidadeService modalidadeService){
        this.modalidadeService=modalidadeService;
    }
    @GetMapping
    public ResponseEntity<List<ModalidadeResponseDTO>> getFontes(){
        return new ResponseEntity<>(this.modalidadeService.getModalidades(), HttpStatus.OK);
    }
}
