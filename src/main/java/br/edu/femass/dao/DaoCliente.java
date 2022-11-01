package br.edu.femass.dao;

import java.util.List;


import br.edu.femass.model.Cliente;

public class DaoCliente extends Dao<Cliente>{

    public List<Cliente> buscarTodos() {
        return em.createQuery("select c from Cliente c order by c.nome").getResultList();
    }
    
}
