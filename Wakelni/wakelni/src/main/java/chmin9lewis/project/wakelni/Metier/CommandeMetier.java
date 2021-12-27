package chmin9lewis.project.wakelni.Metier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import chmin9lewis.project.wakelni.Entity.Commande;
import chmin9lewis.project.wakelni.Repository.CommandeRepository;

@Service
public class CommandeMetier implements ICommandeMetier{

	@Autowired
	CommandeRepository commandeRepository;
	
	@Override
	public Commande addCommande(Commande commande) {
		try{
			return commandeRepository.save(commande);
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
