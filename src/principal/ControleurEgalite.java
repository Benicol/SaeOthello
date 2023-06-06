/*
 * ControleurEgalite.java                                      3 Jun 2023
 * IUT Rodez, info1 2022-2023, pas de copyright ni "copyleft" 
 */
package principal;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import principal.modele.Modele;

/** TODO comment class responsibility (SRP)
 * @author benji
 *
 */
public class ControleurEgalite {
    
    @FXML
    private Text scores;
    
    @FXML
    private void initialize() {
        scores.setText(Modele.getJoueur1().getScore() + " à " + Modele.getJoueur2().getScore());
    }
    
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
    void rejouerPresser(ActionEvent event) {
        EchangeurDeVue.supprimerCache(1);
        EchangeurDeVue.echangerAvec(1, true);
    }
    
    @FXML
    void menuPresser(ActionEvent event) {
        EchangeurDeVue.echangerAvec(0, false);
    }
}
