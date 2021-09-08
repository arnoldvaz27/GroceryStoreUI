package com.arnoldvaz27.grocerystoreui.Selling;

public class SellingHelper {
    int image;
    String name,price;

    public SellingHelper(int image, String name, String price) {
        this.image = image;
        this.name = name;
        this.price = price;
    }

    public int getImage() {
        return image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

}
