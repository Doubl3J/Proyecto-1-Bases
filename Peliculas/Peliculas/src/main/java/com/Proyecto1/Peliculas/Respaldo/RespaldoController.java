package com.Proyecto1.Peliculas.Respaldo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/respaldo")
@CrossOrigin(origins = "*")
public class RespaldoController {

    @Autowired
    private RespaldoRepo respaldoRepository;

    @GetMapping ("/readAll")
    @CrossOrigin(origins = "*")
    public List<Respaldo> getAllRespaldo (){
        List<Respaldo> respaldoList = respaldoRepository.findAll();
        return respaldoList;
    }

    @GetMapping ("/readById/{id}")
    @CrossOrigin(origins = "*")
    public Respaldo getRespaldo(@PathVariable Long id){
        Respaldo respaldo = respaldoRepository.findById(id).orElse(null);
        return respaldo;
    }
}
