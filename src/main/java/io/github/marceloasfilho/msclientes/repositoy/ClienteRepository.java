package io.github.marceloasfilho.msclientes.repositoy;

import io.github.marceloasfilho.msclientes.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    @Query(value = "SELECT * FROM cliente WHERE cpf=:cpf", nativeQuery = true)
    Optional<Cliente> obterClientePorCPF(@Param("cpf") String cpf);
}
