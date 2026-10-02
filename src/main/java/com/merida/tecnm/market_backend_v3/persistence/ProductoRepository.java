package com.merida.tecnm.market_backend_v3.persistence;

import com.merida.tecnm.market_backend_v3.persistence.crud.ProductoCrudRepository;
import com.merida.tecnm.market_backend_v3.persistence.entity.Producto;

import java.util.List;

public class ProductoRepository {

    private ProductoCrudRepository productCrudRepository;

    //SELECT * FROM Productos
    public List<Producto> getAll() {
        //Vamos a "castear"
        return (List<Producto>) productCrudRepository.findAll();

        }
    }

