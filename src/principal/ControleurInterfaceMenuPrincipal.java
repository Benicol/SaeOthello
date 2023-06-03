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
        EchangeurDeVue.echangerAvec(2, 400, 800);
    }
    
    @FXML
    void button1JoueursAppuyer(ActionEvent event) {
        System.out.println("1 joueurs appuyer");
    }
    
    @FXML
    void buttonChargerAppuyer(ActionEvent event) {
        System.out.println("charger appuyer");
    }
    
    @FXML
    void buttonOptionsAppuyer(ActionEvent event) {
        System.out.println("options appuyer");
    }
    
    @FXML
    void buttonQuitterAppuyer(ActionEvent event) {
        System.out.println("quitter appuyer");
        System.exit(0);
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
