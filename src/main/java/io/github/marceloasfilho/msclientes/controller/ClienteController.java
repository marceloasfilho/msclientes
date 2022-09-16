package io.github.marceloasfilho.msclientes.controller;

import io.github.marceloasfilho.msclientes.dto.ClienteDTO;
import io.github.marceloasfilho.msclientes.entity.Cliente;
import io.github.marceloasfilho.msclientes.service.ClienteService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.transaction.Transactional;
import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("/clientes")
@Slf4j
public class ClienteController {

    public final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping
    public String status() {
        log.info("Status MSCLIENTES");
        return "UP";
    }

    @Transactional
    @PostMapping(path = "/salvar")
    public ResponseEntity<URI> salvarCliente(@RequestBody ClienteDTO clienteDTO) {
        this.clienteService.salvarAluno(clienteDTO.toModel());
        URI headerLocation = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .query("cpf = {cpf}")
                .buildAndExpand(clienteDTO.getCpf())
                .toUri();
        return ResponseEntity.created(headerLocation).build();
    }

    @GetMapping(path = "/obterDados", params = "cpf")
    public ResponseEntity<Cliente> obterDadosClientePorCPF(@RequestParam("cpf") String cpf) {
        Optional<Cliente> cliente = this.clienteService.obterClientePorCPF(cpf);

        if (cliente.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(cliente.get(), HttpStatus.OK);
    }
}