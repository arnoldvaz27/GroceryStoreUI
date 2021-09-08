package com.arnoldvaz27.grocerystoreui.Offer;

public class OfferHelper {
    int image;
    String name,price,piece;

    public OfferHelper(int image, String name, String price, String piece) {
        this.image = image;
        this.name = name;
        this.price = price;
        this.piece = piece;
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

    public String getPiece() {
        return piece;
    }
}
