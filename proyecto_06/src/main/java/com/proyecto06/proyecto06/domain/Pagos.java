
package com.proyecto06.proyecto06.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.util.Date;
import lombok.Data;

@Data
@Entity
@Table(name="pagos")
public class Pagos {
    private static final long serialVersionUID = 1l;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    private Long idPago; 
    //private Long idReserva; 
    private String metodoPago;
    private double monto;
    private int fechaPago;
    private String rutaImagen;
    private boolean activo;
    @ManyToOne
    @JoinColumn(name = "id_reserva")
    private Reserva reserva;
  
}


