package com.kai.wang.mvc.mudi.repository;

import java.util.List;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.kai.wang.mvc.mudi.model.Produto;
import com.kai.wang.mvc.mudi.model.Status;
import com.kai.wang.mvc.mudi.model.User;

@Repository
public interface ProdutoRepository extends PagingAndSortingRepository<Produto, Long>{

	
	//@Query(value="SELECT * FROM produto WHERE user_username = :username", nativeQuery=true)
	//List<Produto> findByUser(@Param("username")String username);
	
	@Cacheable("book")
	Page<Produto> findByStatus(Status status, Pageable pagina);
	@Cacheable("book")
	Page<Produto> findByUser(User user, Pageable pagina);
	@Cacheable("book")
	List<Produto> findByStatusAndUser(Status status, User user);

}
