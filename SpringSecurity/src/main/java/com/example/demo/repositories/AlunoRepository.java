package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entities.Aluno;


public interface AlunoRepository extends JpaRepository<Aluno, Long> {
	
	@Query(value = "SELECT * FROM Aluno l WHERE lower(l.nome) LIKE %:nome", nativeQuery = true)
	List<Aluno> buscarPorNome(@Param("nome") String nome);
	
	@Query(value = "SELECt l FROM Aluno l WHERE l.email = ?1")
	List<Aluno> findByEmail(String email);
	
	@Query(value = "SELECt l FROM Aluno l WHERE l.phone = ?1")
	List<Aluno> findByPhone(String phone);
	
	@Query(value = "SELECt l FROM Aluno l WHERE l.password = ?1")
	List<Aluno> findByPassword(String password);

	
	
}
