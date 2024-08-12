package app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.entity.Acessorio;
import app.repository.AcessorioRepository;

@Service
public class AcessorioService {

	@Autowired
	private AcessorioRepository acessorioRepository;

	public String saveAcessorio(Acessorio acessorio) {
			
		this.acessorioRepository.save(acessorio);
		return acessorio.getNome()+ " salvo com sucesso";
	}
	

	

	public String atualizarAcessorio(long id, Acessorio acessorio) {
		
		acessorio.setId(id);
		this.acessorioRepository.save(acessorio);
		return acessorio.getNome()+ " atualizado com sucesso";
	}

	public List<Acessorio> showAllAcessorio(){
		return this.acessorioRepository.findAll();
	}

	public Acessorio buscaId(long idAcessorio) {

		Acessorio acessorio = this.acessorioRepository.findById(idAcessorio).get();
		return acessorio;

	}

	public String deletarAcessorio(long idAcessorio) {
		this.acessorioRepository.deleteById(idAcessorio);
		return "Acessorio deletado com sucesso!";

	}
	
	

}