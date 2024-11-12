package com.nk.store.models;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class Stock extends BaseClass {


    @OneToOne
    @JoinColumn(name = "product_id")
    private Product product; // Foreign key to Product entity

    private int availableQuantity; // Available stock for sale

    private int reservedQuantity; // Reserved for pending orders (optional)


    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getAvailableQuantity() {
        return availableQuantity;
    }

    public void setAvailableQuantity(int availableQuantity) {
        this.availableQuantity = availableQuantity;
    }

    public int getReservedQuantity() {
        return reservedQuantity;
    }

    public void setReservedQuantity(int reservedQuantity) {
        this.reservedQuantity = reservedQuantity;
    }
}
