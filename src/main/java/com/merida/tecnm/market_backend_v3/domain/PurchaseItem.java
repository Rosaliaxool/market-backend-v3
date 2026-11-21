package com.merida.tecnm.market_backend_v3.domain;

public class PurchaseItem {
    @com.fasterxml.jackson.annotation.JsonAlias({"idProducto", "productId"})
    private int productId;
    @com.fasterxml.jackson.annotation.JsonAlias({"cantidad", "quantity"})
    private int quantity;
    @com.fasterxml.jackson.annotation.JsonAlias({"total"})
    private double total;
    private boolean active = true;

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
