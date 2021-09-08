package com.arnoldvaz27.grocerystoreui.Grocery;

import android.content.res.ColorStateList;

public class GroceryHelper {
    int image;
    ColorStateList color;
    String name;

    public GroceryHelper(int image, ColorStateList color, String name) {
        this.image = image;
        this.color = color;
        this.name = name;
    }

    public int getImage() {
        return image;
    }

    public ColorStateList getColor() {
        return color;
    }

    public void setColor(ColorStateList color) {
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
