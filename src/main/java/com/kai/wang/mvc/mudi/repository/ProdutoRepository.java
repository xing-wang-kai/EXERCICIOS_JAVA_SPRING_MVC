package com.kai.wang.mvc.mudi.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.kai.wang.mvc.mudi.model.Produto;
import com.kai.wang.mvc.mudi.model.Status;

@Repository
public interface ProdutoRepository extends CrudRepository<Produto, Long>{

	List<Produto> findByStatus(Status status);

}
