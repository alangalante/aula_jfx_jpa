package br.edu.femass.gui;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import br.edu.femass.dao.DaoCliente;
import br.edu.femass.model.Cliente;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
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

    @FXML 
    private TableView<Cliente> tabela = new TableView<Cliente>();

    @FXML 
    private TableColumn<Cliente,String> colNome = new TableColumn<>();

    @FXML 
    private TableColumn<Cliente,String> colEndereco = new TableColumn<>();

    @FXML 
    private TableColumn<Cliente,Long> colId = new TableColumn<>();

    @FXML
    private ComboBox<Cliente> CboClientes;



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
        preencherTabela();
        preencherCombo();
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
    
    private void preencherCombo() {
        List<Cliente> clientes = dao.buscarTodos();

        ObservableList<Cliente> data = FXCollections.observableArrayList(clientes);
        CboClientes.setItems(data);
    }    
    
    
    private void preencherTabela() {
        List<Cliente> clientes = dao.buscarTodosPorId();

        ObservableList<Cliente> data = FXCollections.observableArrayList(clientes);
        tabela.setItems(data);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        colNome.setCellValueFactory(
            new PropertyValueFactory<Cliente, String>("nome")
        );        
        
        colEndereco.setCellValueFactory(
            new PropertyValueFactory<Cliente, String>("endereco")
        );
        
        colId.setCellValueFactory(
            new PropertyValueFactory<Cliente, Long>("id")
        );


        preencherLista();
        preencherTabela();
        preencherCombo();
    }    
}
