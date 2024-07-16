/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto06.proyecto06.controller;



import com.proyecto06.proyecto06.domain.Reserva;
import com.proyecto06.proyecto06.services.ReservaService;
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
@RequestMapping("/reserva")
public class ReservaController {
    
    @Autowired
    private ReservaService reservaService;
    
    @GetMapping("/listado")
    public String listado(Model model){
        var lista = reservaService.getReserva(false);
        model.addAttribute("reservas", lista);
        model.addAttribute("totalReservas", lista.size());
        
        return "/reserva/listado";
        
    }
    @Autowired
    //private FirebaseStorageService firebasStorageService;
    //@PostMapping("/guardar")
    //public String guardar(Reserva reserva,
           // @RequestParam MultipartFile imagenFile) {
       // if (!imagenFile.isEmpty()){
            //se sube la imagen al Storage
          //  reservaService.save(reserva);
          //  String rutaImagen=firebasStorageService.cargaImagen(imagenFile,
           //         "reserva", reserva.getIdReserva());
           // reserva.setRutaImagen(rutaImagen);
            
       // }
       // reservaService.save(reserva);
       // return"redirect:/reserva/listado";
    //}//
    @GetMapping("/eliminar/{idReserva}")
    public String eliminar (Reserva reserva) {
        reservaService.delete(reserva);
        return"redirect:/reserva/listado";
    }
    @GetMapping("/modificar/{idReserva}")
    public String modificar (Reserva reserva, Model model) {
        reserva = reservaService.getReserva(reserva);
        model.addAttribute("reserva", reserva);
        return"/reserva/modifica";
    }    
    
    
}
