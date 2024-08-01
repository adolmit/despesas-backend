package br.com.desafio.despesas_backend.services.impl;

import br.com.desafio.despesas_backend.dao.entity.CategoriaEntity;
import br.com.desafio.despesas_backend.dao.repository.CategoriaRepository;
import br.com.desafio.despesas_backend.dto.CategoriaResponseDTO;
import br.com.desafio.despesas_backend.services.CategoriaService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CategoriaServiceImplTest {
    @Mock
    private CategoriaRepository repository;

    private CategoriaService service;

    @BeforeEach
    void setUp() {
        service = new CategoriaServiceImpl(repository);
    }

    @Test
    @DisplayName("Dado uma lista de categorias Quando solicito a lista de categorias Entao deve obter do banco de dados")
    public void dadoUmaListaDeCategoriasQuandoSolicitoAListaDeCategoriasEntaoDeveObterDoBancoDeDados() {
        //given
        final List<CategoriaEntity> categorias = categoriaDados();

        //when
        service.getCategorias();

        //then
        verify(repository, times(1))
                .findAll();
    }

    @Test
    @DisplayName("Dado uma lista de categorias Quando solicito a lista de categorias Entao deve retornar a mesma quantidade de elementos do banco")
    public void dadoUmaListaDeCategoriasQuandoSolicitoAListaDeCategoriasEntaoDeveObterRetornarAMesmaQuantidadeDeElementosDoBanco() {
        //given
        final List<CategoriaEntity> categorias = categoriaDados();
        when(repository.findAll()).thenReturn(categorias);

        //when
        List<CategoriaResponseDTO> response = service.getCategorias();

        //then
        assertEquals(response.size(),categorias.size());
    }

    private List<CategoriaEntity> categoriaDados() {
        List<CategoriaEntity> response = new ArrayList<>();
        CategoriaEntity categoria1 = new CategoriaEntity();
        categoria1.setId(1L);
        categoria1.setNome("CAT-1");

        CategoriaEntity categoria2 = new CategoriaEntity();
        categoria2.setId(2L);
        categoria2.setNome("CAT-2");

        response.add(categoria1);
        response.add(categoria2);

        return response;
    }
}