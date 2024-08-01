package br.com.desafio.despesas_backend.controller;

import br.com.desafio.despesas_backend.dto.FonteResponseDTO;
import br.com.desafio.despesas_backend.services.FonteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/fontes")
public class FonteController {
    private final FonteService fonteService;

    public FonteController(FonteService fonteService){
        this.fonteService=fonteService;
    }
    @GetMapping
    public ResponseEntity<List<FonteResponseDTO>> getFontes(){
        return new ResponseEntity<>(this.fonteService.getFontes(), HttpStatus.OK);
    }
}
