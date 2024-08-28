
package com.proyecto06.proyecto06.dao;

import com.proyecto06.proyecto06.domain.Paquetes;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaquetesDao extends 
        JpaRepository<Paquetes,Long> {
    public List<Paquetes> findByPrecioBetweenOrderByDescripcion(double precioInf, double precioSup);

}
