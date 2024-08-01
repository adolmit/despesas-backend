package br.com.desafio.despesas_backend.dto;

import java.math.BigDecimal;

public interface RelatorioMesDTO {
    String getRelatorioMes();
    BigDecimal getRelatorioValor();
    void setRelatorioMes(String relatorioMes);
    void setRelatorioValor(BigDecimal relatorioValor);
}
