/*
 * ControleurRegles.java                                      4 Jun 2023
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
public class ControleurInterfaceMenuOptions {
    
    @FXML
    private Text textDifficulte;
    
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

    @FXML
    void menuPressed(ActionEvent event) {
        EchangeurDeVue.echangerAvec(0, 700, 600, false);
    }
    
    @FXML
    void buttonEntered(MouseEvent event) {
        Button boutton = (Button) event.getSource();
        String beforeStyle = boutton.getStyle();
        int premierePointVirgule = beforeStyle.indexOf(";") + 1;
        boutton.setStyle("-fx-background-color: #008656;"
                         + beforeStyle.substring(premierePointVirgule,
                                                         beforeStyle.length()));
    }

    @FXML
    void buttonExited(MouseEvent event) {
        Button boutton = (Button) event.getSource();
        String beforeStyle = boutton.getStyle();
        int premierePointVirgule = beforeStyle.indexOf(";") + 1;
        boutton.setStyle("-fx-background-color: #009E6D;"
                + beforeStyle.substring(premierePointVirgule,
                                                beforeStyle.length()));
    }
}
