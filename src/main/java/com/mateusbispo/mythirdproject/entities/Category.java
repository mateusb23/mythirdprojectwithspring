package com.mateusbispo.mythirdproject.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "TB_CATEGORY")
public class Category implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "NAME")
	private String name;
	
	@JsonIgnore			// É UMA ANOTAÇÃO QUE VAI EFETUAR UM PRÉ-PROCESSAMENTO PRA DIZER, NESSE CASO ATUAL, QUE NÃO É PARA SERIALIZAR A LISTA DE PRODUTOS DE UMA CATEGORIA.  OBS: GERALMENTE É UTILIZADA ONDE ESTÁ A LISTA
	@OneToMany(mappedBy = "category")		// COM A ANOTAÇÃO OneToMany DEVEMOS UTILIZAR O mappedBy, ONDE SERÁ COLOCADO ENTRE ASPAS O NOME DO ATRIBUTO DO OUTRO LADO DESSA RELACÃ́O, QUE NESSE CASO É NA CLASSE Product O ATRIBUTO category QUE ESPECIFICAMOS NO @ManyToOne.
	private List<Product> products = new ArrayList<>();
	
	public Category() { }

	public Category(Long id, String name) {
		this.id = id;
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Product> getProducts() {
		return products;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Category other = (Category) obj;
		return Objects.equals(id, other.id);
	}
	
}
