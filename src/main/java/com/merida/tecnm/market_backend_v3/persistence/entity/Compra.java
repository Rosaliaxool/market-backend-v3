package com.merida.tecnm.market_backend_v3.persistence.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

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
}
