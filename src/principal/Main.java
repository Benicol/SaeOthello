/* Programme principal de l'application calcul de la réduction 05/23 */
package principal;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;

/**
 * Classe principale de l'application calcul de la réduction La fenêtre
 * principale est affichée via une vue décrite dans un fichier fxml
 * 
 * @author Groupe 32
 */
public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {

        /*
         * création d'un chargeur de code FXML et chargement de la vue de l'application
         */
        FXMLLoader chargeurFXML = new FXMLLoader();
        chargeurFXML.setLocation(getClass().getResource("InterfaceMenuPrincipal.fxml"));
        Parent racine;
        try {
            racine = chargeurFXML.load();
            Scene scene = new Scene(racine);
            scene.getRoot().requestFocus();

            // on définit les caractéristiques de la fenêtre et lui associe la scène
            primaryStage.setTitle("Othello");
            primaryStage.setHeight(700);
            primaryStage.setWidth(600);
            EchangeurDeVue.setSceneCourante(scene);
            primaryStage.setScene(scene);
            EchangeurDeVue.setStage(primaryStage);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Programme principal
     * 
     * @param args non utilisé
     */
    public static void main(String[] args) {
        launch(args); // appelera la méthode start
    }
}