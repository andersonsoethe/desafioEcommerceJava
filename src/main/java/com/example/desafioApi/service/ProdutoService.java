package com.example.desafioApi.service;

import java.util.List;
import java.util.stream.Collectors;

import com.example.desafioApi.dto.ProdutoDTO;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;

import com.example.desafioApi.entity.Produto;
import com.example.desafioApi.repository.ProdutoRepository;
import com.example.desafioApi.util.ProdutoMapper;

@Service
@Transactional
public class ProdutoService {

    private final ProdutoRepository produtoRepository;
    private final ProdutoMapper produtoMapper;

    public ProdutoService(ProdutoRepository produtoRepository , ProdutoMapper produtoMapper) {
        this.produtoRepository = produtoRepository;
        this.produtoMapper = produtoMapper;
    }

    public ProdutoDTO create(ProdutoDTO produtoDTO){
        Produto produto = produtoMapper.toEntity(produtoDTO);
        Produto saveProduto = produtoRepository.save(produto);
        return produtoMapper.toDTO(saveProduto);
    }

    @Transactional(readOnly = true)
    public List<ProdutoDTO> list(){
        return produtoRepository.findAll()
                .stream()
                .map(produtoMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public ProdutoDTO findById(Long id){
        Produto produto = produtoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado com id: " +id));
        return produtoMapper.toDTO(produto);
    }

    public ProdutoDTO update(Long id, ProdutoDTO produtoDTO){
         Produto produto = produtoRepository.findById(id)
                 .orElseThrow(() -> new RuntimeException("Produto não encontrado com id: "+ id));
         produtoMapper.updateEntityFromDTO(produtoDTO, produto);
         Produto updateProduto = produtoRepository.save(produto);
         return produtoMapper.toDTO(updateProduto);
    }

    public void delete(Long id){
        if (!produtoRepository.existsById(id)) {
            throw new RuntimeException("Produto não encontrado com id: "+ id);
        }
        produtoRepository.deleteById(id);
    }

    public boolean verificarEstoqueDisponivel(Long produtoId, Integer quantidadeDesejada){
        Produto produto = produtoRepository.findById(produtoId)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado"));
        return produto.getQuantidade() >= quantidadeDesejada;
    }

    public void reduzirEstoque(Long produtoId, Integer quantidade) {
        Produto produto = produtoRepository.findById(produtoId)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado"));

        if (produto.getQuantidade() < quantidade){
            throw new RuntimeException("Estoque insuficiente");
        }

        produto.setQuantidade(produto.getQuantidade() - quantidade);
        produtoRepository.save(produto);
    }
}
