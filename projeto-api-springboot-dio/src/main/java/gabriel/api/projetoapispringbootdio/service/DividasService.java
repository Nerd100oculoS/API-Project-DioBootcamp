package gabriel.api.projetoapispringbootdio.service;

import gabriel.api.projetoapispringbootdio.domain.model.Dividas;

import java.util.List;

public interface DividasService {

    List<Dividas> findAllDividas();
    Dividas findDividasById(Long id);
    Dividas saveDividas(Dividas dividas);
    void deleteDividas(Long id);
    List<Dividas> listarDividasDoCliente(Long clienteId);
}
