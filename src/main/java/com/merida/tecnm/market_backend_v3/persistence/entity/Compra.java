package com.merida.tecnm.market_backend_v3.persistence.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table (name ="compras")
public class Compra{

@Id
@GeneratedValue(strategy= GenerationType.IDENTITY)
@Column (name ="id.dcompra")
private Integer idcompra;

@Column (name ="id_cliente")
private String idCliente;

private LocalDateTime fecha;

@Column (name ="medio pago")
private String medioPago;

private String comentario;
private String estado;
// relacion con cliente
    // mucho compras para el cliente
    @ManyToOne
    @JoinColumn (name = "id_cliente", insertable = false, updatable = false)
    private Cliente cliente;

    //relacion con compra de producto
    @OneToMany(mappedBy = "compra")
    private List<CompraProducto> productos;

    public Integer getIdcompra() {
        return idcompra;
    }
}
