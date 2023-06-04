/*
 * ControleurInterfaceMenuPrincipal.java                                      3 Jun 2023
 * IUT Rodez, info1 2022-2023, pas de copyright ni "copyleft" 
 */
package principal;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import principal.modele.Modele;

/** TODO comment class responsibility (SRP)
 * @author benji
 *
 */
public class ControleurJeuMenu {
    
    @FXML
    private void initialize() {
    }
    
    @FXML
    void reprendrePartiePressed(ActionEvent event) {
        EchangeurDeVue.echangerAvec(1, false);
    }
    
    @FXML
    void redemarrerPressed(ActionEvent event) {
        EchangeurDeVue.supprimerCache(1);
        EchangeurDeVue.echangerAvec(1, true);
    }
    
    @FXML
    void sauvegarderPressed(ActionEvent event) {
        EchangeurDeVue.echangerAvec(10, false);
    }
    
    @FXML
    void chargerPressed(ActionEvent event) {
        Modele.setDernierMenuOuvert(5);
        EchangeurDeVue.echangerAvec(11, false);
    }
    
    @FXML
    void aidePressed(ActionEvent event) {
        Modele.setDernierMenuOuvert(5);
        EchangeurDeVue.echangerAvec(6, false);
    }
    
    @FXML
    void menuPressed(ActionEvent event) {
        EchangeurDeVue.supprimerCache(1);
        EchangeurDeVue.echangerAvec(0, false);
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
