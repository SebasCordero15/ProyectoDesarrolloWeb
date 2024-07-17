
package com.proyecto06.proyecto06.services;

import com.proyecto06.proyecto06.domain.Pasajeros;
import java.util.List;


public interface PasajerosService {
    //se enuncia un metodo que recupera los registros de la tabla categorira
    //dentro de un arraylist, pueden ser todos los registros o solo los activos
    public List<Pasajeros>getPasajeros(boolean activos);
    
    //Se obtiene un registro de la tabla pasajeros en un objeto pasajeros si el id
    //pasajeros existe, si no, se pasa un null
    
    public Pasajeros getPasajeros(Pasajeros pasajeros);
    
    //Se crea un nuevo registro en pasajeros si el objeto pasajeros no tiene id pasajeros
    //Se actualiza el registro en la tabla pasajeros si el objeto pasajeros tiene un id pasajeros
    public void save(Pasajeros pasajeros);
    
    //se elimina el registro que tiene idPasajeros
    public void delete(Pasajeros pasajeros);
}
