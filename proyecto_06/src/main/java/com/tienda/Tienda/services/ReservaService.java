/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.tienda.Tienda.services;

import com.tienda.Tienda.domain.Reserva;
import java.util.List;


public interface ReservaService {
    //se enuncia un metodo que recupera los registros de la tabla categorira
    //dentro de un arraylist, pueden ser todos los registros o solo los activos
    public List<Reserva>getReserva(boolean activos);
    
    //Se obtiene un registro de la tabla reserva en un objeto reserva si el id
    //reserva existe, si no, se pasa un null
    
    public Reserva getReserva(Reserva reserva);
    
    //Se crea un nuevo registro en reserva si el objeto reserva no tiene id reserva
    //Se actualiza el registro en la tabla reserva si el objeto reserva tiene un id reserva
    public void save(Reserva reserva);
    
    //se elimina el registro que tiene idReserva
    public void delete(Reserva reserva);
}
