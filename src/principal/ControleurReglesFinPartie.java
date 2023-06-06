/*
 * ControleurReglesFinPartie.java                                      4 Jun 2023
 * IUT Rodez, info1 2022-2023, pas de copyright ni "copyleft" 
 */
package principal;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

/** 
 * Contrôleur de ReglesFinPartie.fxml
 * @author groupe 32
 */
public class ControleurReglesFinPartie {
    
	/*
     * Permet de changer de vue pour la vue des règles "comment jouer"
     * si le joueur clique sur "suivant".
     */
    @FXML
    void suivantPresse(ActionEvent event) {
        EchangeurDeVue.echangerAvec(8, false);
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
