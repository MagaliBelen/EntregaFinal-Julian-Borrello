package service;

import org.springframework.stereotype.Service;

import model.ClienteModel;

import repository.ClienteRepository;

import java.util.Optional;


import exception.ClienteNotFoundException;


@Service
public class ClienteService {

    private ClienteRepository clienteRepository;

    
    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public ClienteModel crearCliente(ClienteModel clienteModel) {
       
        return clienteRepository.save(clienteModel);
    }

    public ClienteModel obtenerClientePorId(int clienteId) throws ClienteNotFoundException {
        Optional<ClienteModel> clienteOptional = clienteRepository.findById((long) clienteId);
        
        if (clienteOptional.isPresent()) {
            return clienteOptional.get();
        } else {
            throw new ClienteNotFoundException("Cliente no encontrado");
        }
    }

}

