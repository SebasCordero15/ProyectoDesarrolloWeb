
package com.proyecto06.proyecto06.controller;

import com.proyecto06.proyecto06.domain.*;
import com.proyecto06.proyecto06.services.ItemService;
import com.proyecto06.proyecto06.services.PaquetesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CarritoController {
    @Autowired
    private ItemService itemService;
    @Autowired
    private PaquetesService paqueteService;

    //Para ver el carrito
    @GetMapping("/carrito/listado")
    public String inicio(Model model) {
        var items = itemService.gets();
        model.addAttribute("items", items);
        var carritoTotalVenta = 0;
        for (Item i : items) {
            carritoTotalVenta += (i.getCantidad() * i.getPrecio());
        }
        model.addAttribute("carritoTotal", 
                carritoTotalVenta);
        return "/carrito/listado";
    }    
   
    //Para Agregar un paquete al carrito
    @GetMapping("/carrito/agregar/{idPaquetes}")
    public ModelAndView agregarItem(Model model, Item item) {
        Item item2 = itemService.get(item);
        if (item2 == null) {
            Paquetes paquete = paqueteService.getPaquetes(item);
            item2 = new Item(paquete);
        }
        itemService.save(item2);
        var lista = itemService.gets();
        var totalCarritos = 0;
        var carritoTotalVenta = 0;
        for (Item i : lista) {
            totalCarritos += i.getCantidad();
            carritoTotalVenta += (i.getCantidad() * i.getPrecio());
        }
        model.addAttribute("listaItems", lista);
        model.addAttribute("listaTotal", totalCarritos);
        model.addAttribute("carritoTotal", carritoTotalVenta);
        return new ModelAndView("/carrito/fragmentos :: verCarrito");
    }

    //Para mofificar un paquete del carrito
    @GetMapping("/carrito/modificar/{idPaquetes}")
    public String modificarItem(Item item, Model model) {
        item = itemService.get(item);
        model.addAttribute("item", item);
        return "/carrito/modifica";
    }

    //Para eliminar un elemento del carrito
    @GetMapping("/carrito/eliminar/{idPaquetes}")
    public String eliminarItem(Item item) {
        itemService.delete(item);
        return "redirect:/carrito/listado";
    }

    //Para actualizar un paquete del carrito (cantidad)
    @PostMapping("/carrito/guardar")
    public String guardarItem(Item item) {
        itemService.update(item);
        return "redirect:/carrito/listado";
    }

    //Para facturar los paquetes del carrito... no implementado...
    @GetMapping("/facturar/carrito")
    public String facturarCarrito() {
        itemService.facturar();
        return "redirect:/";
    }

}