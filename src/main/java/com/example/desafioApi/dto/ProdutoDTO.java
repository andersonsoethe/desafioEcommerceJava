package com.example.desafioApi.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;

import java.math.BigDecimal;

public class ProdutoDTO {

    private long id;

    @NotBlank(message = "Nome do produto é obrigatório")
    private String name;

    private String descricao;

    @NotNull(message = "Preço é obrigatório")
    @Positive(message = "Preço deve ser mair que zero")
    private BigDecimal preco;

    @NotNull(message = "Quantidade é obrigatória")
    @PositiveOrZero(message = "Quantidade não pode se negativa")
    private Integer quantidade;

    public ProdutoDTO() {
    }

    public ProdutoDTO(Integer quantidade, BigDecimal preco, String descricao, String name, long id) {
        this.quantidade = quantidade;
        this.preco = preco;
        this.descricao = descricao;
        this.name = name;
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }
}
