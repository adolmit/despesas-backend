package br.com.desafio.despesas_backend.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@Builder
@Setter
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
public class ErrorGenericoDTO {
    String codigo;
    String mensaje;
}
