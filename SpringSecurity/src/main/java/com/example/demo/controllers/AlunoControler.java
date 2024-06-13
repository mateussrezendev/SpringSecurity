package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Aluno;
import com.example.demo.services.AlunoService;


@RestController
@RequestMapping("/aluno")
public class AlunoControler {

	private final AlunoService alunoService;

	@Autowired
	public AlunoControler(AlunoService alunoService) {
		this.alunoService = alunoService;
	}

	@GetMapping("/{id}")
	public ResponseEntity<Aluno> findAlunobyId(@PathVariable Long id) {
		Aluno aluno = alunoService.getAlunoById(id);
		if (aluno != null) {
			return ResponseEntity.ok(aluno);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@GetMapping("/")
	public ResponseEntity<List<Aluno>> findAllUsuarioscontrol() {
		List<Aluno> aluno = alunoService.getAllAlunos();
		return ResponseEntity.ok(aluno);
	}

	@PostMapping("/")
	public ResponseEntity<Aluno> insertAlunosControl(@RequestBody Aluno aluno) {
		Aluno novoaluno = alunoService.saveAluno(aluno);
		return ResponseEntity.status(HttpStatus.CREATED).body(novoaluno);
	}
	
	@GetMapping("/nome/{nome}")
	public List<Aluno> buscarPorNome(@PathVariable String nome){
		return alunoService.buscarPorNome(nome);
	}
	
	@GetMapping("/email/{email}")
	public List<Aluno> buscarPorEmail(@PathVariable String email){
		return alunoService.buscarPorEmail(email);
	}
	
	@GetMapping("/phone/{phone}")
	public List<Aluno> buscarPorPhone(@PathVariable String phone){
		return alunoService.buscarPorPhone(phone);
	}
	
	@GetMapping("/password/{password}")
	public List<Aluno> buscarPorPassword(@PathVariable String password){
		return alunoService.buscarPorPassword(password);
	}
	

}
