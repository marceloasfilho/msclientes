package io.github.marceloasfilho.msclientes.service;

import io.github.marceloasfilho.msclientes.entity.Cliente;

import java.util.Optional;

public interface ClienteService {

    void salvarCliente(Cliente cliente);

    Optional<Cliente> obterClientePorCPF(String CPF);
}
