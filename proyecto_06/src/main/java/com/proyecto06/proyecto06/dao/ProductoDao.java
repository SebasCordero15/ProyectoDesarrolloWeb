
package com.proyecto06.proyecto06.dao;

import com.proyecto06.proyecto06.domain.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoDao extends JpaRepository<Producto,Long> {

}
