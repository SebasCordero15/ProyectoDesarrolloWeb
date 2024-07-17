/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto06.proyecto06.controller;



import com.proyecto06.proyecto06.domain.Pagos;
import com.proyecto06.proyecto06.services.PagosService;
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
@RequestMapping("/pagos")
public class PagosController {
    
    @Autowired
    private PagosService pagosService;
    
    @GetMapping("/listado")
    public String listado(Model model){
        var lista = pagosService.getPagos(false);
        model.addAttribute("pagos", lista);
        model.addAttribute("totalPagos", lista.size());
        
        return "/pagos/listado";
        
    }
    @Autowired
    private FirebaseStorageService firebasStorageService;
    @PostMapping("/guardar")
    public String guardar(Pagos pagos,
            @RequestParam MultipartFile imagenFile) {
        if (!imagenFile.isEmpty()){
            //se sube la imagen al Storage
            pagosService.save(pagos);
            String rutaImagen=firebasStorageService.cargaImagen(imagenFile,
                    "pagos", pagos.getIdPago());
            pagos.setRutaImagen(rutaImagen);
            
        }
        pagosService.save(pagos);
        return"redirect:/pagos/listado";
    }
    @GetMapping("/eliminar/{idPagos}")
    public String eliminar (Pagos pagos) {
        pagosService.delete(pagos);
        return"redirect:/pagos/listado";
    }
    @GetMapping("/modificar/{idPagos}")
    public String modificar (Pagos pagos, Model model) {
        pagos = pagosService.getPagos(pagos);
        model.addAttribute("pagos", pagos);
        return"/pagos/modifica";
    }    
    
    
}
