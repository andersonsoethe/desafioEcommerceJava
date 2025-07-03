package com.example.desafioAPI.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.desafioAPI.entity.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long>{

}
