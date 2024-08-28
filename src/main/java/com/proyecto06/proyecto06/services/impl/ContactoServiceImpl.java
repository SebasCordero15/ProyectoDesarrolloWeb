
package com.proyecto06.proyecto06.services.impl;

import com.proyecto06.proyecto06.domain.Contacto;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.proyecto06.proyecto06.dao.ContactoDao;
import com.proyecto06.proyecto06.domain.Vuelos;
import com.proyecto06.proyecto06.services.ContactoService;

@Service
public class ContactoServiceImpl implements ContactoService {

    @Autowired
    private ContactoDao contactoDao;
    
    @Override
    public List<Contacto> getContacto() {
        return contactoDao.findAll();
    }

    @Override
    public Contacto getContacto(Contacto contacto) {
        return contactoDao.findById(contacto.getIdContacto()).orElse(null);
    }

    @Override
    public void save(Contacto contacto) {
        contactoDao.save(contacto);
    }

    @Override
    public void delete(Contacto contacto) {
        contactoDao.delete(contacto);
    }
    
}
