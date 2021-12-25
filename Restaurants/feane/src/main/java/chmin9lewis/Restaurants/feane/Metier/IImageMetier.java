package chmin9lewis.Restaurants.feane.Metier;

import java.util.List;

import chmin9lewis.Restaurants.feane.Entity.Image;

public interface IImageMetier {

	public Image getImageDetails(Long imageCode);
	public List<Image> getAllImage();
	public Image addImage(Image image);
	public Image updateImage(Image image);
	public boolean deleteImage(Image image);
	public boolean deleteImageById(Long imageCode);
	public boolean enableImage(Long imageCode);
	public boolean desableImage(Long imageCode);
	
}
