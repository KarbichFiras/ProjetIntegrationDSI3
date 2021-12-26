package chmin9lewis.project.wakelni.Metier;

import chmin9lewis.project.wakelni.Entity.Facture;

public interface IFactureMetier {
	
	public Facture findById(Long u);
	public Facture addFacture(Facture facture);
	public Facture updateFacture(Facture facture);
	
}
