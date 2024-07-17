
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
@Table(name="checkin")
public class Checkin {
    private static final long serialVersionUID = 1l;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    private Long idCheckin;
    //private Long idReserva;
    private int fechaCheckin;
    private String nacionalidad;
    private boolean activo;
    private String rutaImagen;


    @ManyToOne
    @JoinColumn(name = "id_reserva")
    private Reserva reserva;
}

