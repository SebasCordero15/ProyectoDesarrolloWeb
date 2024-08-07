/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto06.proyecto06.controller;

import com.proyecto06.proyecto06.domain.Paquetes;
import com.proyecto06.proyecto06.services.CategoriaService;
import com.proyecto06.proyecto06.services.PaquetesService;
import com.proyecto06.proyecto06.services.PaquetesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;



@Controller
public class indexController {

    @Autowired
    private PaquetesService paquetesService;
   

    @GetMapping("/")
    public String listado(Model model) {
        var paquetes = paquetesService.getPaquetes(true);
        model.addAttribute("paquetes", paquetes);
        

        return "index"; 

    }
   
}
