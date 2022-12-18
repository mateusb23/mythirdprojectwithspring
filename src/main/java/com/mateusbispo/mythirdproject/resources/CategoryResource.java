package com.mateusbispo.mythirdproject.resources;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mateusbispo.mythirdproject.entities.Category;
import com.mateusbispo.mythirdproject.repositories.CategoryRepository;

@RestController
@RequestMapping(value = "/categories")
public class CategoryResource {
	
	@Autowired				// ESTA ANOTAÇÃO FAZ UM PRÉ-PROCESSAMENTO POR BAIXO DOS PANOS, JÁ RESOLVENDO A DEPENDÊNCIA DE FORMA "AUTOMÁTICA" NESTA CLASSE AQUI. ELA SÓ FUNCIONOU PORQUE COLOCAMOS A ANOTAÇÃO @Component NA CLASSE CategoryRepository
	private CategoryRepository categoryRepository;				
	
 /* private final CategoryRepository categoryRepository;
	
	public CategoryResource(CategoryRepository categoryRepository) {	// LEMBRANDO QUE, AO UTILIZARMOS A INJEÇÃO DE DEPENDÊNCIA, ESTAMOS DIZENDO QUE A
		this.categoryRepository = categoryRepository;					// CLASSE CategoryResource DEPENDE DE UM OBJETO DO TIPO CategoryRepository 
	} */
	
	@GetMapping
	public ResponseEntity<List<Category>> findAll() {
		List<Category> list = categoryRepository.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Category> findById(@PathVariable Long id) {
		Category cat = categoryRepository.findById(id).get();		// IMPORTANTE OBSERVAR QUE O MÉTODO findById() DA INTERFACE JpaRepository [DO SPRING DATA JPA] RETORNA UM Optional QUE PODE OU NÃO TER UM OBJETO DENTRO DELE.
		return ResponseEntity.ok().body(cat);						// COM ISSO, POR ELE RETORNAR UM Optional, PRECISAMOS ADICIONAR UM .get() NA LINHA 37 PARA OBTER O OBJETO QUE ESTÁ DENTRO DO Optional.
	}
	
	/* 
	 *	TAMBÉM PODERÍAMOS TER FEITO DESSA FORMA QUE ESTÁ LOGO ABAIXO:
	 * 
	@GetMapping(value = "/{id}")
	public ResponseEntity<Optional<Category>> findById(@PathVariable Long id) {
		Optional<Category> cat = categoryRepository.findById(id);
		return ResponseEntity.ok().body(cat);
	} */
	
}
