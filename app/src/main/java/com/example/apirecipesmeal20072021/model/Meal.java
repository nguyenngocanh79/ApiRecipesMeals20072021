package com.example.apirecipesmeal20072021.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Meal implements Parcelable {

    private String id;
    private String name;
    private String image;
    private String youtube;
    private String instruction;
    private String calo;
    private String ingredient;
    private String carbo;
    private String protein;

    protected Meal(Parcel in) {
        id = in.readString();
        name = in.readString();
        image = in.readString();
        youtube = in.readString();
        instruction = in.readString();
        calo = in.readString();
        ingredient = in.readString();
        carbo = in.readString();
        protein = in.readString();
    }

    public static final Creator<Meal> CREATOR = new Creator<Meal>() {
        @Override
        public Meal createFromParcel(Parcel in) {
            return new Meal(in);
        }

        @Override
        public Meal[] newArray(int size) {
            return new Meal[size];
        }
    };

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getYoutube() {
        return youtube;
    }

    public void setYoutube(String youtube) {
        this.youtube = youtube;
    }

    public String getInstruction() {
        return instruction;
    }

    public void setInstruction(String instruction) {
        this.instruction = instruction;
    }

    public String getCalo() {
        return calo;
    }

    public void setCalo(String calo) {
        this.calo = calo;
    }

    public String getIngredient() {
        return ingredient;
    }

    public void setIngredient(String ingredient) {
        this.ingredient = ingredient;
    }

    public String getCarbo() {
        return carbo;
    }

    public void setCarbo(String carbo) {
        this.carbo = carbo;
    }

    public String getProtein() {
        return protein;
    }

    public void setProtein(String protein) {
        this.protein = protein;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(id);
        parcel.writeString(name);
        parcel.writeString(image);
        parcel.writeString(youtube);
        parcel.writeString(instruction);
        parcel.writeString(calo);
        parcel.writeString(ingredient);
        parcel.writeString(carbo);
        parcel.writeString(protein);
    }
}
