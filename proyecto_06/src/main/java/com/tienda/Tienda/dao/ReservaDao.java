/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.tienda.Tienda.dao;

import com.tienda.Tienda.domain.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservaDao extends JpaRepository<Reserva,Long> {

}
