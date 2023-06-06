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
import principal.modele.Theme;

/** TODO comment class responsibility (SRP)
 * @author benji
 *
 */
public class ControleurInterfaceMenuPrincipal {
    
    @FXML
    private void initialize() {
        Modele.setPalette(new Theme("#FFFFFF", "#000000"));
    }
    
    @FXML
    void button2JoueursAppuyer(ActionEvent event) {
        Modele.setMode1Joueur(false);
        EchangeurDeVue.echangerAvec(2, false);
    }
    
    @FXML
    void button1JoueursAppuyer(ActionEvent event) {
        Modele.setMode1Joueur(true);
        EchangeurDeVue.echangerAvec(2, false);
    }
    
    @FXML
    void buttonChargerAppuyer(ActionEvent event) {
        Modele.setDernierMenuOuvert(0);
        EchangeurDeVue.echangerAvec(11, false);
    }
    
    @FXML
    void buttonAideAppuyer(ActionEvent event) {
        Modele.setDernierMenuOuvert(0);
        EchangeurDeVue.echangerAvec(6, false);
    }
    
    @FXML
    void buttonOptionsAppuyer(ActionEvent event) {
        EchangeurDeVue.echangerAvec(9, false);
    }
    
    @FXML
    void buttonQuitterAppuyer(ActionEvent event) {
        System.exit(0);
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

}
