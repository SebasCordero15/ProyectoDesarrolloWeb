
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
@Table(name="pasajeros")
public class Pasajeros {
    private static final long serialVersionUID = 1l;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    private Long idPasajero; 
    private String nombre;
    private String apellido;
    private String email;
    private int telefono; 
    private int fechaNacimiento;
    private String nacionalidad;
    private boolean activo;
    private String rutaImagen;
  
}

