package com.udacity.sandwichclub.model;

import android.text.TextUtils;

import java.util.List;

public class Sandwich {

    private SandwichName name;
    private String placeOfOrigin;
    private String description;
    private String image;
    private List<String> ingredients = null;

    private class SandwichName {
        private String mainName;
        private List<String> alsoKnownAs = null;
    }

    public Sandwich() {
    }

    public Sandwich(SandwichName name, String placeOfOrigin, String description, String image, List<String> ingredients) {
        this.name = name;
        this.placeOfOrigin = placeOfOrigin;
        this.description = description;
        this.image = image;
        this.ingredients = ingredients;
    }

    public String getMainName() { return name.mainName; }

    public String getAlsoKnownAs() { return TextUtils.join(", ",name.alsoKnownAs); }

    public void setName(SandwichName name) { this.name = name; }

    public String getPlaceOfOrigin() {
        return placeOfOrigin;
    }

    public void setPlaceOfOrigin(String placeOfOrigin) {
        this.placeOfOrigin = placeOfOrigin;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getIngredients() {
        return  TextUtils.join(", ",ingredients);
    }

    public void setIngredients(List<String> ingredients) {
        this.ingredients = ingredients;
    }
}
