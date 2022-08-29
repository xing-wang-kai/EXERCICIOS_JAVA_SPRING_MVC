package com.kai.wang.mvc.mudi.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.kai.wang.mvc.mudi.model.Produto;

@Repository
public interface ProdutoRepository extends CrudRepository<Produto, Long>{

}
