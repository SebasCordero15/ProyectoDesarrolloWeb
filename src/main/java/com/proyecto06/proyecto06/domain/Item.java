
package com.proyecto06.proyecto06.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class Item extends Paquetes {
    private int cantidad; //Almacenar la cantidad de items de un paquetes

    public Item() {
    }

    public Item(Paquetes paquetes) {
        super.setIdPaquete(paquetes.getIdPaquete());
        super.setCategoria(paquetes.getCategoria());
        super.setDescripcion(paquetes.getDescripcion());
        super.setDetalle(paquetes.getDetalle());
        super.setPrecio(paquetes.getPrecio());
        super.setExistencias(paquetes.getExistencias());
        super.setActivo(paquetes.isActivo());
        super.setRutaImagen(paquetes.getRutaImagen());
        this.cantidad = 0;
    }
}
