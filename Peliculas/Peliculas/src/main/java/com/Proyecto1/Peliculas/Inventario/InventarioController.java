package com.Proyecto1.Peliculas.Inventario;


import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/inventario")
@CrossOrigin(origins = "*")
public class InventarioController {

    @Autowired
    private InventarioRepo inventarioRepository;

    @PostMapping("/add")
    @CrossOrigin(origins = "*")
    public void createInventario(@Valid @RequestBody Inventario inventario){
        inventarioRepository.save(inventario);
    }

    @PostMapping ("/addAll")
    @CrossOrigin(origins = "*")
    public List<Inventario> createAllInventario(@Valid @RequestBody List<Inventario> inventarioList){
        return inventarioRepository.saveAll(inventarioList);
    }

    @GetMapping ("/readAll")
    @CrossOrigin(origins = "*")
    public List<Inventario> getAllInventario (){
        List<Inventario> inventarioList = inventarioRepository.findAll();
        return inventarioList;
    }

    @GetMapping ("/readById/{id}")
    @CrossOrigin(origins = "*")
    public Inventario getInventario(@PathVariable Long id){
        Inventario inventario = inventarioRepository.findById(id).orElse(null);
        return inventario;
    }

    @PutMapping ("/update/{id}")
    @CrossOrigin(origins = "*")
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
    @CrossOrigin(origins = "*")
    public void deleteInventario(@PathVariable Long id) {inventarioRepository.deleteById(id);}
}
