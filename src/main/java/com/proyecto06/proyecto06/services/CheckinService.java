
package com.proyecto06.proyecto06.services;

import com.proyecto06.proyecto06.domain.Checkin;
import java.util.List;


public interface CheckinService {
    //se enuncia un metodo que recupera los registros de la tabla categorira
    //dentro de un arraylist, pueden ser todos los registros o solo los activos
    public List<Checkin>getCheckin();
    
    //Se obtiene un registro de la tabla checkin en un objeto checkin si el id
    //checkin existe, si no, se pasa un null
    
    public Checkin getCheckin(Checkin checkin);
    
    //Se crea un nuevo registro en checkin si el objeto checkin no tiene id checkin
    //Se actualiza el registro en la tabla checkin si el objeto checkin tiene un id checkin
    public void save(Checkin checkin);
    
    //se elimina el registro que tiene idCheckin
    public void delete(Checkin checkin);
}
