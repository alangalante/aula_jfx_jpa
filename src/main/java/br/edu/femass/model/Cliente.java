package br.edu.femass.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String endereco;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Telefone> telefones;
    
    public Cliente(String nome, String endereco) {
        this.nome = nome;
        this.endereco = endereco;
    }

    public Cliente() {

    }

    public String getEndereco() {
        return endereco;
    }

    public String getNome() {
        return nome;
    }

    public Long getId() {
        return id;
    }

    @Override
    public String toString() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public void adicionarTelefone(String ddd, String numero) {
        if (telefones==null) telefones = new ArrayList();
        telefones.add(new Telefone(ddd,numero));
    }
}
