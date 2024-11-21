package br.senai.spring.empresa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.senai.spring.empresa.model.Funcionario;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {

}
