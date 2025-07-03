package com.example.desafioAPI.service;

import java.lang.StackWalker.Option;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.desafioAPI.entity.Produto;
import com.example.desafioAPI.repository.ProdutoRepository;

@Service
public class ProdutoService {
    private ProdutoRepository produtoRepository;

    public ProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    public List<Produto> create(Produto produto){
        produtoRepository.save(produto);
        return list();
    }

    public List<Produto> list(){
        return produtoRepository.findAll();
    }

    public Produto listById(Long id){
        Optional<Produto> produto = produtoRepository.findById(id);
        return produto.orElse(null);
    }

    public List<Produto> update(Produto produto){
         produtoRepository.save(produto);
         return list();
    }

    public List<Produto> delete(Long id){
        produtoRepository.deleteById(id);
        return list();
        
    }

    

}
