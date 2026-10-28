package com.merida.tecnm.market_backend_v3.domain;

public class Category {
    private int categoryId;      // no "categoryid"
    private String description;
    private boolean active;

    public int getCategoryId() { return categoryId; }
    public void setCategoryId(int categoryId) { this.categoryId = categoryId; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public boolean isActive() { return active; }
    public void setActive(boolean active) { this.active = active; }
}