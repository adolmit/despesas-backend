package br.com.desafio.despesas_backend.dao.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name="MODALIDADE")
@Data
public class ModalidadeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String nome;
}
