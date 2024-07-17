
package com.proyecto06.proyecto06.services.impl;

import com.proyecto06.proyecto06.domain.Pasajeros;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.proyecto06.proyecto06.dao.PasajerosDao;
import com.proyecto06.proyecto06.services.PasajerosService;

@Service
public class PasajerosServiceImpl implements PasajerosService {

    @Autowired
    private PasajerosDao pasajerosDao;
    
    @Override
    public List<Pasajeros> getPasajeros(boolean activos) {
        var lista = pasajerosDao.findAll();
        
        if(activos) { //elimina inactivos
           lista.removeIf(c -> !c.isActivo());
        }
        
        return lista;
    }

    @Override
    public Pasajeros getPasajeros(Pasajeros pasajeros) {
        return pasajerosDao.findById(pasajeros.getIdPasajero()).orElse(null);
    }

    @Override
    public void save(Pasajeros pasajeros) {
        pasajerosDao.save(pasajeros);
    }

    @Override
    public void delete(Pasajeros pasajeros) {
        pasajerosDao.delete(pasajeros);
    }
    
}
