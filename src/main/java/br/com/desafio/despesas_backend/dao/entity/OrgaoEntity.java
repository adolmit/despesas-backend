package br.com.desafio.despesas_backend.dao.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name="ORGAO")
@Data
public class OrgaoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String nome;
}
