package br.com.desafio.despesas_backend.controller;

import br.com.desafio.despesas_backend.dto.CategoriaResponseDTO;
import br.com.desafio.despesas_backend.services.CategoriaService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
@WebMvcTest(CategoriaController.class)
class CategoriaControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private CategoriaService categoriaService;

    String path = "/categorias";

    @BeforeEach
    void setUp() {
    }

    @Test
    @DisplayName("dadoUmaListaDeCategoriasNoBancoDeDadosQuandoSolicitoObtenerListaCategoriasEntaoDeveRetornarOk")
    void dadoUmaListaDeCategoriasNoBancoDeDadosQuandoSolicitoObtenerListaCategoriasEntaoDeveRetornarOk() throws Exception{
        //Given
        List<CategoriaResponseDTO> categorias = categoriaDados();
         when(categoriaService.getCategorias())
                .thenReturn(categorias);

        //When
        MvcResult result = this.mockMvc.perform(
                get(this.path)
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON_UTF8)

        ).andReturn();

        //Then
        assertEquals(HttpStatus.OK.value(), result.getResponse().getStatus());

        verify(categoriaService, times(1))
                .getCategorias();
    }

    private List<CategoriaResponseDTO> categoriaDados() {
        List<CategoriaResponseDTO> response = new ArrayList<>();

        response.add(CategoriaResponseDTO.builder()
                        .id(1L)
                        .nome("CAT-1")
                        .build()
        );

        response.add(CategoriaResponseDTO.builder()
                .id(2L)
                .nome("CAT-2")
                .build()
        );

        return response;
    }
}