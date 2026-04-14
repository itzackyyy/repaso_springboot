package com.zacky.pcfactory.Cliente;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired //instanciamos repository
    private ClienteRepository clienteRepository;

    //metodo para obtener a todos los clientes
    public List<ClienteModel> obtenerClientes(){
    return clienteRepository.findAll();
    }

    //metodo para guardar a un cliente
    public ClienteModel guardarCliente(ClienteModel cli){
        return clienteRepository.save(cli);
    }

    //metodo para encontrar a un cliente mediante su id
    public Optional<ClienteModel> obtenerCliPorId(long id){
        return clienteRepository.findById(id);
    }


    //metodo para eliminar por Id
    public boolean eliminarCliPorId (Long id){
    if (clienteRepository.existsById(id)){
        clienteRepository.deleteById(id);
        return true;
    } else {return false;}
    }


}
