/*
 * ControleurInterfaceMenuOptions.java                                      30 mai 2023
 * IUT Rodez, info1 2022-2023, pas de copyright ni "copyleft" 
 */
package principal;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import principal.modele.Modele;

/** 
 * Contrôleur de InterfaceMenuOptions.fxml
 * @author groupe 32
 */
public class ControleurInterfaceMenuOptions {
    
	/* Texte d'affichage du bouton "mode de difficulté */
    @FXML
    
    private void initialize() {
        if (Modele.isMode1JoueurDifficile()) {
            textDifficulte.setText("MODE DIFFICILE : ON");
        } else {
            textDifficulte.setText("MODE DIFFICILE : OFF");
        }
    }
    
    @FXML
    private Text textDifficulte;
    
	/* 
	 * Méthode permettant de modifier l'affichage du bouton "mode de 
	 * difficulté en fonction de la difficulté sélectionnée
	 * 	- "OFF" en mode facile
	 * 	- "ON" en mode difficile
	 */
    @FXML
    void switchDifficulte(ActionEvent event) {
        if (Modele.isMode1JoueurDifficile()) {
            textDifficulte.setText("MODE DIFFICILE : OFF");
            Modele.setMode1JoueurDifficile(false);
        } else {
            textDifficulte.setText("MODE DIFFICILE : ON");
            Modele.setMode1JoueurDifficile(true);
        }
    }

    /*
     * Permet de changer de vue pour retourner au menu principal
     * si le joueur clique sur "retour/menu principal".
     */
    @FXML
    void menuPressed(ActionEvent event) {
        EchangeurDeVue.echangerAvec(0, false);
    }
    
    /*
     * Au survol d'un bouton, le style de celui-ci est modifié et devient plus foncé.
     */
    @FXML
    void buttonEntered(MouseEvent event) {
        Button boutton = (Button) event.getSource();
        boutton.getStyleClass().remove("buttonExited");
        boutton.getStyleClass().add("buttonEntered");
    }

    /*
     * Quand, en survol, on sort d'un bouton, le style de celui-ci 
     * est modifié pour revenir à son état initial.
     */
    @FXML
    void buttonExited(MouseEvent event) {
        Button boutton = (Button) event.getSource();
        boutton.getStyleClass().remove("buttonEntered");
        boutton.getStyleClass().add("buttonExited");
    }
}
