package com.containercraft.controllers;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Hyperlink;
import javafx.stage.Stage;

public class ConnexionController {

    @FXML
    private Hyperlink signupLink;

    @FXML
    private void initialize() {
        // Configurer l'action du lien "S'inscrire"
        signupLink.setOnAction(event -> handleSignupLink(event));
    }

    @FXML
    public void handleSignupLink(javafx.event.ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/views/inscription.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage stage = (Stage) ((Hyperlink) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.setTitle("ContainerCraft - Inscription");
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void handleLoginButtonAction() {
        // Ajoutez ici le code pour gérer l'action de connexion
        System.out.println("Bouton de connexion cliqué");
    }
}