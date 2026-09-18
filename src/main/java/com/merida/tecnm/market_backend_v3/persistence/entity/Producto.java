package com.merida.tecnm.market_backend_v3.persistence.entity;
import jakarta.persistence.*;

@Entity
@Table(name = "productos")
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType. IDENTITY)
    @Column(name ="id_producto")
    private Integer idproducto;

    private String nombre;

    @Column (name ="id categoria")
    private Integer id_categoria;

    @Column(name ="codigo barras")
    private String codigoBarras;

    @Column (name ="precio venta")
    private Double precioVenta;

    @Column(name ="cantidad stock")
    private Integer cantidadStock;

    private Boolean estado;
}
