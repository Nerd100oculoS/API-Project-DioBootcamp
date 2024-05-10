package gabriel.api.projetoapispringbootdio.service;

import gabriel.api.projetoapispringbootdio.domain.model.Cliente;
import gabriel.api.projetoapispringbootdio.domain.model.Dividas;

import java.util.List;

public interface ClienteService {

    List<Cliente> findAllClientes();

    Cliente findClienteById(Long id);

    Cliente saveCliente(Cliente cliente);

    void deleteCliente(Long id);

    List<Dividas> buscarDividasDoCliente(Long clienteId);
}
