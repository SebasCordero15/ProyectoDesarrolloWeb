package com.proyecto06.proyecto06.services;

import com.proyecto06.proyecto06.domain.Vuelos;
import java.util.List;

public interface VuelosService {

    List<Vuelos> getVuelos();

    public Vuelos getVuelos(Vuelos vuelos);

    public void save(Vuelos vuelos);

    public void delete(Vuelos vuelos);
}
