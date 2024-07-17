//Cambiar todas las palabras vuelos 
package com.proyecto06.proyecto06.controller;

import com.proyecto06.proyecto06.domain.Vuelos;
import com.proyecto06.proyecto06.services.FirebaseStorageService;
import com.proyecto06.proyecto06.services.VuelosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;


@Controller
@RequestMapping("/vuelos")
public class VuelosController {
     @Autowired
    private VuelosService vuelosService;
    
    @GetMapping("/listado")
    public String listado(Model model){
        var lista = vuelosService.getVuelos(false);
        model.addAttribute("vueloss", lista);
        model.addAttribute("totalVueloss", lista.size());
        
        return "/vuelos/listado";
        
    }
    @Autowired
    /*private FirebaseStorageService firebasStorageService;
    @PostMapping("/guardar")
    public String guardar(Vuelos vuelos,
            @RequestParam MultipartFile imagenFile) {
        if (!imagenFile.isEmpty()){
            //se sube la imagen al Storage
            vuelosService.save(vuelos);
            String rutaImagen=firebasStorageService.cargaImagen(imagenFile,
                    "vuelos", vuelos.getIdVuelos());
            vuelos.setRutaImagen(rutaImagen);
            
        }
        vuelosService.save(vuelos);
        return"redirect:/vuelos/listado";
    }*/
    @GetMapping("/eliminar/{idVuelos}")
    public String eliminar (Vuelos vuelos) {
        vuelosService.delete(vuelos);
        return"redirect:/vuelos/listado";
    }
    @GetMapping("/modificar/{idVuelos}")
    public String modificar (Vuelos vuelos, Model model) {
        vuelos = vuelosService.getVuelos(vuelos);
        model.addAttribute("vuelos", vuelos);
        return"/vuelos/modifica";
    }    
    
    
}


