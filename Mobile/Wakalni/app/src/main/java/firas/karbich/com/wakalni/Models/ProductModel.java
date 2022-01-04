package firas.karbich.com.wakalni.Models;

import android.os.Parcel;
import android.os.Parcelable;
import android.widget.TextView;

public class ProductModel implements Parcelable {

    private static final String PRODUCT_CODE_SEPARATOR = ".";

    private String code;
    private FoodWithExtrasModel foodWithExtras;
    private int quantiteFoodWithExtras;
    private double prixFinale;
    private String restaurantName;

    public ProductModel() {
        super();
    }

    public ProductModel(String name) {// ma3tinehich extras ==> tous les extras wkol wa7da lquantite 1, 5alis baba 5alis hhh
        this.foodWithExtras.getFood().setLibelle(name);
        this.code = this.restaurantName + PRODUCT_CODE_SEPARATOR + this.foodWithExtras.getFood().getLibelle();
    }

    protected ProductModel(Parcel in) {
        code = in.readString();
        quantiteFoodWithExtras = in.readInt();
        prixFinale = in.readDouble();
        restaurantName = in.readString();
    }

    public static final Creator<ProductModel> CREATOR = new Creator<ProductModel>() {
        @Override
        public ProductModel createFromParcel(Parcel in) {
            return new ProductModel(in);
        }

        @Override
        public ProductModel[] newArray(int size) {
            return new ProductModel[size];
        }
    };

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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(code);
        dest.writeInt(quantiteFoodWithExtras);
        dest.writeDouble(prixFinale);
        dest.writeString(restaurantName);
    }
}
