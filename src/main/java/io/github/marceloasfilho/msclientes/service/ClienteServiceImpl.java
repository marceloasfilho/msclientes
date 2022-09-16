package io.github.marceloasfilho.msclientes.service;

import io.github.marceloasfilho.msclientes.entity.Cliente;
import io.github.marceloasfilho.msclientes.repositoy.ClienteRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClienteServiceImpl implements ClienteService {

    public final ClienteRepository clienteRepository;

    public ClienteServiceImpl(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @Override
    public void salvarAluno(Cliente cliente) {
        this.clienteRepository.save(cliente);
    }

    @Override
    public Optional<Cliente> obterClientePorCPF(String cpf) {
        return this.clienteRepository.obterClientePorCPF(cpf);
    }
}