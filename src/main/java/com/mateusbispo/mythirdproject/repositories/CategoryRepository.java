package com.mateusbispo.mythirdproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mateusbispo.mythirdproject.entities.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> { // O JpaRepository É UM GENERIC, COM ISSO, TEMOS QUE DIZER O TIPO DA ENTIDADE E O TIPO DO ID DELA.
	// VALE SALIENTAR QUE O JpaRepository É UMA INTERFACE QUE POSSUI IMPLEMENTAÇÕES(FUNÇÕES/MÉTODOS) PADRÃO DENTRO DELA, COMO MÉTODOS PARA SALVAR(save()), BUSCAR TODOS(findAll()), BUSCAR POR ID(findById()) ETC. 
}
