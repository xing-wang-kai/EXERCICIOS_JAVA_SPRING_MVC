package com.kai.wang.mvc.mudi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.kai.wang.mvc.mudi.model.Produto;
import com.kai.wang.mvc.mudi.model.Status;

@Repository
public interface ProdutoRepository extends PagingAndSortingRepository<Produto, Long>{

	List<Produto> findByStatus(Status status);
	
	@Query(value="SELECT * FROM produto WHERE user_username = :username", nativeQuery=true)
	List<Produto> findByUser(@Param("username")String username);

	List<Produto> findByStatusAndUser(Status status, String user);

}
