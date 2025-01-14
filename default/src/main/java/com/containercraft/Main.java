package com.containercraft;

import java.io.IOException;
import java.io.InputStream;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 * Classe principale de l'application ContainerCraft.
 * Gère le démarrage et l'initialisation de la fenêtre principale.
 */
public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        try {
            // Initialise et affiche la fenêtre principale
            initializeStage(primaryStage);
        } catch (IOException e) {
            handleError(e);
        }
    }

    /**
     * Initialise la fenêtre principale avec le fichier FXML.
     *
     * @param primaryStage la fenêtre principale
     * @throws IOException si le fichier FXML est introuvable ou ne peut pas être chargé
     */
    private void initializeStage(Stage primaryStage) throws IOException {
        // Charge la vue de connexion
        Parent root = loadFXML("/com/views/connexion.fxml");

        // Configure la scène
        Scene scene = new Scene(root);

        // Charge l'icône de l'application
        InputStream iconStream = getClass().getResourceAsStream("/com/views/images/CCLogo_jpg.jpg");
        if (iconStream != null) {
            Image icon = new Image(iconStream);
            primaryStage.getIcons().add(icon);
        } else {
            System.err.println("L'icône de l'application n'a pas été trouvée.");
        }

        // Configure et affiche la fenêtre
        primaryStage.setTitle("ContainerCraft - Connexion");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false); // Empêche le redimensionnement de la fenêtre
        primaryStage.show();
    }

    /**
     * Charge un fichier FXML et retourne son contenu sous forme de Parent.
     *
     * @param fxmlPath le chemin relatif du fichier FXML
     * @return l'objet Parent représentant le contenu FXML
     * @throws IOException si le fichier FXML ne peut pas être chargé
     */
    private Parent loadFXML(String fxmlPath) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlPath));
        if (loader.getLocation() == null) {
            throw new IOException("Le fichier FXML '" + fxmlPath + "' n'a pas été trouvé.");
        }
        return loader.load();
    }

    /**
     * Gère les erreurs en affichant un message d'erreur dans la console et termine l'application.
     *
     * @param e l'exception levée
     */
    private void handleError(Exception e) {
        System.err.println("Une erreur est survenue : " + e.getMessage());
        e.printStackTrace();
        System.exit(1); // Termine l'application en cas d'erreur critique
    }

    /**
     * Point d'entrée de l'application.
     *
     * @param args les arguments de la ligne de commande
     */
    public static void main(String[] args) {
        launch(args);
    }
}
