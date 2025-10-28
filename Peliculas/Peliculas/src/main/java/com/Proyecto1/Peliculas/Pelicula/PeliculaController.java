package com.Proyecto1.Peliculas.Pelicula;


import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/pelicula")
@CrossOrigin(origins = "*")
public class PeliculaController {

    @Autowired
    private PeliculaRepo peliculaRepository;

    @PostMapping("/add")
    @CrossOrigin(origins = "*")
    public void createPelicula(@Valid  @RequestBody Pelicula pelicula){peliculaRepository.save(pelicula);}

    @PostMapping ("/addAll")
    @CrossOrigin(origins = "*")
    public List<Pelicula> createAllPelicula(@Valid @RequestBody List<Pelicula> peliculaList){
        return peliculaRepository.saveAll(peliculaList);
    }

    @GetMapping ("/readAll")
    @CrossOrigin(origins = "*")
    public List<Pelicula> getAllPelicula (){
        List<Pelicula> peliculaList = peliculaRepository.findAll();
        return peliculaList;
    }

    @GetMapping ("/readById/{id}")
    @CrossOrigin(origins = "*")
    public Pelicula getPelicula(@PathVariable Long id){
        Pelicula pelicula = peliculaRepository.findById(id).orElse(null);
        return pelicula;
    }

    @PutMapping ("/update/{id}")
    @CrossOrigin(origins = "*")
    public Pelicula updatePelicula(@Valid @PathVariable Long id, @RequestBody Pelicula peliculaActualizado){
        Pelicula existe = peliculaRepository.findById(id).orElse(null);

        if (existe != null){
            existe.setNombre_pelicula(peliculaActualizado.getNombre_pelicula());
            existe.setIdioma(peliculaActualizado.getIdioma());
            existe.setPrecio_venta(peliculaActualizado.getPrecio_venta());
            existe.setGenero(peliculaActualizado.getGenero());
            peliculaRepository.save(existe);
            return existe;
        }
        else{
            return null;
        }
    }

    @DeleteMapping("/delete/{id}")
    @CrossOrigin(origins = "*")
    public void deletePelicula(@PathVariable Long id) {peliculaRepository.deleteById(id);}

}
