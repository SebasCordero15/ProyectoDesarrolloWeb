/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto06.proyecto06.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Data;

@Data
@Entity
@Table(name="reservas")
public class Reserva implements Serializable {
    
    private static final long serialVersionUID = 1l;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idReserva;
    private Long idVuelo;
    private String descripcion;
    private String rutaImagen;
    private boolean activo;
 
}
