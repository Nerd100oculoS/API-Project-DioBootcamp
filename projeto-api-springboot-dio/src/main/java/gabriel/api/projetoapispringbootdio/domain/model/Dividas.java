package gabriel.api.projetoapispringbootdio.domain.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "dividas")
public class Dividas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private float valor;

    private String status;

    @Column(name = "data_vencimento")
    private Date dataVencimento;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(Date dataVencimento) {
        this.dataVencimento = dataVencimento;
    }
}