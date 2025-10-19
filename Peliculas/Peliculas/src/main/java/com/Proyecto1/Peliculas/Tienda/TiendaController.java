package com.Proyecto1.Peliculas.Tienda;


import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tienda")

public class TiendaController {
    @Autowired
    private TiendaRepo tiendaRepository;

    @PostMapping("/add")
    public void createTienda(@Valid @RequestBody Tienda tienda){
        tiendaRepository.save(tienda);
    }

    @PostMapping ("/addAll")
    public List<Tienda> createAllTienda(@Valid @RequestBody List<Tienda> tiendaList){
        return tiendaRepository.saveAll(tiendaList);
    }

    @GetMapping ("/readAll")
    public List<Tienda> getAllTienda (){
        List<Tienda> tiendaList = tiendaRepository.findAll();
        return tiendaList;
    }

    @GetMapping ("/readById/{id}")
    public Tienda getTienda(@PathVariable Long id){
        Tienda tienda = tiendaRepository.findById(id).orElse(null);
        return tienda;
    }

    @PutMapping ("/update/{id}")
    public Tienda updateTienda(@Valid @PathVariable Long id, @RequestBody Tienda tiendaActualizado){
        Tienda existe = tiendaRepository.findById(id).orElse(null);

        if (existe != null){
            existe.setNombre_tienda(tiendaActualizado.getNombre_tienda());
            existe.setEmail_tienda(tiendaActualizado.getEmail_tienda());
            existe.setTelefono_tienda(tiendaActualizado.getTelefono_tienda());
            existe.setDireccion_exacta(tiendaActualizado.getDireccion_exacta());
            existe.setProvincia(tiendaActualizado.getProvincia());
            tiendaRepository.save(existe);
            return existe;
        }
        else{
            return null;
        }
    }

    @DeleteMapping("/delete/{id}")
    public void deleteTienda(@PathVariable Long id) {tiendaRepository.deleteById(id);}
}
