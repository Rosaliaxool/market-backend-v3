package com.merida.tecnm.market_backend_v3.domain;

public class Category {
    private Integer categoryId;      // Integer en vez de int primitivo para admitir null en creación
    private String description;
    private boolean active;

    public Integer getCategoryId() { return categoryId; }
    public void setCategoryId(Integer categoryId) { this.categoryId = categoryId; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public boolean isActive() { return active; }
    public void setActive(boolean active) { this.active = active; }
}