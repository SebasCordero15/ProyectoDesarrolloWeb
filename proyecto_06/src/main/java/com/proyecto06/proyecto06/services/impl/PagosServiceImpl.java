
package com.proyecto06.proyecto06.services.impl;

import com.proyecto06.proyecto06.domain.Pagos;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.proyecto06.proyecto06.dao.PagosDao;
import com.proyecto06.proyecto06.services.PagosService;

@Service
public class PagosServiceImpl implements PagosService {

    @Autowired
    private PagosDao pagosDao;
    
    @Override
    public List<Pagos> getPagos(boolean activos) {
        var lista = pagosDao.findAll();
        
        if(activos) { //elimina inactivos
           lista.removeIf(c -> !c.isActivo());
        }
        
        return lista;
    }

    @Override
    public Pagos getPagos(Pagos pagos) {
        return pagosDao.findById(pagos.getIdPago()).orElse(null);
    }

    @Override
    public void save(Pagos pagos) {
        pagosDao.save(pagos);
    }

    @Override
    public void delete(Pagos pagos) {
        pagosDao.delete(pagos);
    }
    
}
