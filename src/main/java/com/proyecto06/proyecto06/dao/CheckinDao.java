
package com.proyecto06.proyecto06.dao;

import com.proyecto06.proyecto06.domain.Checkin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CheckinDao extends JpaRepository<Checkin,Long> {
    
}
