package com.apirest.api.repositories;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import com.apirest.api.models.CuentaModel;

//sql statements para los metodos post, put, delete y get
@Repository
public class JdbcCuentaRepository implements CuentaRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    //post
    @Override
    public int save(CuentaModel cuentaModel) {
        return jdbcTemplate.update("INSERT INTO accounts (nombre_cliente, saldo_cuenta, estado_cuenta) VALUES(?,?,?)",
                new Object[] { cuentaModel.getNombre_cliente(), cuentaModel.getSaldo_cuenta(), cuentaModel.isEstado_cuenta() });
    }

    //put - id
    @Override
    public int update(CuentaModel cuentaModel) {
        return jdbcTemplate.update("UPDATE accounts SET nombre_cliente=?, saldo_cuenta=? WHERE id_cuenta=?",
                new Object[] { cuentaModel.getNombre_cliente(), cuentaModel.getSaldo_cuenta(), cuentaModel.getId_cuenta() });
    }

    //delete - id
    @Override
    public int deleteById(Long id_cuenta) {
        return jdbcTemplate.update("UPDATE accounts SET estado_cuenta=FALSE WHERE id_cuenta=?", id_cuenta);
    }

    //get - id
    @Override
    public CuentaModel findById(Long id_cuenta) {
        try {
            CuentaModel cuentaModel = jdbcTemplate.queryForObject("SELECT * FROM accounts WHERE id_cuenta=?",
                    BeanPropertyRowMapper.newInstance(CuentaModel.class), id_cuenta);

            return cuentaModel;
        } catch (IncorrectResultSizeDataAccessException e) {
            return null;
        }
    }

    //get
    @Override
    public List<CuentaModel> findAll() {
        return jdbcTemplate.query("SELECT * from accounts", BeanPropertyRowMapper.newInstance(CuentaModel.class));
    }



    @Override
    public List<CuentaModel> findByNombre_clienteContaining(String nombreCliente) {
        // TODO Auto-generated method stub
        return null;
    }

}
