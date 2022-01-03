package firas.karbich.com.wakalni.Models;

import android.os.Parcel;
import android.os.Parcelable;

// implementing Parcelable so we can pass an instance of this model to another activity
public class RestaurantModel implements Parcelable{

    private Long code;
    private String name;
    private String adresse;
    private String email;
    private String description;
    //private Image image;
    //private Collection<Menu> menus = new ArrayList<Menu>();


    public RestaurantModel() {
    }

    public RestaurantModel(Long code, String name, String adresse, String email, String description) {
        this.code = code;
        this.name = name;
        this.adresse = adresse;
        this.email = email;
        this.description = description;
    }

    protected RestaurantModel(Parcel in) {
        if (in.readByte() == 0) {
            code = null;
        } else {
            code = in.readLong();
        }
        name = in.readString();
        adresse = in.readString();
        email = in.readString();
        description = in.readString();
    }

    public static final Creator<RestaurantModel> CREATOR = new Creator<RestaurantModel>() {
        @Override
        public RestaurantModel createFromParcel(Parcel in) {
            return new RestaurantModel(in);
        }

        @Override
        public RestaurantModel[] newArray(int size) {
            return new RestaurantModel[size];
        }
    };

    public Long getCode() {
        return code;
    }

    public void setCode(Long code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        if (code == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeLong(code);
        }
        dest.writeString(name);
        dest.writeString(adresse);
        dest.writeString(email);
        dest.writeString(description);
    }
}
