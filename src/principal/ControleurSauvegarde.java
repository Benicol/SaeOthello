/*
 * ControleurSauvegarde.java                                      30 mai 2023
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
 * Contrôleur de Sauvegarde.fxml
 * @author groupe 32
 */
public class ControleurSauvegarde {
    
	/* message qui s'affiche si l'utilisateur choisi un nom de sauvegarde invalide */
    @FXML
    private Label messageErreur;

    /* zone de saisie pour le nom de la sauvegarde */
    @FXML
    private TextField entrer;

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

    /* 
     * Crée une nouvelle sauvegarde si le nom choisi est correct 
     * puis redirige vers le menu en jeu.
     */
    @FXML
    void sauvegarderCliquer(ActionEvent event) {
        if (!entrer.getText().matches("^[a-zA-Z0-9 ]*$")) {
            messageErreur.setText("Veuillez uniquement utiliser des lettres et chiffres");
            messageErreur.setOpacity(1);
        } else if (entrer.getText().length() > 30){
            messageErreur.setText("Le nom de la sauvegarde doit faire 30 caractères maximum");
            messageErreur.setOpacity(1);
        } else {
            Sauvegarde nouvelleSauvegarde = new Sauvegarde(entrer.getText());
            nouvelleSauvegarde.enregistrer();
            EchangeurDeVue.echangerAvec(5, false);
        }
    }
    
    /*
     * Permet de changer de vue pour la vue menu en jeu
     * si le joueur clique sur "retour".
     */
    @FXML
    void retourCliquer(ActionEvent event) {
        EchangeurDeVue.echangerAvec(5, false);
    }

}
