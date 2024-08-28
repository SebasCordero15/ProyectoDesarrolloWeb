
package com.proyecto06.proyecto06.services;

import com.proyecto06.proyecto06.domain.Contacto;
import java.util.List;


public interface ContactoService {
    //se enuncia un metodo que recupera los registros de la tabla contacto
    //dentro de un arraylist, pueden ser todos los registros o solo los activos
    public List<Contacto>getContacto();
    
    //Se obtiene un registro de la tabla contacto en un objeto contacto si el id
    //contacto existe, si no, se pasa un null
    
    public Contacto getContacto(Contacto contacto);
    
    //Se crea un nuevo registro en contacto si el objeto contacto no tiene id contacto
    //Se actualiza el registro en la tabla contacto si el objeto contacto tiene un id contacto
    public void save(Contacto contacto);
    
    //se elimina el registro que tiene idContacto
    public void delete(Contacto contacto);
}
