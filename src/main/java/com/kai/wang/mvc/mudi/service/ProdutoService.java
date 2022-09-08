package com.kai.wang.mvc.mudi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.kai.wang.mvc.mudi.model.Produto;
import com.kai.wang.mvc.mudi.model.Status;
import com.kai.wang.mvc.mudi.model.User;
import com.kai.wang.mvc.mudi.repository.ProdutoRepository;

@Service
public class ProdutoService {
	
	private final ProdutoRepository pr;
	public ProdutoService(ProdutoRepository pr)
	{
		this.pr = pr;
	}
	
	public void adicionar(Produto produto) 
	{
		this.pr.save(produto);
	}
	public void editar(Produto produto, Long id)
	{
		produto.setId(id);
		this.pr.save(produto);
	}
	
	public List<Produto> buscar()
	{
		return (List<Produto>) this.pr.findAll();
	}
	public void remover(Long id) 
	{
		this.pr.deleteById(id);
	}

	public Page<Produto> buscarPorStatus(Status status) {
		
		Pageable pagina = PageRequest.of(0, 5, Sort.by(Sort.Direction.ASC, "status"));
		Page<Produto> produtos = this.pr.findByStatus(status, pagina);
		return produtos;
	}
	public Page<Produto> buscarPorUser(User user)
	{
		Pageable pagina = PageRequest.of(0, 5, Sort.by(Sort.Direction.ASC, "status"));
		return this.pr.findByUser(user, pagina);
	}

	public List<Produto> buscarPorStatusEUser(Status status, User user){
		return this.pr.findByStatusAndUser(status, user);
	}
	
	public Optional<Produto> findById(Long id)
	{
		return this.pr.findById(id);
	}
}
