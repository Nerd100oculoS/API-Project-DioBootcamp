package gabriel.api.projetoapispringbootdio.service.implementations;

import gabriel.api.projetoapispringbootdio.domain.model.Dividas;
import gabriel.api.projetoapispringbootdio.domain.repository.DividasRepository;
import gabriel.api.projetoapispringbootdio.service.DividasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class DividasServiceImp implements DividasService {
    private final DividasRepository dividasRepository;

    @Autowired
    public DividasServiceImp(DividasRepository dividasRepository) {
        this.dividasRepository = dividasRepository;
    }

    @Override
    public List<Dividas> findAllDividas() {
        return dividasRepository.findAll();
    }

    @Override
    public Dividas findDividasById(Long id) {
        return dividasRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Dívida não encontrada com o ID: " + id));
    }

    @Override
    public Dividas saveDividas(Dividas dividas) {
        return dividasRepository.save(dividas);
    }

    @Override
    public void deleteDividas(Long id) {
        dividasRepository.deleteById(id);
    }

    @Override
    public List<Dividas> listarDividasDoCliente(Long clienteId) {
        return dividasRepository.findByClienteId(clienteId);
    }
}
