/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto06.proyecto06.controller;



import com.proyecto06.proyecto06.domain.Checkin;
import com.proyecto06.proyecto06.domain.Checkin;
import com.proyecto06.proyecto06.services.CheckinService;
import com.proyecto06.proyecto06.services.CheckinService;
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
@RequestMapping("/checkin")
public class CheckinController {

    @Autowired
    private CheckinService checkinService;

    @GetMapping("/listado")
    public String listado(Model model) {
        var lista = checkinService.getCheckin();
        model.addAttribute("checkin", lista);
        model.addAttribute("totalCheckin", lista.size());

        return "/checkin/listado";
    }

    @PostMapping("/guardar")
    public String guardar(Checkin checkin) {
        checkinService.save(checkin);
        return "redirect:/checkin/listado";
    }
    
    @GetMapping("/eliminar/{idCheckin}")
    public String eliminar(Checkin checkin) {
        checkinService.delete(checkin);
        return "redirect:/checkin/listado";
    }

    @GetMapping("/modificar/{idCheckin}")
    public String modificar(Checkin checkin, Model model) {
        checkin = checkinService.getCheckin(checkin);
        model.addAttribute("checkin", checkin);
        return "/checkin/modifica";
    }

}
