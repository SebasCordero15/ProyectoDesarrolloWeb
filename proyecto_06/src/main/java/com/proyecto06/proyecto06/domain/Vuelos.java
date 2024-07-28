
package com.proyecto06.proyecto06.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
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
    private double precio;
   
   
  
}
