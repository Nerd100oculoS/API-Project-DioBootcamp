package gabriel.api.projetoapispringbootdio.control;

import gabriel.api.projetoapispringbootdio.domain.model.Cliente;
import gabriel.api.projetoapispringbootdio.domain.model.Dividas;
import gabriel.api.projetoapispringbootdio.service.ClienteService;
import gabriel.api.projetoapispringbootdio.service.DividasService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/global")
public class GlobalController {

    private final ClienteService clienteService;
    private final DividasService dividasService;

    public GlobalController(ClienteService cl, DividasService dv){
        this.clienteService = cl;
        this.dividasService = dv;
    }

     // clientes
    @GetMapping("/clientes/{id}")
    public ResponseEntity<Cliente> findClienteById(@PathVariable Long id) {
        var cliente = clienteService.findClienteById(id);
        return ResponseEntity.ok(cliente);
    }

    @PostMapping("/clientes")
    public ResponseEntity<Cliente> createCliente(@RequestBody Cliente clienteToCreate) {
        var clienteCreated = clienteService.saveCliente(clienteToCreate);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(clienteCreated.getId())
                .toUri();
        return ResponseEntity.created(location).body(clienteCreated);
    }

    @PutMapping("/clientes/{id}")
    public ResponseEntity<Cliente> updateCliente(@PathVariable Long id, @RequestBody Cliente clienteToUpdate) {
        var clienteUpdated = clienteService.findClienteById(id);
        clienteToUpdate.setId(id);
        clienteUpdated = clienteService.saveCliente(clienteToUpdate);
        return ResponseEntity.ok(clienteUpdated);
    }

    @DeleteMapping("/clientes/{id}")
    public ResponseEntity<Void> deleteCliente(@PathVariable Long id) {
        clienteService.deleteCliente(id);
        return ResponseEntity.noContent().build();
    }

    // dívidas
    @GetMapping("/clientes/{clienteId}/dividas")
    public ResponseEntity<List<Dividas>> listarDividasDoCliente(@PathVariable Long clienteId) {
        var dividas = dividasService.listarDividasDoCliente(clienteId);
        return ResponseEntity.ok(dividas);
    }

    @PostMapping("/clientes/{clienteId}/dividas")
    public ResponseEntity<Dividas> createDivida(@PathVariable Long clienteId, @RequestBody Dividas dividaToCreate) {
        Cliente cliente = clienteService.findClienteById(clienteId);
        dividaToCreate.setCliente(cliente);
        var dividaCreated = dividasService.saveDividas(dividaToCreate);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(dividaCreated.getId())
                .toUri();
        return ResponseEntity.created(location).body(dividaCreated);
    }

    @PutMapping("/clientes/{clienteId}/dividas/{dividaId}")
    public ResponseEntity<Dividas> updateDivida(@PathVariable Long clienteId, @PathVariable int dividaId, @RequestBody Dividas dividaToUpdate) {
        dividaToUpdate.setId(dividaId);
        var dividaUpdated = dividasService.saveDividas(dividaToUpdate);
        return ResponseEntity.ok(dividaUpdated);
    }

    @DeleteMapping("/clientes/{clienteId}/dividas/{dividaId}")
    public ResponseEntity<Void> deleteDivida(@PathVariable Long clienteId, @PathVariable Long dividaId) {
        dividasService.deleteDividas(dividaId);
        return ResponseEntity.noContent().build();
    }

}
