package firas.karbich.com.wakalni.Models;

public class ProductModel {

    private String code;
    private FoodWithExtrasModel foodWithExtras;
    private int quantiteFoodWithExtras;
    private double prixFinale;
    private String restaurantName;

    public ProductModel() {
        super();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public double getPrixFinale() {
        return prixFinale;
    }

    public void setPrixFinale(double prixFinale) {
        this.prixFinale = prixFinale;
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    public FoodWithExtrasModel getFoodWithExtras() {
        return foodWithExtras;
    }

    public void setFoodWithExtras(FoodWithExtrasModel foodWithExtras) {
        this.foodWithExtras = foodWithExtras;
    }

    public int getQuantiteFoodWithExtras() {
        return quantiteFoodWithExtras;
    }

    public void setQuantiteFoodWithExtras(int quantiteFoodWithExtras) {
        this.quantiteFoodWithExtras = quantiteFoodWithExtras;
    }

}
