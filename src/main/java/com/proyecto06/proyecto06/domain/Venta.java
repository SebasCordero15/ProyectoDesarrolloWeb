/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto06.proyecto06.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import lombok.Data;

@Data
@Entity
@Table(name="venta")
public class Venta implements Serializable {    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_venta")
    private Long idVenta;
    private Long idFactura;
    private Long idPaquete;    
    private double precio;
    private int cantidad;    
    
    public Venta() {
    }

    public Venta(Long idFactura, Long idPaquete, double precio, int cantidad) {
        this.idFactura = idFactura;
        this.idPaquete = idPaquete;
        this.precio = precio;
        this.cantidad = cantidad;
    }
}
