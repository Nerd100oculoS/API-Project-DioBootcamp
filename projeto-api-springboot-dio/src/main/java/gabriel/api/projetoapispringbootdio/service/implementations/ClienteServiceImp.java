package gabriel.api.projetoapispringbootdio.service.implementations;

import gabriel.api.projetoapispringbootdio.domain.model.Cliente;
import gabriel.api.projetoapispringbootdio.domain.model.Dividas;
import gabriel.api.projetoapispringbootdio.domain.repository.ClienteRepository;
import gabriel.api.projetoapispringbootdio.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class ClienteServiceImp implements ClienteService {

    private final ClienteRepository clienteRepository;

    @Autowired
    public ClienteServiceImp(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @Override
    public List<Cliente> findAllClientes() {
        return clienteRepository.findAll();
    }

    @Override
    public Cliente findClienteById(Long id) {
        return clienteRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Cliente não encontrado com o ID: " + id));
    }

    @Override
    public Cliente saveCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    @Override
    public void deleteCliente(Long id) {
        clienteRepository.deleteById(id);
    }

    @Override
    public List<Dividas> buscarDividasDoCliente(Long clienteId) {
        Cliente cliente = clienteRepository.findById(clienteId)
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado com o ID: " + clienteId));
        return cliente.getDividas();
    }
}
