package com.curso.ecommerce.service;

import java.util.Optional;

import com.curso.ecommerce.model.Producto;

public interface ProductoService {

    //guardar producto
    public Producto save(Producto producto);

    //retornar un producto
    public Optional<Producto> get(Integer id);

    //modificar producto
    public void update(Producto producto);

    //eliminar producto
    public void delete (Integer id);
}
