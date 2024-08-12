package app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.entity.Carro;
import app.repository.CarroRepository;

@Service
public class CarroService {
	 
	@Autowired
	private CarroRepository carroRepository;
	
	public  String save(Carro carro) {
		
		this.carroRepository.save(carro);
		
		return "deu bom o salvamento";
	}

	public Carro buscaId(long id) {

	Optional<Carro> carro	= this.carroRepository.findById(id);
	
	return carro.get();
		
	}
	
	public String atualizaCarro(Carro carro, long id) {
		carro.setId(id);
		this.carroRepository.save(carro);
		
		
		return "Carro atualizado com sucesso";
	}
	
	public String deletarCarro(long id) {
		this.carroRepository.deleteById(id);
		return "carro deletado com sucesso";
	}
	
	public List<Carro> mostrarTudo() {
	    List<Carro> lista = this.carroRepository.findAll();
	    return lista;
	}
	
	
	
	
}
