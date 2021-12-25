package chmin9lewis.Restaurants.feane.Metier;

import java.util.List;

import chmin9lewis.Restaurants.feane.Entity.Extras;

public interface IExtrasMetier {

	public Extras getExtrasDetails(Long extrasCode);
	public List<Extras> getAllExtras();
	public Extras addExtras(Extras extras);
	public Extras updateExtras(Extras extras);
	public boolean deleteExtras(Extras extras);
	public boolean deleteExtrasById(Long extrasCode);
	public boolean enableExtras(Long extrasCode);
	public boolean desableExtras(Long extrasCode);
	
}
