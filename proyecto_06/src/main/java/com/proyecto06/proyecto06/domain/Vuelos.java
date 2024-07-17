
package com.proyecto06.proyecto06.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.Date;
import lombok.Data;

@Data
@Entity
@Table(name="vuelos")
public class Vuelos {
    private static final long serialVersionUID = 1l;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    private Long idVuelo; 
    private String codigoVuelo;
    private String origen;
    private String destino;
    private String fechaSalida; 
    private String fechaLlegada;
    private boolean activo;
    private String rutaImagen;
  
}
