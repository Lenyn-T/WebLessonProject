package com.programming.web.fatec.api_fatec.controllers;

import com.programming.web.fatec.api_fatec.domain.cliente.ClienteService;
import com.programming.web.fatec.api_fatec.entities.Cliente;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cliente")
public class ClienteController {
    @Autowired
    private ClienteService clienteService;

    private static final Logger logger = LoggerFactory.getLogger(ClienteController.class.getName());

    private final List<Cliente> clientes = new ArrayList<>();
    private Long idCount = 1L;

    //http://localhost:8080/api/cliente/criarCliente => POST
    @PostMapping("/criarCliente")
    public String CriarCliente(@RequestBody Cliente cliente){

        cliente.setId(idCount++);
        clientes.add(cliente);

        logger.info("Recebido JSON: Nome={}, Idade={}", cliente.getNome(), cliente.getIdade());
        return "O Cliente "+cliente.getNome()+" de idade "+cliente.getIdade()+" morador da rua: "+cliente.getLogradouro()+" foi criado.";
    }

    @GetMapping("/listarClientes")
    public List<Cliente> ListarClientes() {
        return clienteService.listarClientes();
    }

    @DeleteMapping("/deletarCliente/{id}")
    public String DeletarCliente(@PathVariable Long id){
        for (Cliente cliente: clientes){
            if (cliente.getId().equals(id)) {
                clientes.remove(cliente);
                return "Cliente "+cliente.getNome()+" removido.";
            }
        }

        return "Cliente inexistente.";
    }

    @PutMapping("/alterarCliente/{id}/{nome}")
    public String AlterarCliente(@PathVariable Long id, @PathVariable String nome){
        for (Cliente cliente: clientes){
            if (cliente.getId().equals(id)) {
                cliente.setNome(nome);
                return "Cliente id "+cliente.getId()+" alterado nome para: "+cliente.getNome();
            }
        }

        return "Cliente inexistente.";
    }
}