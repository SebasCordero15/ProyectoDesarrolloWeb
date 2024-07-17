
package com.proyecto06.proyecto06.dao;

import com.proyecto06.proyecto06.domain.Pasajeros;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PasajerosDao extends JpaRepository<Pasajeros,Long> {
    
}
