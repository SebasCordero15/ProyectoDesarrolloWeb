/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto06.proyecto06.controller;



import com.proyecto06.proyecto06.domain.Contacto;
import com.proyecto06.proyecto06.services.ContactoService;
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
@RequestMapping("/contacto")
public class ContactoController {
    
    @Autowired
    private ContactoService contactoService;
    
    @GetMapping("/listado")
    public String listado(Model model){
        var lista = contactoService.getContacto(false);
        model.addAttribute("contacto", lista);
        model.addAttribute("totalContacto", lista.size());
        
        return "/contacto/listado";
        
    }
//    @Autowired
//    private FirebaseStorageService firebasStorageService;
//    @PostMapping("/guardar")
//    public String guardar(Contacto contacto,
//            @RequestParam MultipartFile imagenFile) {
//        if (!imagenFile.isEmpty()){
//            //se sube la imagen al Storage
//            contactoService.save(contacto);
//            String rutaImagen=firebasStorageService.cargaImagen(imagenFile,
//                    "contacto", contacto.getIdContacto());
//            contacto.setRutaImagen(rutaImagen);
//            
//        }
//        contactoService.save(contacto);
//        return"redirect:/contacto/listado";
//    }
    @GetMapping("/eliminar/{idContacto}")
    public String eliminar (Contacto contacto) {
        contactoService.delete(contacto);
        return"redirect:/contacto/listado";
    }
    @GetMapping("/modificar/{idContacto}")
    public String modificar (Contacto contacto, Model model) {
        contacto = contactoService.getContacto(contacto);
        model.addAttribute("contacto", contacto);
        return"/contacto/modifica";
    }    
    
    
}
