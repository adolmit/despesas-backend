package br.com.desafio.despesas_backend.dao.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name="FONTE")
@Data
public class FonteEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String nome;
}