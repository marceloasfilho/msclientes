package io.github.marceloasfilho.msclientes.dto;

import io.github.marceloasfilho.msclientes.entity.Cliente;
import lombok.Data;

@Data
public class ClienteDTO {
    private String cpf;
    private String nome;
    private Integer idade;

    public Cliente toModel() {
        return new Cliente(this.nome, this.cpf, this.idade);
    }
}
