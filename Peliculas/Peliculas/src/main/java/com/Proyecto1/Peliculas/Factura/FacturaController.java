package com.Proyecto1.Peliculas.Factura;


import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/factura")
@CrossOrigin(origins = "*")
public class FacturaController {

    @Autowired
    private FacturaRepo facturaRepository;

    @PostMapping("/add")
    @CrossOrigin(origins = "*")
    public void createFactura(@Valid @RequestBody Factura factura){
        facturaRepository.save(factura);
    }

    @PostMapping ("/addAll")
    @CrossOrigin(origins = "*")
    public List<Factura> createAllFactura(@Valid @RequestBody List<Factura> facturaList){
        return facturaRepository.saveAll(facturaList);
    }

    @GetMapping ("/readAll")
    @CrossOrigin(origins = "*")
    public List<Factura> getAllFactura (){
        List<Factura> facturaList = facturaRepository.findAll();
        return facturaList;
    }

    @GetMapping ("/readById/{id}")
    @CrossOrigin(origins = "*")
    public Factura getFactura(@PathVariable Long id){
        Factura factura = facturaRepository.findById(id).orElse(null);
        return factura;
    }

    @PutMapping ("/update/{id}")
    @CrossOrigin(origins = "*")
    public Factura updateFactura(@Valid @PathVariable Long id, @RequestBody Factura facturaActualizado){
        Factura existe = facturaRepository.findById(id).orElse(null);

        if (existe != null){
            existe.setFecha_factura(facturaActualizado.getFecha_factura());
            existe.setTotal_factura(facturaActualizado.getTotal_factura());
            existe.setCliente(facturaActualizado.getCliente());
            existe.setTienda(facturaActualizado.getTienda());
            facturaRepository.save(existe);
            return existe;
        }
        else{
            return null;
        }
    }

    @DeleteMapping("/delete/{id}")
    @CrossOrigin(origins = "*")
    public void deleteFactura(@PathVariable Long id) {facturaRepository.deleteById(id);}
}
