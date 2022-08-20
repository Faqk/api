package com.apirest.api.repositories;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.apirest.api.models.CuentaModel;


@Repository
public interface CuentaRepository{
    //post
    int save(CuentaModel book);

    //put - id
    int update(CuentaModel book);

    //delete - id
    int deleteById(Long id_cuenta);
  
    //get - id
    CuentaModel findById(Long id_cuenta);
  
    //get 
    List<CuentaModel> findAll();
  
    List<CuentaModel> findByNombre_clienteContaining(String nombre_cliente);
}
