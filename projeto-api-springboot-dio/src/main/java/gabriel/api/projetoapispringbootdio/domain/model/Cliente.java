package gabriel.api.projetoapispringbootdio.domain.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "Cliente")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String endereco;
    private String telefone;
    private String email;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Dividas> dividas;

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return this.endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return this.telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Dividas> getDividas() {
        return dividas;
    }

    public void setDividas(List<Dividas> dividas) {
        this.dividas = dividas;
    }
}


