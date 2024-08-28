/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.proyecto06.proyecto06.services;

import com.proyecto06.proyecto06.domain.Paquetes;
import java.util.List;


public interface PaquetesService {
    //se enuncia un metodo que recupera los registros de la tabla categorira
    //dentro de un arraylist, pueden ser todos los registros o solo los activos
    public List<Paquetes>getPaquetes(boolean activos);
    
    //Se obtiene un registro de la tabla paquetes en un objeto paquetes si el id
    //paquetes existe, si no, se pasa un null
    
    public Paquetes getPaquetes(Paquetes paquetes);
    
    //Se crea un nuevo registro en paquetes si el objeto paquetes no tiene id paquetes
    //Se actualiza el registro en la tabla paquetes si el objeto paquetes tiene un id paquetes
    public void save(Paquetes paquetes);
    
    //se elimina el registro que tiene idPaquetes
    public void delete(Paquetes paquetes);
    
    //Retorna una lista de paquetess que se encunentran en un rango de precios
    public List<Paquetes> consulta1(double precioInf, double precioSup);
}
