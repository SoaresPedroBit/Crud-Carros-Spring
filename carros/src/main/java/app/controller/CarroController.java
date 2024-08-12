package app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import app.entity.Carro;
import app.service.CarroService;

@RestController
@RequestMapping("/carro")
public class CarroController {
	
	@Autowired
	private CarroService carroService;
	
	@PostMapping("/save")
	public ResponseEntity<String>save(@RequestBody Carro carro){
		
		try {
			
			String resposta = this.carroService.save(carro);
			return new ResponseEntity<String>(resposta, HttpStatus.OK);
			
		} catch (Exception e) {
			
			return new ResponseEntity<String>("Deu ruim", HttpStatus.BAD_REQUEST);
		}
		
	}
	@GetMapping("/buscaId/{id}")
	public ResponseEntity<Carro>buscaId(@PathVariable long id){
		
		try {
			
			Carro carro = this.carroService.buscaId(id);
			return new ResponseEntity<>(carro, HttpStatus.OK);
			
		} catch (Exception e) {
			
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}
	@PutMapping("/atualizar/{id}")
	public ResponseEntity<String>atualizaCarro(@RequestBody Carro carro,@PathVariable long id) {
		try {
			
			String resposta = this.carroService.atualizaCarro(carro, id); 
			return new ResponseEntity<String>(resposta, HttpStatus.OK);
			
		} catch (Exception e) {
			
			return new ResponseEntity<>("erro ao deletar", HttpStatus.BAD_REQUEST);
		}
	}
	@DeleteMapping("/deletar/{id}")
	public ResponseEntity<String> deletarCarro(@PathVariable long id) {
		
		try {
			
			String resposta = this.carroService.deletarCarro(id); 
			return new ResponseEntity<String>(resposta, HttpStatus.OK);
			
		} catch (Exception e) {
			
			return new ResponseEntity<>("erro ao deletar", HttpStatus.BAD_REQUEST);
		}
		
		
	}
	
	@GetMapping("/showAll")
	public ResponseEntity<List<Carro>>mostrarTudo(){
		
		try {
			
			List<Carro> lista = this.carroService.mostrarTudo();
			return new ResponseEntity<>(lista, HttpStatus.OK);
			
		} catch (Exception e) {
			
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
		
}
  
	
	
	
	
	
	
}
