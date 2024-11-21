package br.senai.spring.empresa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.senai.spring.empresa.model.Dependente;

public interface DependenteRepository extends JpaRepository<Dependente, Long> {

}
