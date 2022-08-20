package com.apirest.api.controllers;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.apirest.api.models.CuentaModel;
import com.apirest.api.repositories.CuentaRepository;



//Controller: se declaran los metodos get, post, put y delete
//se indica que la clase es un controlador y la ruta de la api
@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api/v1/accounts")
public class CuentaController {
    @Autowired
    CuentaRepository cuentaRepository;

    //get
    @GetMapping("")
    public ResponseEntity<List<CuentaModel>> getAllCuentaModels(@RequestParam(required = false) String nombre_cliente) {
      try {
        List<CuentaModel> cuentaModels = new ArrayList<CuentaModel>();
  
        if (nombre_cliente == null)
          cuentaRepository.findAll().forEach(cuentaModels::add);
        else
          cuentaRepository.findByNombre_clienteContaining(nombre_cliente).forEach(cuentaModels::add);
  
        if (cuentaModels.isEmpty()) {
          return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
  
        return new ResponseEntity<>(cuentaModels, HttpStatus.OK);
      } catch (Exception e) {
        return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
      }
    }
  
    //get - id_cuenta
    @GetMapping("/{id_cuenta}")
    public ResponseEntity<CuentaModel> getCuentaModelById(@PathVariable("id_cuenta") long id_cuenta) {
      CuentaModel cuentaModel = cuentaRepository.findById(id_cuenta);
  
      if (cuentaModel != null) {
        return new ResponseEntity<>(cuentaModel, HttpStatus.OK);
      } else {
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
      }
    }
  
    //post
    @PostMapping("")
    public ResponseEntity<String> createCuentaModel(@RequestBody CuentaModel cuentaModel) {
      try {
        cuentaRepository.save(new CuentaModel(cuentaModel.getNombre_cliente(), cuentaModel.getSaldo_cuenta(), cuentaModel.isEstado_cuenta()));
        return new ResponseEntity<>("La accounts fue creada correctamente.", HttpStatus.CREATED);
      } catch (Exception e) {
        return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
      }
    }
  
    //put - id_cuenta
    @PutMapping("/{id_cuenta}")
    public ResponseEntity<String> updateCuentaModel(@PathVariable("id_cuenta") long id_cuenta, @RequestBody CuentaModel cuentaModel) {
      CuentaModel _cuentaModel = cuentaRepository.findById(id_cuenta);
  
      if (_cuentaModel != null) {
        _cuentaModel.setSaldo_cuenta(cuentaModel.getSaldo_cuenta());//solamente cambiara el valor del saldo
  
        cuentaRepository.update(_cuentaModel);
        return new ResponseEntity<>("La accounts con el id_cuenta="+id_cuenta+" fue actualizada correctamente.", HttpStatus.OK);
      } else {
        return new ResponseEntity<>("No se puede encontrar la accounts con el id_cuenta=" + id_cuenta, HttpStatus.NOT_FOUND);
      }
    }
  
    //delete - id_cuenta
    //desactiva la cuenta
    @DeleteMapping("/{id_cuenta}")
    public ResponseEntity<String> deleteCuentaModel(@PathVariable("id_cuenta") long id_cuenta) {
      try {
        int result = cuentaRepository.deleteById(id_cuenta);
        if (result == 0) {
          return new ResponseEntity<>("No se pudo encontrar la accounts con el id_cuenta=" + id_cuenta, HttpStatus.OK);
        }
        return new ResponseEntity<>("El usuario con el id_cuenta=" + id_cuenta + "fue desactivado correctamente.", HttpStatus.OK);
      } catch (Exception e) {
        return new ResponseEntity<>("No se encuentra el usuario con el id_cuenta="+id_cuenta+".", HttpStatus.INTERNAL_SERVER_ERROR);
      }

    }
  
}
