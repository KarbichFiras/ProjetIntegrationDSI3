package chmin9lewis.Restaurants.feane.Metier;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import chmin9lewis.Restaurants.feane.Entity.Image;
import chmin9lewis.Restaurants.feane.Repository.ImageRepository;

@Service
public class ImageMetier implements IImageMetier{

	@Autowired
	ImageRepository imageRepository;
	
	@Override
	public Image getImageDetails(Long imageId) {
		try {
			return imageRepository.findById(imageId).get();
		}catch(Exception e) {
			System.out.println("Could not find any image with this id : " + imageId);
			return null;
		}
	}

	@Override
	public List<Image> getAllImage() {
		try {
			return imageRepository.findAll();
		}catch(Exception e) {
			System.out.println("Could not execute this Operation! ");
			return null;
		}
	}

	@Override
	public Image addImage(Image image) {
		try {
			return imageRepository.save(image);
		}catch(Exception e) {
			System.out.println("Could not execute this Operation! ");
			return null;
		}
	}

	@Override
	public Image updateImage(Image image) {
		try {
			return imageRepository.save(image);
		}catch(Exception e) {
			System.out.println("Could not execute this Operation! ");
			return null;
		}
	}

	@Override
	public boolean deleteImage(Image image) {
		try {
			imageRepository.delete(image);
			return true;
		}catch(Exception e) {
			System.out.println("Could not execute this Operation! ");
			return false;
		}
	}

	@Override
	public boolean deleteImageById(Long imageId) {
		try {
			imageRepository.deleteById(imageId);
			return true;
		}catch(Exception e) {
			System.out.println("Could not execute this Operation! ");
			return false;
		}
	}

	@Override
	public boolean enableImage(Long imageId) {
		try {
			Image image= imageRepository.findById(imageId).get();
			image.setEnabled(true);
			updateImage(image);
			return true;
		}catch(Exception e) {
			System.out.println("Could not find any image with this id : " + imageId);
			return false;
		}
	}

	@Override
	public boolean desableImage(Long imageId) {
		try {
			Image image= imageRepository.findById(imageId).get();
			image.setEnabled(false);
			updateImage(image);
			return true;
		}catch(Exception e) {
			System.out.println("Could not find any image with this id : " + imageId);
			return false;
		}
	}

}
