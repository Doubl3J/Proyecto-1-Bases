package com.Proyecto1.Peliculas.Provincia;


import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/provincia/")
public class ProvinciaController {
    @Autowired
    private ProvinciaRepo provinciaRepository;

    @PostMapping("/add")
    public void createGenero(@Valid  @RequestBody Provincia provincia){
        provinciaRepository.save(provincia);
    }

    @PostMapping ("/addAll")
    public List<Provincia> createAllProvincia(@Valid @RequestBody List<Provincia> provinciaList){
        return provinciaRepository.saveAll(provinciaList);
    }

    @GetMapping ("/readAll")
    public List<Provincia> getAllProvincia(){
        List<Provincia> provinciaList = provinciaRepository.findAll();
        return provinciaList;
    }

    @GetMapping ("/readById/{id}")
    public Provincia getProvincia(@PathVariable Long id){
        Provincia provincia = provinciaRepository.findById(id).orElse(null);
        return provincia;
    }

    @PutMapping ("/update/{id}")
    public Provincia updateProvincia(@Valid @PathVariable Long id, @RequestBody Provincia provinciaActualizado){
        Provincia existe = provinciaRepository.findById(id).orElse(null);

        if (existe != null){
            existe.setNombre_provincia(provinciaActualizado.getNombre_provincia());
            provinciaRepository.save(existe);
            return existe;
        }
        else{
            return null;
        }
    }

    @DeleteMapping("/delete/{id}")
    public void deletePersona(@PathVariable Long id) {provinciaRepository.deleteById(id);}
}
