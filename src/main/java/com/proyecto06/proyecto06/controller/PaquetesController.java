/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto06.proyecto06.controller;

import com.proyecto06.proyecto06.domain.Paquetes;
import com.proyecto06.proyecto06.services.CategoriaService;
import com.proyecto06.proyecto06.services.PaquetesService;
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
@RequestMapping("/paquetes")
public class PaquetesController {

    @Autowired
    private PaquetesService paquetesService;
    @Autowired
    private CategoriaService categoriaService;

    @GetMapping("/listado")
    public String listado(Model model) {
        var paquetes = paquetesService.getPaquetes(false);
        model.addAttribute("paquetes", paquetes);
        model.addAttribute("totalPaquetes", paquetes.size());
        var categorias = categoriaService.getCategoria(false);
        model.addAttribute("categorias", categorias);

        return "/paquetes/listado"; 

    }
    @Autowired
    private FirebaseStorageService firebasStorageService;

    @PostMapping("/guardar")
    public String guardar(Paquetes paquetes,
            @RequestParam MultipartFile imagenFile) {
        if (!imagenFile.isEmpty()) {
            //se sube la imagen al Storage
            paquetesService.save(paquetes);
            String rutaImagen = firebasStorageService.cargaImagen(imagenFile,
                    "paquetes", paquetes.getIdPaquete());
            paquetes.setRutaImagen(rutaImagen);

        }
        paquetesService.save(paquetes);
        return "redirect:/paquetes/listado";
    }

    @GetMapping("/eliminar/{idPaquete}")
    public String eliminar(Paquetes paquetes) {
        paquetesService.delete(paquetes);
        return "redirect:/paquetes/listado";
    }

    @GetMapping("/modificar/{idPaquete}")
    public String modificar(Paquetes paquetes, Model model) {
        paquetes = paquetesService.getPaquetes(paquetes);
        model.addAttribute("paquetes", paquetes);
        var categorias = categoriaService.getCategoria(false);
        model.addAttribute("categorias", categorias);
        return "/paquetes/modifica";
    }

}
