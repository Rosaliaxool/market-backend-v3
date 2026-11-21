package com.merida.tecnm.market_backend_v3.web.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;

import java.util.List;

@Schema(description = "DTO complejo para procesar una compra con su detalle en una sola transacción")
public class PurchaseRequestDto {

    @Schema(description = "ID del cliente", example = "CLI-001", requiredMode = Schema.RequiredMode.REQUIRED)
    @JsonProperty("idCliente")
    private String idCliente;

    @Schema(description = "Medio de pago utilizado", example = "TARJETA", requiredMode = Schema.RequiredMode.REQUIRED)
    @JsonProperty("medioPago")
    private String medioPago;

    @Schema(description = "Comentario u observaciones sobre la compra", example = "Entregar por la tarde")
    @JsonProperty("comentario")
    private String comentario;

    @Schema(description = "Lista de productos adquiridos en la compra", requiredMode = Schema.RequiredMode.REQUIRED)
    @JsonProperty("productosAdquiridos")
    private List<PurchaseItemDto> productosAdquiridos;

    public String getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }

    public String getMedioPago() {
        return medioPago;
    }

    public void setMedioPago(String medioPago) {
        this.medioPago = medioPago;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public List<PurchaseItemDto> getProductosAdquiridos() {
        return productosAdquiridos;
    }

    public void setProductosAdquiridos(List<PurchaseItemDto> productosAdquiridos) {
        this.productosAdquiridos = productosAdquiridos;
    }
}
