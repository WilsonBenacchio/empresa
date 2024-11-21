package br.senai.spring.empresa.model;

import java.util.HashSet;
import java.util.Set;

import io.micrometer.common.lang.NonNull;
import jakarta.annotation.Generated;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@Entity
public class Funcionario {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY	)

	private Long id;
	@NonNull
	@NotEmpty
	private String nome;
	@NonNull
	@NotEmpty
	@Email
	private String email;

	@OneToMany(mappedBy = "funcionario", fetch = FetchType.EAGER)
	private Set<Dependente> dependentes = new HashSet<Dependente>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Set<Dependente> getDependentes() {
		return dependentes;
	}

	public void setDependentes(Set<Dependente> dependentes) {
		this.dependentes = dependentes;
	}
	
	
}
