
package com.proyecto06.proyecto06.services.impl;

import com.proyecto06.proyecto06.dao.*;
import com.proyecto06.proyecto06.domain.*;
import com.proyecto06.proyecto06.services.ItemService;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private HttpSession session;

    @Override
    public List<Item> gets() {
        List<Item> listaItems = (List) session.getAttribute("listaItems");
        return listaItems;
    }

    @Override
    public Item get(Item item) {
        List<Item> listaItems = (List) session.getAttribute("listaItems");
        if (listaItems != null) {
            for (Item i : listaItems) {
                if (i.getIdPaquete() == item.getIdPaquete()) {
                    return i;
                }
            }
        }
        return null;
    }

    @Override
    public void delete(Item item) {
        List<Item> listaItems = (List) session.getAttribute("listaItems");
        if (listaItems != null) {
            var posicion = -1;
            var existe = false;
            for (Item i : listaItems) {
                posicion++;
                if (i.getIdPaquete() == item.getIdPaquete()) {
                    existe = true;
                    break;
                }
            }
            if (existe) {
                listaItems.remove(posicion);
                session.setAttribute("listaItems", listaItems);
            }
        }
    }

    @Override
    public void save(Item item) {
        List<Item> listaItems = (List) session.getAttribute("listaItems");
        if (listaItems == null) {
            listaItems = new ArrayList<>();
        }
        var existe = false;
        for (Item i : listaItems) {
            if (i.getIdPaquete() == item.getIdPaquete()) {
                existe = true;
                if (i.getCantidad() < i.getExistencias()) {
                    i.setCantidad(i.getCantidad() + 1);
                }
                break;
            }
        }
        if (!existe) {
            item.setCantidad(1);
            listaItems.add(item);
        }
        session.setAttribute("listaItems", listaItems);
    }

    @Override
    public void update(Item item) {
        List<Item> listaItems = (List) session.getAttribute("listaItems");
        if (listaItems != null) {
            for (Item i : listaItems) {
                if (i.getIdPaquete() == item.getIdPaquete()) {
                    i.setCantidad(item.getCantidad());
                    session.setAttribute("listaItems", listaItems);
                    break;
                }
            }
        }
    }

    @Autowired
    private UsuarioDao usuarioDao;
    @Autowired
    private PaquetesDao paquetesDao;
    @Autowired
    private FacturaDao facturaDao;
    @Autowired
    private VentaDao ventaDao;

    @Override
    public void facturar() {
        //Se debe recuperar el usuario autenticado y obtener su idUsuario
        String username;
        Object principal = SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getPrincipal();

        if (principal instanceof UserDetails userDetails) {
            username = userDetails.getUsername();
        } else {
            username = principal.toString();
        }

        if (username.isBlank()) {
            System.out.println("username en blanco...");
            return;
        }

        Usuario usuario = usuarioDao.findByUsername(username);
        if (usuario == null) {
            System.out.println("Usuario no existe en usuarios...");
            return;
        }

        //Se debe registrar la factura incluyendo el usuario
        Factura factura = new Factura(usuario.getIdUsuario());
        factura = facturaDao.save(factura);

        //Se debe registrar las ventas de cada paquetes -actualizando existencias-
        List<Item> listaItems = (List) session.getAttribute("listaItems");
        if (listaItems != null) {
            double total = 0;
            for (Item i : listaItems) {
                Paquetes paquetes = paquetesDao.getReferenceById(i.getIdPaquete());
                if (paquetes.getExistencias() >= i.getCantidad()) {
                    Venta venta = new Venta(factura.getIdFactura(),
                            i.getIdPaquete(),
                            i.getPrecio(),
                            i.getCantidad());
                    ventaDao.save(venta);
                    paquetes.setExistencias(paquetes.getExistencias() - i.getCantidad());
                    paquetesDao.save(paquetes);
                    total += i.getCantidad() * i.getPrecio();
                }
            }

            //Se debe registrar el total de la venta en la factura
            factura.setTotal(total);
            facturaDao.save(factura);

            //Se debe limpiar el carrito la lista...
            listaItems.clear();
        }
    }

    public double getTotal() {
        //Se debe registrar las ventas de cada paquetes -actualizando existencias-
        List<Item> listaItems = (List) session.getAttribute("listaItems");
        double total = 0;
        if (listaItems != null) {
            for (Item i : listaItems) {
                total += i.getCantidad() * i.getPrecio();
            }
        }
        return total;
    }
}

