package br.com.desafio.despesas_backend.dto;

import java.math.BigDecimal;

public interface RelatorioFonteDTO {
    String getRelatorioFonte();
    BigDecimal getRelatorioValor();
    void setRelatorioFonte(String relatorioFonte);
    void setRelatorioValor(BigDecimal relatorioValor);
}
