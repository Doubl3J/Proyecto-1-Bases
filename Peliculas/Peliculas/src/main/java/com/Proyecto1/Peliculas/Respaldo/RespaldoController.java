package com.Proyecto1.Peliculas.Respaldo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/respaldo")
public class RespaldoController {

    @Autowired
    private RespaldoRepo respaldoRepository;

    @GetMapping ("/readAll")
    public List<Respaldo> getAllRespaldo (){
        List<Respaldo> respaldoList = respaldoRepository.findAll();
        return respaldoList;
    }

    @GetMapping ("/readById/{id}")
    public Respaldo getRespaldo(@PathVariable Long id){
        Respaldo respaldo = respaldoRepository.findById(id).orElse(null);
        return respaldo;
    }
}
