package chmin9lewis.project.wakelni.Metier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import chmin9lewis.project.wakelni.Entity.Facture;
import chmin9lewis.project.wakelni.Repository.FactureRepository;

@Service
public class FactureMetier implements IFactureMetier {
	 @Autowired 
	 FactureRepository factureRepository;

	@Override
	public Facture consultFacture(Long u) {
		
		return factureRepository.findById(u).get();
	}


	 



}
