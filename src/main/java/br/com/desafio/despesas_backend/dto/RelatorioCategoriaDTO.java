package br.com.desafio.despesas_backend.dto;

import java.math.BigDecimal;

public interface RelatorioCategoriaDTO {
    String getRelatorioCategoria();
    BigDecimal getRelatorioValor();
    void setRelatorioCategoria(String relatorioCategoria);
    void setRelatorioValor(BigDecimal relatorioValor);
}
