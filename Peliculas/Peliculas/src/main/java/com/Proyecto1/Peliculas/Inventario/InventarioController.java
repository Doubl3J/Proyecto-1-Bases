package com.Proyecto1.Peliculas.Inventario;


import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/inventario")
public class InventarioController {

    @Autowired
    private InventarioRepo inventarioRepository;

    @PostMapping("/add")
    public void createInventario(@Valid @RequestBody Inventario inventario){
        inventarioRepository.save(inventario);
    }

    @PostMapping ("/addAll")
    public List<Inventario> createAllInventario(@Valid @RequestBody List<Inventario> inventarioList){
        return inventarioRepository.saveAll(inventarioList);
    }

    @GetMapping ("/readAll")
    public List<Inventario> getAllInventario (){
        List<Inventario> inventarioList = inventarioRepository.findAll();
        return inventarioList;
    }

    @GetMapping ("/readById/{id}")
    public Inventario getInventario(@PathVariable Long id){
        Inventario inventario = inventarioRepository.findById(id).orElse(null);
        return inventario;
    }

    @PutMapping ("/update/{id}")
    public Inventario updateInventario(@Valid @PathVariable Long id, @RequestBody Inventario inventarioActualizado){
        Inventario existe = inventarioRepository.findById(id).orElse(null);

        if (existe != null){
            existe.setCantidad_disponible(inventarioActualizado.getCantidad_disponible());
            existe.setPelicula(inventarioActualizado.getPelicula());
            existe.setTienda(inventarioActualizado.getTienda());
            inventarioRepository.save(existe);
            return existe;
        }
        else{
            return null;
        }
    }

    @DeleteMapping("/delete/{id}")
    public void deleteInventario(@PathVariable Long id) {inventarioRepository.deleteById(id);}
}
