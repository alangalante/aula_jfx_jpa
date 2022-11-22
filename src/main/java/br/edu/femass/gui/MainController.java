package br.edu.femass.gui;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainController implements Initializable {
    
    
    @FXML
    private void btnCadastrarCliente_Click(ActionEvent event) {
        try {
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/Cliente.fxml"));
        
        Scene scene = new Scene(root);
        scene.getStylesheets().add("/styles/Styles.css");
        scene.getRoot().setStyle("-fx-font-family: 'serif'");

        Stage stage = new Stage();
        stage.setTitle("Cadastro de Cliente");
        stage.setScene(scene);
        stage.show();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
   
    }    
}
