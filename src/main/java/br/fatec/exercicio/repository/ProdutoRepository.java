package br.fatec.exercicio.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.fatec.exercicio.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long>{

}
