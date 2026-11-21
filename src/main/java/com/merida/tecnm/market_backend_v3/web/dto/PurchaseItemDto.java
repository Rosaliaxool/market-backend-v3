package com.merida.tecnm.market_backend_v3.web.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Detalle del producto adquirido en la compra")
public class PurchaseItemDto {

    @Schema(description = "Identificador del producto", example = "15", requiredMode = Schema.RequiredMode.REQUIRED)
    @JsonProperty("idProducto")
    private int idProducto;

    @Schema(description = "Cantidad adquirida", example = "2", requiredMode = Schema.RequiredMode.REQUIRED)
    @JsonProperty("cantidad")
    private int cantidad;

    @Schema(description = "Monto total por el producto", example = "500.0", requiredMode = Schema.RequiredMode.REQUIRED)
    @JsonProperty("total")
    private double total;

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}
