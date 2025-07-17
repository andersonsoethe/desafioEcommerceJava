package com.example.desafioApi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.desafioApi.entity.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long>{

}
