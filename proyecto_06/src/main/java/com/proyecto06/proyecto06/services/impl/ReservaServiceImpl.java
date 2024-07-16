/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto06.proyecto06.services.impl;

import com.proyecto06.proyecto06.domain.Reserva;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.proyecto06.proyecto06.dao.ReservaDao;
import com.proyecto06.proyecto06.services.ReservaService;

@Service
public class ReservaServiceImpl implements ReservaService {

    @Autowired
    private ReservaDao reservaDao;
    
    @Override
    public List<Reserva> getReserva(boolean activos) {
        var lista = reservaDao.findAll();
        
        if(activos) { //elimina inactivos
           lista.removeIf(c -> !c.isActivo());
        }
        
        return lista;
    }

    @Override
    public Reserva getReserva(Reserva reserva) {
        return reservaDao.findById(reserva.getIdReserva()).orElse(null);
    }

    @Override
    public void save(Reserva reserva) {
        reservaDao.save(reserva);
    }

    @Override
    public void delete(Reserva reserva) {
        reservaDao.delete(reserva);
    }
    
}
