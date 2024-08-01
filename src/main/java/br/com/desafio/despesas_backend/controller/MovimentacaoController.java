package br.com.desafio.despesas_backend.controller;

import br.com.desafio.despesas_backend.dto.*;
import br.com.desafio.despesas_backend.services.MovimentacaoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
    @Operation(summary = "Lista paginada de movimentacoes",
            description = "Lista paginada de movimentacoes",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Solicitação exitosa",
                            content = @Content(mediaType = "application/json",
                                    array = @ArraySchema(schema = @Schema(implementation = MovimentacaoPageDTO.class)))),
                    @ApiResponse(responseCode = "400", description = "Solicitação incorrecta",
                            content = @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = ErrorGenericoDTO.class))),
                    @ApiResponse(responseCode = "500", description = "Error interno no servidor",
                            content = @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = ErrorGenericoDTO.class)))
            })
    public ResponseEntity<MovimentacaoPageDTO> getMovimentacoes(@RequestParam("page") Integer page,
                                                                @RequestParam("size") Integer size){
        return new ResponseEntity<>(this.movimentacaoService.getMovimentacoesPagination(page, size), HttpStatus.OK);
    }
}
