
package com.proyecto06.proyecto06.services.impl;

import com.proyecto06.proyecto06.dao.VuelosDao;
import com.proyecto06.proyecto06.domain.Vuelos;
import com.proyecto06.proyecto06.services.VuelosService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class VuelosServiceImpl implements VuelosService{
     @Autowired
    private VuelosDao vuelosDao;
    
    @Override
    public List<Vuelos> getVuelos(boolean activos) {
        var lista = vuelosDao.findAll();
        
        if(activos) { //elimina inactivos
           lista.removeIf(c -> !c.isActivo());
        }
        
        return lista;
    }

    @Override
    public Vuelos getVuelos(Vuelos vuelos) {
        return vuelosDao.findById(vuelos.getIdVuelo()).orElse(null);
    }

    @Override
    public void save(Vuelos vuelos) {
        vuelosDao.save(vuelos);
    }

    @Override
    public void delete(Vuelos vuelos) {
        vuelosDao.delete(vuelos);
    }
    
}
