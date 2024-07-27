package com.proyecto06.proyecto06.services;

import com.proyecto06.proyecto06.domain.Vuelos;
import java.util.List;

public interface VuelosService {

    List<Vuelos> getVuelos();

    Vuelos getVuelos(Vuelos vuelos);

    void save(Vuelos vuelos);

    void delete(Vuelos vuelos);
}
