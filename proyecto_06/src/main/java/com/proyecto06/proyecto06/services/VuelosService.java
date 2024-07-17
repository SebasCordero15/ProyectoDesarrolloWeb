
package com.proyecto06.proyecto06.services;

import com.proyecto06.proyecto06.domain.Vuelos;
import java.util.List;


public interface VuelosService {
    //se enuncia un metodo que recupera los registros de la tabla categorira
    //dentro de un arraylist, pueden ser todos los registros o solo los activos
    public List<Vuelos>getVuelos(boolean activos);
    
    //Se obtiene un registro de la tabla vuelos en un objeto vuelos si el id
    //vuelos existe, si no, se pasa un null
    
    public Vuelos getVuelos(Vuelos vuelos);
    
    //Se crea un nuevo registro en vuelos si el objeto vuelos no tiene id vuelos
    //Se actualiza el registro en la tabla vuelos si el objeto vuelos tiene un id vuelos
    public void save(Vuelos vuelos);
    
    //se elimina el registro que tiene idVuelos
    public void delete(Vuelos vuelos);
}
