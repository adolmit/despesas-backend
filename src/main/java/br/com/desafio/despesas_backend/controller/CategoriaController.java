package br.com.desafio.despesas_backend.controller;

import br.com.desafio.despesas_backend.dto.CategoriaResponseDTO;
import br.com.desafio.despesas_backend.services.CategoriaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/categorias")

public class CategoriaController {
    private final CategoriaService categoriaService;

    public CategoriaController(CategoriaService categoriaService){
        this.categoriaService=categoriaService;
    }
    @GetMapping
    public ResponseEntity<List<CategoriaResponseDTO>> getCategorias(){
        return new ResponseEntity<>(this.categoriaService.getCategorias(), HttpStatus.OK);
    }
}
