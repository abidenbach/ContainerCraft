package com.containercraft.controllers;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Hyperlink;
import javafx.stage.Stage;

public class InscriptionController {

    @FXML
    private Hyperlink loginLink;

    @FXML
    private void initialize() {
        // Configurer l'action du lien "Déjà un compte ? Connectez-vous"
        loginLink.setOnAction(event -> handleLoginLink(event));
    }

    @FXML
    public void handleLoginLink(javafx.event.ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/views/connexion.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage stage = (Stage) ((Hyperlink) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.setTitle("ContenairCraft - Connexion");
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
