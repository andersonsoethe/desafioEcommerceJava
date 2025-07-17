package com.example.desafioApi.controller;

import com.example.desafioApi.dto.ProdutoDTO;
import com.example.desafioApi.service.ProdutoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {
    private final ProdutoService produtoService;

    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @PostMapping
    public ResponseEntity<ProdutoDTO> create(@Valid @RequestBody ProdutoDTO produtoDTO){
        ProdutoDTO created = produtoService.create(produtoDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @GetMapping
    public ResponseEntity<List<ProdutoDTO>> list() {
        List<ProdutoDTO> produtos = produtoService.list();
        return ResponseEntity.ok(produtos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProdutoDTO> listById(@PathVariable Long id){
        ProdutoDTO produto = produtoService.findById(id);
        return ResponseEntity.ok(produto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProdutoDTO> update(@PathVariable Long id,
                                             @Valid @RequestBody ProdutoDTO produtoDTO ){
        ProdutoDTO updated = produtoService.update(id, produtoDTO);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        produtoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
