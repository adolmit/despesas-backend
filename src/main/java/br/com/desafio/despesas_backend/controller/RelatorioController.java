package br.com.desafio.despesas_backend.controller;

import br.com.desafio.despesas_backend.dto.*;
import br.com.desafio.despesas_backend.services.MovimentacaoService;
import br.com.desafio.despesas_backend.services.RelatorioService;
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
@RequestMapping("/relatorios")
public class RelatorioController {
    private final RelatorioService relatorioService;

    public RelatorioController(RelatorioService relatorioService){
        this.relatorioService=relatorioService;
    }

    @GetMapping(value="/mes")
    @Operation(summary = "Relatorio de despesas por mês",
            description = "Lista de valores das despesas por mês",
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
    public ResponseEntity<List<RelatorioMesDTO>> getReporteMes(){
        return new ResponseEntity<>(this.relatorioService.getReportByMonth(), HttpStatus.OK);
    }


    @GetMapping(value="/categoria")
    @Operation(summary = "Relatorio de despesas por categoria",
            description = "Lista de valores das despesas por categoria",
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
    public ResponseEntity<List<RelatorioCategoriaDTO>> getReporteCategoria(){
        return new ResponseEntity<>(this.relatorioService.getReportByCategory(), HttpStatus.OK);
    }

    @GetMapping(value="/fonte")
    @Operation(summary = "Relatorio de despesas por fonte",
            description = "Lista de valores das despesas por fonte",
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
    public ResponseEntity<List<RelatorioFonteDTO>> getRelatorioFonte(){
        return new ResponseEntity<>(this.relatorioService.getReportBySource(), HttpStatus.OK);
    }
}
