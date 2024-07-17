
package com.proyecto06.proyecto06.services.impl;

import com.proyecto06.proyecto06.domain.Checkin;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.proyecto06.proyecto06.dao.CheckinDao;
import com.proyecto06.proyecto06.services.CheckinService;

@Service
public class CheckinServiceImpl implements CheckinService {

    @Autowired
    private CheckinDao checkinDao;
    
    @Override
    public List<Checkin> getCheckin(boolean activos) {
        var lista = checkinDao.findAll();
        
        if(activos) { //elimina inactivos
           lista.removeIf(c -> !c.isActivo());
        }
        
        return lista;
    }

    @Override
    public Checkin getCheckin(Checkin checkin) {
        return checkinDao.findById(checkin.getIdCheckin()).orElse(null);
    }

    @Override
    public void save(Checkin checkin) {
        checkinDao.save(checkin);
    }

    @Override
    public void delete(Checkin checkin) {
        checkinDao.delete(checkin);
    }
    
}
