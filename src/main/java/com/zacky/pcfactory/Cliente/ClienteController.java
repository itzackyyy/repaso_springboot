package com.zacky.pcfactory.Cliente;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController()
@RequestMapping("/api/v1")

public class ClienteController {

    @Autowired //instanciamos una clase y la traemos aqui :D
    private ClienteService clienteService;

    @GetMapping("/cliente")
    public List<ClienteModel> listarClientes(){
    return clienteService.obtenerClientes();
    }

    @GetMapping("/cliente/{id}")
    public ResponseEntity<ClienteModel> obtenerCliPorId(@PathVariable("id") Long id){
        return clienteService.obtenerCliPorId(id)
                .map(ResponseEntity::ok)//si existe, HTTP 200 y entrega el cliente
                .orElse(ResponseEntity.notFound().build()); //devuelve 404 Not found
    }

    @DeleteMapping("/cliente/{id}")
    public ResponseEntity<String> eliminarClientePorId(@PathVariable("id") Long id){

    boolean clienteEliminado = clienteService.eliminarCliPorId(id);
    if (clienteEliminado)
    {return ResponseEntity.ok("Cliente eliminado");
    }else {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Cliente con el id: "+id+ "no encontrado, 404");
    }

    }

}
