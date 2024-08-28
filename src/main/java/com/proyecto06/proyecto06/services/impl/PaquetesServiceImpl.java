/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto06.proyecto06.services.impl;

import com.proyecto06.proyecto06.dao.PaquetesDao;
import com.proyecto06.proyecto06.domain.Paquetes;
import com.proyecto06.proyecto06.services.PaquetesService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PaquetesServiceImpl implements PaquetesService {

    @Autowired
    private PaquetesDao paquetesDao;
    
    @Override
    @Transactional(readOnly=true) //ejecuta elementos de lectura
    public List<Paquetes> getPaquetes(boolean activos) {
        var lista = paquetesDao.findAll();
        
        if(activos) { //elimina inactivos
           lista.removeIf(c -> !c.isActivo());
        }
        
        return lista;
    }

    @Override
    @Transactional(readOnly=true)
    public Paquetes getPaquetes(Paquetes paquetes) {
        return paquetesDao.findById(paquetes.getIdPaquete()).orElse(null);
    }

    @Override
    public void save(Paquetes paquetes) {
        paquetesDao.save(paquetes);
    }

    @Override
    public void delete(Paquetes paquetes) {
        paquetesDao.delete(paquetes);
    }

    @Override
    @Transactional(readOnly=true)
    public List<Paquetes> consulta1(double precioInf, double precioSup) {
        return paquetesDao.findByPrecioBetweenOrderByDescripcion(precioInf, precioSup);
    }
    
}
