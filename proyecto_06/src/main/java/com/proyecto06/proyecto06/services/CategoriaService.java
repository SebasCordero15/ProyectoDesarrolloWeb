/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.proyecto06.proyecto06.services;

import com.proyecto06.proyecto06.domain.Categoria;
import java.util.List;


public interface CategoriaService {
    //se enuncia un metodo que recupera los registros de la tabla categorira
    //dentro de un arraylist, pueden ser todos los registros o solo los activos
    public List<Categoria>getCategoria(boolean activos);
    
    //Se obtiene un registro de la tabla categoria en un objeto categoria si el id
    //categoria existe, si no, se pasa un null
    
    public Categoria getCategoria(Categoria categoria);
    
    //Se crea un nuevo registro en categoria si el objeto categoria no tiene id categoria
    //Se actualiza el registro en la tabla categoria si el objeto categoria tiene un id categoria
    public void save(Categoria categoria);
    
    //se elimina el registro que tiene idCategoria
    public void delete(Categoria categoria);
}
