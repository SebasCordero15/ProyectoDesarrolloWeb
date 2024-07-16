/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.proyecto06.proyecto06.services;

import com.proyecto06.proyecto06.domain.Producto;
import java.util.List;


public interface ProductoService {
    //se enuncia un metodo que recupera los registros de la tabla categorira
    //dentro de un arraylist, pueden ser todos los registros o solo los activos
    public List<Producto>getProducto(boolean activos);
    
    //Se obtiene un registro de la tabla producto en un objeto producto si el id
    //producto existe, si no, se pasa un null
    
    public Producto getProducto(Producto producto);
    
    //Se crea un nuevo registro en producto si el objeto producto no tiene id producto
    //Se actualiza el registro en la tabla producto si el objeto producto tiene un id producto
    public void save(Producto producto);
    
    //se elimina el registro que tiene idProducto
    public void delete(Producto producto);
}
