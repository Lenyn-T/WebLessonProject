package com.programming.web.fatec.api_fatec.domain.cliente;

import java.util.List;
import java.util.Optional;

import com.programming.web.fatec.api_fatec.entities.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;

    public List<Cliente> listarClientes(){
        return clienteRepository.findAll();
    }

    public Cliente criarCliente(Cliente cliente) {
         cliente.setId(null);
         return clienteRepository.save(cliente);
     }
 
     public boolean atualizarCliente(Long id, Cliente clienteAtualizado) {
         Optional<Cliente> clienteOptional = buscarClientePorId(id);
         if (clienteOptional.isPresent()) {
             Cliente cliente = clienteOptional.get();
             cliente.setNome(clienteAtualizado.getNome());
             cliente.setIdade(clienteAtualizado.getIdade());
             cliente.setLogradouro(clienteAtualizado.getLogradouro());
             clienteRepository.save(cliente);
             return true;
         }
         return false;
     }
 
     public boolean deletarCliente(Long id) {
         if (clienteRepository.existsById(id)) {
             clienteRepository.deleteById(id);
             return true;
         }
         return false;
     }
 
     public Optional<Cliente> buscarClientePorId(Long id) {
         return clienteRepository.findById(id);
     }
}
