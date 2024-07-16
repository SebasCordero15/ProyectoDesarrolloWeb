/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tienda.Tienda.services.impl;

import com.tienda.Tienda.domain.Reserva;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.tienda.Tienda.dao.ReservaDao;
import com.tienda.Tienda.services.ReservaService;

@Service
public class ReservaServiceImpl implements ReservaService {

    @Autowired
    private ReservaDao categoriaDao;
    
    @Override
    public List<Reserva> getCategoria(boolean activos) {
        var lista = categoriaDao.findAll();
        
        if(activos) { //elimina inactivos
           lista.removeIf(c -> !c.isActivo());
        }
        
        return lista;
    }

    @Override
    public Reserva getCategoria(Reserva categoria) {
        return categoriaDao.findById(categoria.getIdCategoria()).orElse(null);
    }

    @Override
    public void save(Reserva categoria) {
        categoriaDao.save(categoria);
    }

    @Override
    public void delete(Reserva categoria) {
        categoriaDao.delete(categoria);
    }
    
}
