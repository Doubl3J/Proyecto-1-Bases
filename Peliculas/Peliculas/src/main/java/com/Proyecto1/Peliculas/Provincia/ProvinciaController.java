package com.Proyecto1.Peliculas.Provincia;


import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/provincia")
@CrossOrigin(origins = "*")
public class ProvinciaController {
    @Autowired
    private ProvinciaRepo provinciaRepository;

    @PostMapping("/add")
    @CrossOrigin(origins = "*")
    public void createGenero(@Valid  @RequestBody Provincia provincia){
        provinciaRepository.save(provincia);
    }

    @PostMapping ("/addAll")
    @CrossOrigin(origins = "*")
    public List<Provincia> createAllProvincia(@Valid @RequestBody List<Provincia> provinciaList){
        return provinciaRepository.saveAll(provinciaList);
    }

    @GetMapping ("/readAll")
    @CrossOrigin(origins = "*")
    public List<Provincia> getAllProvincia(){
        List<Provincia> provinciaList = provinciaRepository.findAll();
        return provinciaList;
    }

    @GetMapping ("/readById/{id}")
    @CrossOrigin(origins = "*")
    public Provincia getProvincia(@PathVariable Long id){
        Provincia provincia = provinciaRepository.findById(id).orElse(null);
        return provincia;
    }

    @PutMapping ("/update/{id}")
    @CrossOrigin(origins = "*")
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
    @CrossOrigin(origins = "*")
    public void deletePersona(@PathVariable Long id) {provinciaRepository.deleteById(id);}
}
