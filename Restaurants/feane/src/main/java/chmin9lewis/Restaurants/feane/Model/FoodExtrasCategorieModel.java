package chmin9lewis.Restaurants.feane.Model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonAlias;
//ch9af bich nista3mlouh wa9t t3adi id ta3  restaurant bich yjib les food ili teb3ino
public interface FoodExtrasCategorieModel {

	 String getnamer();
	 String getlibelle();
	 double getprix();
	 String getimage() ;
	 @JsonAlias("Foodcategorie")
	 String getnamec();

	
	 @JsonAlias("Foodextra")
	 String getnameex();
	 Long getquantite();
	 double getprix_unitaire();
}
