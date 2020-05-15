package br.fatec.exercicio.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.fatec.exercicio.model.Produto;
import br.fatec.exercicio.repository.ProdutoRepository;

@Service
public class ProdutoService implements ServiceInterface<Produto> {

	@Autowired
	private ProdutoRepository produtoRepo;
	
	@Override
	public Produto create(Produto obj) {
		produtoRepo.save(obj);
		return obj;
	}

	@Override
	public Produto findById(Long id) {
		Optional<Produto> _prod = produtoRepo.findById(id);		
		return _prod.orElse(null);
	}

	@Override
	public List<Produto> findAll() {
		List<Produto> _produtos = produtoRepo.findAll();
		return _produtos;
	}

	@Override
	public boolean update(Produto obj) {
		if (produtoRepo.existsById(obj.getId())) {
			produtoRepo.save(obj);
			return true;
		}
		return false;
	}

	@Override
	public boolean delete(Long id) {
		Optional<Produto> _prod = produtoRepo.findById(id);
		if (_prod.isPresent()) {
			produtoRepo.delete(_prod.get());
			return true;
		}
		return false;
	}

}
