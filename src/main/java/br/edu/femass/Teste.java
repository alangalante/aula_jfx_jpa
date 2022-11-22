package br.edu.femass;

import br.edu.femass.dao.DaoCliente;
import br.edu.femass.model.Cliente;

public class Teste {

    public static void main(String[] args) {
        Cliente c = new Cliente("João", "Rua A");
        c.adicionarTelefone("22", "123456");

        new DaoCliente().inserir(c);
        
    }
    
}
