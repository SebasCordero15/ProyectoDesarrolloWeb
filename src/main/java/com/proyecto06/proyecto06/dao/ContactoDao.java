
package com.proyecto06.proyecto06.dao;

import com.proyecto06.proyecto06.domain.Contacto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactoDao extends JpaRepository<Contacto,Long> {
    
}
