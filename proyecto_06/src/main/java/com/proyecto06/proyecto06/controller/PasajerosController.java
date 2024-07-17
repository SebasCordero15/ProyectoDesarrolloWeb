/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto06.proyecto06.controller;



import com.proyecto06.proyecto06.domain.Pasajeros;
import com.proyecto06.proyecto06.services.PasajerosService;
import com.proyecto06.proyecto06.services.FirebaseStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/pasajeros")
public class PasajerosController {
    
    @Autowired
    private PasajerosService pasajerosService;
    
    @GetMapping("/listado")
    public String listado(Model model){
        var lista = pasajerosService.getPasajeros(false);
        model.addAttribute("pasajeros", lista);
        model.addAttribute("totalPasajeros", lista.size());
        
        return "/pasajeros/listado";
        
    }
    @Autowired
    private FirebaseStorageService firebasStorageService;
    @PostMapping("/guardar")
    public String guardar(Pasajeros pasajeros,
            @RequestParam MultipartFile imagenFile) {
        if (!imagenFile.isEmpty()){
            //se sube la imagen al Storage
            pasajerosService.save(pasajeros);
            String rutaImagen=firebasStorageService.cargaImagen(imagenFile,
                    "pasajeros", pasajeros.getIdPasajero());
            pasajeros.setRutaImagen(rutaImagen);
            
        }
        pasajerosService.save(pasajeros);
        return"redirect:/pasajeros/listado";
    }
    @GetMapping("/eliminar/{idPasajeros}")
    public String eliminar (Pasajeros pasajeros) {
        pasajerosService.delete(pasajeros);
        return"redirect:/pasajeros/listado";
    }
    @GetMapping("/modificar/{idPasajeros}")
    public String modificar (Pasajeros pasajeros, Model model) {
        pasajeros = pasajerosService.getPasajeros(pasajeros);
        model.addAttribute("pasajeros", pasajeros);
        return"/pasajeros/modifica";
    }    
    
    
}
