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
import principal.modele.Theme;

/** TODO comment class responsibility (SRP)
 * @author benji
 *
 */
public class ControleurEgalite {
    
    @FXML
    private Text scores;
    
    @FXML
    private void initialize() {
        scores.setText(Modele.getScores()[0] + " à " + Modele.getScores()[1]);
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
    
    @FXML
    void rejouerPresser(ActionEvent event) {
        EchangeurDeVue.supprimerCache(3);
        EchangeurDeVue.echangerAvec(1, 700, 600);
    }
    
    @FXML
    void menuPresser(ActionEvent event) {
        EchangeurDeVue.supprimerCache(3);
        EchangeurDeVue.echangerAvec(0, 700, 600);
    }
}
