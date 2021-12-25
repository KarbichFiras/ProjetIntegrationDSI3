package chmin9lewis.Restaurants.feane.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import chmin9lewis.Restaurants.feane.Entity.Image;
import chmin9lewis.Restaurants.feane.Metier.IImageMetier;

@RestController
public class ImageService {

	@Autowired
	IImageMetier imageMetier;
	
	
	@RequestMapping(value="/getImageDetails/{code}", method=RequestMethod.GET)
	public Image getImageDetails(@PathVariable(name="code") Long imageCode) {
		return imageMetier.getImageDetails(imageCode);
	}

	@RequestMapping(value="/getAllImage", method=RequestMethod.GET)
	public List<Image> getAllImage() {
		return imageMetier.getAllImage();
	}

	@RequestMapping(value="/addImage", method=RequestMethod.POST)
	public Image addImage(@RequestBody Image image) {
		return imageMetier.addImage(image);
	}

	@RequestMapping(value="/updateImage", method=RequestMethod.PUT)
	public Image updateImage(@RequestBody Image image) {
		return imageMetier.updateImage(image);
	}

	@RequestMapping(value="/deleteImage", method=RequestMethod.DELETE)
	public boolean deleteImage(@RequestBody Image image) {
		return imageMetier.deleteImage(image);
	}

	@RequestMapping(value="/deleteImageById/{code}", method=RequestMethod.DELETE)
	public boolean deleteImageById(@PathVariable(name="code") Long imageCode) {
		return imageMetier.deleteImageById(imageCode);
	}

	@RequestMapping(value="/enableImage/{code}", method=RequestMethod.PUT)
	public boolean enableImage(@PathVariable(name="code") Long imageCode) {
		return imageMetier.enableImage(imageCode);
	}

	@RequestMapping(value="/desableImage/{code}", method=RequestMethod.PUT)
	public boolean desableImage(@PathVariable(name="code") Long imageCode) {
		return imageMetier.desableImage(imageCode);
	}

}
