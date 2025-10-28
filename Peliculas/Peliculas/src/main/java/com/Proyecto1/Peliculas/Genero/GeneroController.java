package com.Proyecto1.Peliculas.Genero;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/genero")
@CrossOrigin(origins = "*")
public class GeneroController {

    @Autowired
    private GeneroRepo generoRepository;

    @PostMapping("/add")
    @CrossOrigin(origins = "*")
    public void createGenero(@Valid  @RequestBody Genero genero){
        generoRepository.save(genero);
    }

    @PostMapping ("/addAll")
    @CrossOrigin(origins = "*")
    public List<Genero> createAllGenero(@Valid @RequestBody List<Genero> generoList){
        return generoRepository.saveAll(generoList);
    }

    @GetMapping ("/readAll")
    @CrossOrigin(origins = "*")
    public List<Genero> getAllGenero (){
        List<Genero> generoList = generoRepository.findAll();
        return generoList;
    }

    @GetMapping ("/readById/{id}")
    @CrossOrigin(origins = "*")
    public Genero getGenero(@PathVariable Long id) {
        Genero genero = generoRepository.findById(id).orElse(null);
        return genero;
    }

    @PutMapping("/update/{id}")
    @CrossOrigin(origins = "*")
    public Genero updateGenero(@Valid @PathVariable Long id, @RequestBody Genero generoActualizado){
        Genero existe = generoRepository.findById(id).orElse(null);

        if (existe != null){
            existe.setNombre_genero(generoActualizado.getNombre_genero());
            generoRepository.save(existe);
            return existe;
        }
        else{
            return null;
        }
    }

    @DeleteMapping ("/delete/{id}")
    @CrossOrigin(origins = "*")
    public void deleteGenero (@PathVariable Long id) {generoRepository.deleteById(id);}
}
