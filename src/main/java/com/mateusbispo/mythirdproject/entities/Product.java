package com.mateusbispo.mythirdproject.entities;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "TB_PRODUCT")
public class Product implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PRODUCT_ID")
	private Long id;
	@Column(name = "NAME")
	private String name;
	@Column(name = "PRICE")
	private Double price;
	
	@ManyToOne				// VISTO QUE TEMOS MUITOS PRODUCTOS(Product) PARA UMA CATEGORIA(Category).
	@JoinColumn(name = "CATEGORY_ID")		// CORRESPONDE À CHAVE ESTRANGEIRA NA TABELA PRODUCT QUE SERÁ CRIADA NO BANCO DE DADOS H2
	private Category category;
	
	public Product() { }

	public Product(Long id, String name, Double price, Category category) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.category = category;
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

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
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
		Product other = (Product) obj;
		return Objects.equals(id, other.id);
	}
	
}
