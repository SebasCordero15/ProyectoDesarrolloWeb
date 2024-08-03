
package com.proyecto06.proyecto06.services;

import com.proyecto06.proyecto06.domain.Pagos;
import java.util.List;


public interface PagosService {
    //se enuncia un metodo que recupera los registros de la tabla categorira
    //dentro de un arraylist, pueden ser todos los registros o solo los activos
    public List<Pagos>getPagos();
    
    //Se obtiene un registro de la tabla pagos en un objeto pagos si el id
    //pagos existe, si no, se pasa un null
    
    public Pagos getPagos(Pagos pagos);
    
    //Se crea un nuevo registro en pagos si el objeto pagos no tiene id pagos
    //Se actualiza el registro en la tabla pagos si el objeto pagos tiene un id pagos
    public void save(Pagos pagos);
    
    //se elimina el registro que tiene idPagos
    public void delete(Pagos pagos);
}
