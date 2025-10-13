package com.Proyecto1.Peliculas.Cliente;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/cliente/")
public class ClienteController {

    @Autowired
    private ClienteRepo clienteRepository;

    @PostMapping("/add")
    public void createCliente(@Valid @RequestBody Cliente cliente){
        clienteRepository.save(cliente);
    }

    @PostMapping ("/addAll")
    public List<Cliente> createAllCliente(@Valid @RequestBody List<Cliente> clienteList){
        return clienteRepository.saveAll(clienteList);
    }

    @GetMapping ("/readAll")
    public List<Cliente> getAllCliente (){
        List<Cliente> clienteList = clienteRepository.findAll();
        return clienteList;
    }

    @GetMapping ("/readById/{id}")
    public Cliente getCliente(@PathVariable Long id){
        Cliente cliente = clienteRepository.findById(id).orElse(null);
        return cliente;
    }

    @PutMapping ("/update/{id}")
    public Cliente updateCliente(@Valid @PathVariable Long id, @RequestBody Cliente clienteActualizado){
        Cliente existe = clienteRepository.findById(id).orElse(null);

        if (existe != null){
            existe.setNombre(clienteActualizado.getNombre());
            existe.setPrimer_apellido(clienteActualizado.getPrimer_apellido());
            existe.setSegundo_apellido(clienteActualizado.getSegundo_apellido());
            existe.setEmail(clienteActualizado.getEmail());
            existe.setNumero_telefono(clienteActualizado.getNumero_telefono());
            clienteRepository.save(existe);
            return existe;
        }
        else{
            return null;
        }
    }

    @DeleteMapping("/delete/{id}")
    public void deleteCliente(@PathVariable Long id) {clienteRepository.deleteById(id);}
}
