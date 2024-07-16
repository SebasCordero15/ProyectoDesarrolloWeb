/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tienda.Tienda.controller;



import com.tienda.Tienda.domain.Producto;
import com.tienda.Tienda.services.ProductoService;
import com.tienda.Tienda.services.FirebaseStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/producto")
public class ProductoController {
    
    @Autowired
    private ProductoService productoService;
    
    @GetMapping("/listado")
    public String listado(Model model){
        var lista = productoService.getProducto(false);
        model.addAttribute("productos", lista);
        model.addAttribute("totalProductos", lista.size());
        
        return "/producto/listado";
        
    }
    @Autowired
    private FirebaseStorageService firebasStorageService;
    @PostMapping("/guardar")
    public String guardar(Producto producto,
            @RequestParam MultipartFile imagenFile) {
        if (!imagenFile.isEmpty()){
            //se sube la imagen al Storage
            productoService.save(producto);
            String rutaImagen=firebasStorageService.cargaImagen(imagenFile,
                    "producto", producto.getIdProducto());
            producto.setRutaImagen(rutaImagen);
            
        }
        productoService.save(producto);
        return"redirect:/producto/listado";
    }
    @GetMapping("/eliminar/{idProducto}")
    public String eliminar (Producto producto) {
        productoService.delete(producto);
        return"redirect:/producto/listado";
    }
    @GetMapping("/modificar/{idProducto}")
    public String modificar (Producto producto, Model model) {
        producto = productoService.getProducto(producto);
        model.addAttribute("producto", producto);
        return"/producto/modifica";
    }    
    
    
}
