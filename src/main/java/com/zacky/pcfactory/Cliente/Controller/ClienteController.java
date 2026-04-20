package com.zacky.pcfactory.Cliente.Controller;


<<<<<<< HEAD
import java.util.List;

=======
import com.zacky.pcfactory.Cliente.Model.ClienteModel;
import com.zacky.pcfactory.Cliente.Repository.ClienteRepository;
import com.zacky.pcfactory.Cliente.Service.ClienteService;
>>>>>>> origin/master
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

<<<<<<< HEAD
import com.zacky.pcfactory.Cliente.Model.ClienteModel;
import com.zacky.pcfactory.Cliente.Service.ClienteService;
=======
import java.util.List;
>>>>>>> origin/master

@RestController
@RequestMapping("/api/v1")

public class ClienteController {

    private final ClienteRepository clienteRepository;

    @Autowired //instanciamos una clase y la traemos aqui :D
    private ClienteService clienteService;

    ClienteController(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

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
    



}
