package com.programming.web.fatec.api_fatec.domain.cliente;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.programming.web.fatec.api_fatec.entities.Cliente;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;

    public List<Cliente> listarClientes(){
        return clienteRepository.findAll();
    }

    public Cliente criarCliente(Cliente cliente){
        cliente.setId(null);
        return clienteRepository.save(cliente);
    }
}
