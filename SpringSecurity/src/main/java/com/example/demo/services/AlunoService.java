package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Aluno;
import com.example.demo.repositories.AlunoRepository;


@Service
public class AlunoService {

	@Autowired
	private AlunoRepository alunoRepository;

	public List<Aluno> getAllAlunos() {
		return alunoRepository.findAll();
	}

	public Aluno getAlunoById(long Aluno_id) {
		return alunoRepository.findById(Aluno_id).orElse(null);
	}

	public Aluno saveAluno(Aluno livro) {
		return alunoRepository.save(livro);
	}
	
	public List<Aluno> buscarPorNome(String nome) {
		return alunoRepository.buscarPorNome(nome);
	}
	public List<Aluno> buscarPorEmail(String email) {
		return alunoRepository.findByEmail(email);
	}
	
	public List<Aluno> buscarPorPhone(String phone) {
		return alunoRepository.findByPhone(phone);
	}
	public List<Aluno> buscarPorPassword(String password) {
		return alunoRepository.findByPassword(password);
	}
	
}
