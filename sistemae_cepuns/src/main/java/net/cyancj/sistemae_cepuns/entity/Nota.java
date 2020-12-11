package net.cyancj.sistemae_cepuns.entity;

import javax.persistence.*;

@Entity
public class Nota {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String tipo;

    @ManyToOne
    @JoinColumn(name = "matricula_id", nullable = false, foreignKey = @ForeignKey(name = "fk_matricula"), referencedColumnName = "id")
    private Matricula matricula;

    private Double nota;

    public Nota() {

    }

    public Nota(Long id, String tipo, Matricula matricula, Double nota) {
        this.id = id;
        this.tipo = tipo;
        this.matricula = matricula;
        this.nota = nota;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Matricula getMatricula() {
        return matricula;
    }

    public void setMatricula(Matricula matricula) {
        this.matricula = matricula;
    }

    public Double getNota() {
        return nota;
    }

    public void setNota(Double nota) {
        this.nota = nota;
    }
}
