package br.com.desafio.despesas_backend.dao.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name="CATEGORIA")
@Data
public class CategoriaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String nome;
}
