package app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import app.entity.Acessorio;
import app.service.AcessorioService;

@RestController
@RequestMapping("/acessorio")
@CrossOrigin("*")
public class AcessorioController {
	
	@Autowired
	private AcessorioService acessorioService;
	
	@PostMapping("/save")
	public ResponseEntity<String> save(@RequestBody Acessorio acessorio) {
		
		try {
			
			String mensagem = this.acessorioService.saveAcessorio(acessorio);
			return new ResponseEntity<String>(mensagem, HttpStatus.CREATED);
			
		} catch (Exception e) {
			
			return new ResponseEntity<String>("Deu esse erro aqui: "+e.getMessage(), HttpStatus.BAD_REQUEST);
			
		}
		
	}
	
	@PutMapping("/atualiza/{id}")
	public ResponseEntity<String> atualizar(@RequestBody Acessorio acessorio, @PathVariable int id) {
		
		try {
			
			String mensagem = this.acessorioService.atualizarAcessorio(id, acessorio);
			return new ResponseEntity<String>(mensagem, HttpStatus.OK);
			
		} catch (Exception e) {
			
			return new ResponseEntity<String>("Deu esse erro aqui: "+e.getMessage(), HttpStatus.BAD_REQUEST);
			
		}
		
	}
	
	@GetMapping("/showAll")
	public ResponseEntity<List<Acessorio>> showAllAcessorio (){
		
		try {
			
			List<Acessorio> lista = this.acessorioService.showAllAcessorio();
			return new ResponseEntity<>(lista, HttpStatus.OK);
			
		} catch (Exception e) {
			
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);

		}
		
	}
	
	@GetMapping("/buscaId/{idAcessorio}")
	public ResponseEntity<Acessorio> buscaIdAcessorio(@PathVariable long idAcessorio){
		
		try {
			
			Acessorio acessorio = this.acessorioService.buscaId(idAcessorio);
			return new ResponseEntity<>(acessorio, HttpStatus.OK);
			
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
		
	}
	
	@DeleteMapping("/deletar/{idAcessorio}")
	public ResponseEntity<String> deletar(@PathVariable long idAcessorio){
		
		try {
			
			String mensagem = this.acessorioService.deletarAcessorio(idAcessorio);
			return new ResponseEntity<>(mensagem, HttpStatus.OK);
			
		} catch (Exception e) {
			return new ResponseEntity<String>("Deu esse erro aqui: "+e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		
	}
	
	
}