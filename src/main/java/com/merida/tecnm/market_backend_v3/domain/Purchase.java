package com.merida.tecnm.market_backend_v3.domain;

import java.time.LocalDateTime;
import java.util.List;

public class Purchase {

    private Integer purchaseId;
    @com.fasterxml.jackson.annotation.JsonAlias({"idCliente", "clientId"})
    private String clientId;
    private java.time.LocalDateTime date;
    @com.fasterxml.jackson.annotation.JsonAlias({"medioPago", "paymentMethod"})
    private String paymentMethod;
    @com.fasterxml.jackson.annotation.JsonAlias({"comentario", "comment"})
    private String comment;
    private String state;
    @com.fasterxml.jackson.annotation.JsonAlias({"productosAdquiridos", "items"})
    private List<PurchaseItem> items;

    public Integer getPurchaseId() {
        return purchaseId;
    }

    public void setPurchaseId(Integer purchaseId) {
        this.purchaseId = purchaseId;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public List<PurchaseItem> getItems() {
        return items;
    }

    public void setItems(List<PurchaseItem> items) {
        this.items = items;
    }
}

