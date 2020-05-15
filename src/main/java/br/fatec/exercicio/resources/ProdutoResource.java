package br.fatec.exercicio.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.fatec.exercicio.model.Produto;
import br.fatec.exercicio.services.ProdutoService;

@RestController
@RequestMapping("/produtos")
public class ProdutoResource implements ResourceInterface<Produto> {

	@Autowired
	private ProdutoService produtoService;
	
	@GetMapping
	@Override
	public ResponseEntity<List<Produto>> get() {
		return ResponseEntity.ok(produtoService.findAll());
	}

	@GetMapping(value = "/{id}")
	@Override
	public ResponseEntity<?> getId(@PathVariable("id") Long id) {
		Produto _prod = produtoService.findById(id);
		if (_prod != null) {
			return ResponseEntity.ok(_prod);
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}

	@PostMapping
	@Override
	public ResponseEntity<Produto> post(@RequestBody Produto obj) {
		produtoService.create(obj);
		return ResponseEntity.ok(obj);
	}

	@PutMapping
	@Override
	public ResponseEntity<?> put(@RequestBody Produto obj) {
		if (produtoService.update(obj)) {
			return ResponseEntity.ok(obj);
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}

	@DeleteMapping(value = "/{id}")
	@Override
	public ResponseEntity<?> delete(@PathVariable("id") Long id) {
		if (produtoService.delete(id)) {
			return ResponseEntity.ok().build();
		}		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}

}
