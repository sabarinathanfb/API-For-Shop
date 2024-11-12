package com.nk.store.models;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class CartItem extends BaseClass {



    @ManyToOne
    @JoinColumn(name = "cart_id")
    private Cart cart; // Link back to the Cart

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product; // Product associated with this cart item

    private int quantity; // Quantity of the product in the cart

    private double price; // Price of the product at the time of adding to cart

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}

