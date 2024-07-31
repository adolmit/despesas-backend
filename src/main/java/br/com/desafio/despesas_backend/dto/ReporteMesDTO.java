package br.com.desafio.despesas_backend.dto;

import lombok.Data;

import java.math.BigDecimal;

public interface ReporteMesDTO {
    String getReporteMes();
    BigDecimal getReporteValor();
}
