package br.edu.femass.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Telefone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String numero;
    private String ddd;


    public Telefone(String numero, String ddd) {
        this.numero = numero;
        this.ddd = ddd;
    }

    public Telefone() {

    }

    public String getDdd() {
        return ddd;
    }

    public String getNumero() {
        return numero;
    }

    public void setDdd(String ddd) {
        this.ddd = ddd;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    @Override
    public String toString() {
        return "(" + this.ddd + ") " + this.numero;
    }

    
}
