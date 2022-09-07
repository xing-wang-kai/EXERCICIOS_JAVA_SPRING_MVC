package com.kai.wang.mvc.mudi.service;

import java.util.List;
import java.util.Optional;

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

	public List<Produto> buscarPorStatus(Status status) {
		
		List<Produto> produtos = this.pr.findByStatus(status);
		return produtos;
	}
	public List<Produto> buscarPorUser(User user)
	{
		return this.pr.findByUser(user);
	}

	public List<Produto> buscarPorStatusEUser(Status status, User user){
		return this.pr.findByStatusAndUser(status, user);
	}
	
	public Optional<Produto> findById(Long id)
	{
		return this.pr.findById(id);
	}
}
