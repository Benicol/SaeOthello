/*
 * ControleurPseudo.java                                      3 Jun 2023
 * IUT Rodez, info1 2022-2023, pas de copyright ni "copyleft" 
 */
package principal;

import principal.modele.Sauvegarde;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

/**
 * TODO comment class responsibility (SRP)
 * 
 * @author benji
 *
 */
public class ControleurSauvegarde {
    
    @FXML
    private Label messageErreur;

    @FXML
    private TextField entrer;

    @FXML
    private Text labelPrincipal;

    @FXML
    void buttonEntered(MouseEvent event) {
        Button boutton = (Button) event.getSource();
        boutton.getStyleClass().remove("buttonExited");
        boutton.getStyleClass().add("buttonEntered");
    }

    @FXML
    void buttonExited(MouseEvent event) {
        Button boutton = (Button) event.getSource();
        boutton.getStyleClass().remove("buttonEntered");
        boutton.getStyleClass().add("buttonExited");
    }

    @FXML
    void sauvegarderCliquer(ActionEvent event) {
        if (!entrer.getText().matches("^[a-zA-Z0-9 ]*$")) {
            messageErreur.setText("Veuillez uniquement utiliser des lettres et chiffres (pas d'espace)");
            messageErreur.setOpacity(1);
        } else if (entrer.getText().length() > 30){
            messageErreur.setText("Votre Pseudonyme doit faire moins de 30 caractères");
            messageErreur.setOpacity(1);
        } else {
            Sauvegarde nouvelleSauvegarde = new Sauvegarde(entrer.getText());
            nouvelleSauvegarde.enregistrer();
            EchangeurDeVue.echangerAvec(5, false);
        }
    }
    
    @FXML
    void retourCliquer(ActionEvent event) {
        EchangeurDeVue.echangerAvec(5, false);
    }

}
