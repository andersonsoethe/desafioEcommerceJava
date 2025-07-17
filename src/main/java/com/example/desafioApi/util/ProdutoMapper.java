package com.example.desafioApi.util;

import com.example.desafioApi.dto.ProdutoDTO;
import com.example.desafioApi.entity.Produto;
import org.springframework.stereotype.Component;

@Component
public class ProdutoMapper {

    public ProdutoDTO toDTO(Produto produto) {
        if (produto == null){
            return null;
        }

        ProdutoDTO dto = new ProdutoDTO();
        dto.setId(produto.getId());
        dto.setName(produto.getName());
        dto.setDescricao(produto.getDescricao());
        dto.setPreco(produto.getPreco());
        dto.setQuantidade(produto.getQuantidade());
        return dto;
    }

    public Produto toEntity(ProdutoDTO dto){
        if (dto == null){
            return null;
        }

        Produto produto = new Produto();
        produto.setId(dto.getId());
        produto.setName(dto.getName());
        produto.setDescricao(produto.getDescricao());
        produto.setPreco(dto.getPreco());
        produto.setQuantidade(dto.getQuantidade());

        return produto;
    }

    public void updateEntityFromDTO(ProdutoDTO dto, Produto produto){
        if (dto == null || produto == null) {
            return;
        }

        produto.setName(dto.getName());
        produto.setDescricao(dto.getDescricao());
        produto.setPreco(dto.getPreco());
        produto.setQuantidade(dto.getQuantidade());
    }

}
