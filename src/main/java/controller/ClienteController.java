package controller;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import exception.ClienteNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import model.ClienteModel;

import service.ClienteService;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

    private ClienteService clienteService;

    @Autowired
    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @PostMapping
    public ResponseEntity<ClienteModel> crearCliente(@RequestBody ClienteModel clienteModel) {
        ClienteModel nuevoCliente = clienteService.crearCliente(clienteModel);
        return new ResponseEntity<>(nuevoCliente, HttpStatus.CREATED);
    }

    @GetMapping("/{clienteId}")
    public ResponseEntity<ClienteModel> obtenerClientePorId(@PathVariable int clienteId) {
        try {
            ClienteModel cliente = clienteService.obtenerClientePorId(clienteId);
            return new ResponseEntity<>(cliente, HttpStatus.OK);
        } catch (ClienteNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


}
