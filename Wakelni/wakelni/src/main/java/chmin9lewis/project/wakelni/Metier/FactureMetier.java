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
	public Facture addFacture(Facture facture) {
		try {
			return factureRepository.save(facture);
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}


	@Override
	public Facture updateFacture(Facture facture) {
		try {
			return factureRepository.save(facture);
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Facture findById(Long u) {
		try {
			return factureRepository.findById(u).get();
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}



}
