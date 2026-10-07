package com.merida.tecnm.market_backend_v3.persistence.crud;

import com.merida.tecnm.market_backend_v3.persistence.entity.Producto;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;


public interface ProductoCrudRepository extends CrudRepository<Producto, Integer> {
    Optional<List<Producto>> findByCantidadStockLessThanAndEstado(int cantidad, boolean b);

    List<Producto> findByIdCategoriaOrderByNombreAsc(int idCategoria);

    //metodos abstractos que despues se implementan
    public interface  ProductCrudRepository extends CrudRepository<Producto, Integer>{

        /*SQL Query Method
        Select *
        FROM productos
        WHERE id_categoria =10?
        ORDER BY nombre ASC
         */
        List<Producto> findByIdCategoriaOrderByNombreAsc(int idCategoria);

        // Cantidad stock
        Optional<List<Producto>> findByCantidadStockLessThenAndEstado(int CantidaStock, boolean estado);

    }
}
