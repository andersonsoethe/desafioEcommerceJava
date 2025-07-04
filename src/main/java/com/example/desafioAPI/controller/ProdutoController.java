package com.example.desafioAPI.controller;

import com.example.desafioAPI.entity.Produto;
import com.example.desafioAPI.service.ProdutoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produto")
public class ProdutoController {
    ProdutoService produtoService;

    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @PostMapping
    public List<Produto> create(@RequestBody Produto produto) {
        return produtoService.create(produto);
    }

    @GetMapping
    public List<Produto> list() {
        return produtoService.list();
    }

    @GetMapping("{id}")
    public Produto listById(@PathVariable("id") Long id) {
        return produtoService.listById(id);
    }

    @PutMapping
    public List<Produto> update(@RequestBody Produto produto) {
        return produtoService.update(produto);
    }

    @DeleteMapping("{id}")
    public List<Produto> delete(@PathVariable("id") Long id) {
        return produtoService.delete(id);
    }



}
