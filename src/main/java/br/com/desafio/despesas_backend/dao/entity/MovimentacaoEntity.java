package br.com.desafio.despesas_backend.dao.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name="MOVIMENTACAO")
@Data
public class MovimentacaoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private Integer ano;
    @Column
    private Integer mes;

    @OneToOne
    @JoinColumn(name = "categoria_id", referencedColumnName = "id")
    private CategoriaEntity categoria;

    @OneToOne
    @JoinColumn(name = "orgao_id", referencedColumnName = "id")
    private OrgaoEntity orgao;

    @OneToOne
    @JoinColumn(name = "modalidade_id", referencedColumnName = "id")
    private ModalidadeEntity modalidade;

    @OneToOne
    @JoinColumn(name = "fonte_id", referencedColumnName = "id")
    private FonteEntity fonte;

    @Column
    private Double valor;

    @JsonBackReference
    public CategoriaEntity getCategoria(){
        return categoria;
    }

    @JsonBackReference
    public OrgaoEntity getOrgao(){
        return orgao;
    }

    @JsonBackReference
    public ModalidadeEntity getModalidade(){
        return modalidade;
    }

    @JsonBackReference
    public FonteEntity getFonte(){
        return fonte;
    }
}