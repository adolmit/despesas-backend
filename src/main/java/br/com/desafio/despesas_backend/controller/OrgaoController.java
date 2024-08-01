package br.com.desafio.despesas_backend.controller;

import br.com.desafio.despesas_backend.dto.OrgaoResponseDTO;
import br.com.desafio.despesas_backend.services.OrgaoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/orgaos")
public class OrgaoController {
    private final OrgaoService orgaoService;

    public OrgaoController(OrgaoService orgaoService){
        this.orgaoService=orgaoService;
    }
    @GetMapping
    public ResponseEntity<List<OrgaoResponseDTO>> getOrgaos(){
        return new ResponseEntity<>(this.orgaoService.getOrgaos(), HttpStatus.OK);
    }
}
