/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto06.proyecto06.domain;

public enum Estado {
    PENDIENTE("Pendiente"),
    COMPLETADO("Completado");

    private final String estado;

    Estado(String estado) {
        this.estado = estado;
    }

    public String getEstado() {
        return estado;
    }

    public static Estado fromString(String estado) {
        for (Estado e : Estado.values()) {
            if (e.estado.equalsIgnoreCase(estado)) {
                return e;
            }
        }
        throw new IllegalArgumentException("Estado no válido: " + estado);
    }
}
