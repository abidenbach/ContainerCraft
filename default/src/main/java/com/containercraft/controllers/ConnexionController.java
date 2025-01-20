package com.containercraft.controllers;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ConnexionController {

    @FXML
    private Button loginButton;
    
    @FXML 
    private TextField usernameField;

    @FXML 
    private PasswordField passwordField;

    @FXML 
    private Label errConnexion;

    @FXML
    private void initialize() {
        // Configurer l'action du bouton connexion
        loginButton.setOnAction(event -> clickLoginButton(event));
    }

    @FXML
    private void clickLoginButton(javafx.event.ActionEvent event) {
        if(usernameField.getText().equals("admin") && passwordField.getText().equals("admin")){
            System.out.println("Connexion réussie");
            errConnexion.setVisible(false);
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/views/accueil.fxml"));
                Parent root = loader.load();
                Scene scene = new Scene(root);
                Stage stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
                stage.setScene(scene);
                stage.setTitle("ContenairCraft");
                stage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else{
            System.out.println("Connexion échouée");
            errConnexion.setVisible(true);
        }
    }
}