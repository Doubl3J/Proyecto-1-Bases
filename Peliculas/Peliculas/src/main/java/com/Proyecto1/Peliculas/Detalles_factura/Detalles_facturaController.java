package com.Proyecto1.Peliculas.Detalles_factura;


import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/detalles")
public class Detalles_facturaController {

    @Autowired
    private Detalles_facturaRepo detallesRepository;

    @PostMapping("/add")
    public void createDetalles( @Valid @RequestBody Detalles_factura detalles){
        detallesRepository.save(detalles);
    }

    @PostMapping ("/addAll")
    public List<Detalles_factura> createAllDetalles(@Valid @RequestBody List<Detalles_factura> detallesList){
        return detallesRepository.saveAll(detallesList);
    }

    @GetMapping ("/readAll")
    public List<Detalles_factura> getAllDetalles (){
        List<Detalles_factura> detallesList = detallesRepository.findAll();
        return detallesList;
    }

    @GetMapping ("/readById/{id}")
    public Detalles_factura getDetalles(@PathVariable Long id){
        Detalles_factura detalles = detallesRepository.findById(id).orElse(null);
        return detalles;
    }

    @PutMapping ("/update/{id}")
    public Detalles_factura updateDetalles(@Valid @PathVariable Long id, @RequestBody Detalles_factura detallesActualizado){
        Detalles_factura existe = detallesRepository.findById(id).orElse(null);

        if (existe != null){
            existe.setFactura(detallesActualizado.getFactura());
            existe.setPelicula(detallesActualizado.getPelicula());
            detallesRepository.save(existe);
            return existe;
        }
        else{
            return null;
        }
    }

    @DeleteMapping("/delete/{id}")
    public void deleteDetalles(@PathVariable Long id) {detallesRepository.deleteById(id);}
}