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

import app.entity.Marca;
import app.service.MarcaService;

@RestController
@RequestMapping("/marca")
@CrossOrigin("*")
public class MarcaController {
	
	@Autowired
	private MarcaService marcaService;
	
	@PostMapping("/save")
	public ResponseEntity<String> save(@RequestBody Marca marca) {
		
		try {
			
			String mensagem = this.marcaService.save(marca);
			return new ResponseEntity<String>(mensagem, HttpStatus.CREATED);
			
		} catch (Exception e) {
			
			return new ResponseEntity<String>("Deu esse erro aqui: "+e.getMessage(), HttpStatus.BAD_REQUEST);
			
		}
		
	}
	
	@PutMapping("/atualiza/{id}")
	public ResponseEntity<String> atualiza(@RequestBody Marca marca, @PathVariable long id) {
		
		try {
			
			String mensagem = this.marcaService.atualiza(marca,id);
			return new ResponseEntity<String>(mensagem, HttpStatus.OK);
			
		} catch (Exception e) {
			
			return new ResponseEntity<String>("Deu ruim: "+e.getMessage(), HttpStatus.BAD_REQUEST);
			
		}
		
	}
	
	@GetMapping("/showAll")
	public ResponseEntity<List<Marca>> showAll (){
		
		try {
			
			List<Marca> lista = this.marcaService.showAll();
			return new ResponseEntity<>(lista, HttpStatus.OK);
			
		} catch (Exception e) {
			
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);

		}
		
	}
	
	@GetMapping("/buscaId/{idMarca}")
	public ResponseEntity<Marca> buscaId(@PathVariable long idMarca){
		
		try {
			
			Marca marca = this.marcaService.buscaId(idMarca);
			return new ResponseEntity<>(marca, HttpStatus.OK);
			
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
		
	}
	
	@DeleteMapping("/deletar/{idMarca}")
	public ResponseEntity<String> deletar(@PathVariable long idMarca){
		
		try {
			
			String mensagem = this.marcaService.deletar(idMarca);
			return new ResponseEntity<>(mensagem, HttpStatus.OK);
			
		} catch (Exception e) {
			return new ResponseEntity<String>("Deu esse erro aqui: "+e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		
	}
	
	
}