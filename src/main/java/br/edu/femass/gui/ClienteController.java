package br.edu.femass.gui;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import br.edu.femass.dao.Dao;
import br.edu.femass.dao.DaoCliente;
import br.edu.femass.model.Cliente;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

public class ClienteController implements Initializable {
    
    @FXML
    private TextField TxtNome;    
    
    @FXML
    private TextField TxtEndereco;

    @FXML 
    private ListView<Cliente> LstClientes;

    @FXML 
    private Button BtnIncluir;

    @FXML 
    private Button BtnAlterar;
    @FXML 
    private Button BtnExcluir;
    @FXML 
    private Button BtnGravar;


    private DaoCliente dao = new DaoCliente();

    private Cliente cliente;

    private Boolean incluindo;
    
    @FXML
    private void gravar_click(ActionEvent event) {

        cliente.setNome(TxtNome.getText());
        cliente.setEndereco(TxtEndereco.getText());
        
        if (incluindo) {
            dao.inserir(cliente);
        } else {
            dao.alterar(cliente);
        }

        preencherLista();
        editar(false);
    }
    
    @FXML
    private void incluir_click(ActionEvent event) {
        editar(true);
        
        incluindo = true;

        cliente = new Cliente();
        TxtEndereco.setText("");
        TxtNome.setText("");
        TxtNome.requestFocus();


    }

    @FXML
    private void alterar_click(ActionEvent event) {
        editar(true);

        incluindo = false;
    }

    @FXML
    private void excluir_click(ActionEvent event) {
        dao.apagar(cliente);
        preencherLista();
    }

    @FXML 
    private void LstClientes_KeyPressed(KeyEvent event) {
        exibirDados();
    }

    @FXML
    private void LstClientes_MouseClicked(MouseEvent event) {
        exibirDados();
    }

    private void editar(boolean habilitar) {
        LstClientes.setDisable(habilitar);
        TxtEndereco.setDisable(!habilitar);
        TxtNome.setDisable(!habilitar);
        BtnGravar.setDisable(!habilitar);
        BtnAlterar.setDisable(habilitar);
        BtnIncluir.setDisable(habilitar);
        BtnExcluir.setDisable(habilitar);


    }

    private void exibirDados() {
        this.cliente = LstClientes.getSelectionModel().getSelectedItem();

        if (cliente==null) return;

        TxtEndereco.setText(cliente.getEndereco());
        TxtNome.setText(cliente.getNome());
    }
    

    private void preencherLista() {
        List<Cliente> clientes = dao.buscarTodos();

        ObservableList<Cliente> data = FXCollections.observableArrayList(clientes);
        LstClientes.setItems(data);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        preencherLista();
    }    
}
