package br.edu.femass.gui;

import java.net.URL;
import java.util.ResourceBundle;

import br.edu.femass.dao.Dao;
import br.edu.femass.model.Cliente;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class ClienteController implements Initializable {
    
    @FXML
    private TextField TxtNome;    
    
    @FXML
    private TextField TxtEndereco;

    @FXML 
    private ListView<Cliente> LstClientes;


    
    @FXML
    private void gravar_click(ActionEvent event) {
        Cliente cliente = new Cliente(
            TxtNome.getText(),
            TxtEndereco.getText());
            
            Dao<Cliente> dao = new Dao<>();
            dao.inserir(cliente);
            System.out.println(cliente.getId());
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
}
