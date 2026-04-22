package com.zacky.pcfactory.Cliente.Controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.zacky.pcfactory.Cliente.Model.ClienteModel;
import com.zacky.pcfactory.Cliente.Repository.ClienteRepository;
import com.zacky.pcfactory.Cliente.Service.ClienteService;

@RestController
@RequestMapping("/api/v1")

public class ClienteController {

    private final ClienteRepository clienteRepository;

    ClienteController(ClienteRepository clienteRepository) {
        
        this.clienteRepository = clienteRepository;
    }


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

    @PostMapping("/cliente")
    public String agregarCliente(@RequestBody ClienteModel clienteModel){
        clienteService.guardarCliente(clienteModel);        
        return HttpStatus.CREATED.toString();
    }

    @PutMapping("cliente/{id}")
    public ResponseEntity<ClienteModel> actualizarCliente(@PathVariable("id") Long id, @RequestBody ClienteModel cliModel){
        return clienteRepository.findById(id)
        .map(clienteRegistrado ->

            {
            clienteRegistrado.setNombreCliente(cliModel.getNombreCliente());
            clienteRegistrado.setPriApeCliente(cliModel.getPriApeCliente());
            clienteRegistrado.setSecApeCliente(cliModel.getSecApeCliente());


            ClienteModel clienteActualizado = clienteRepository.save(clienteRegistrado);

            return ResponseEntity.ok(clienteActualizado);
            })
            .orElseGet(()-> ResponseEntity.notFound().build());
    }
    



}
