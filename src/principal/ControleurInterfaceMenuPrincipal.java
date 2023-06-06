/*
 * ControleurInterfaceMenuPrincipal.java                  30 mai 2023
 * IUT Rodez, info1 2022-2023, pas de copyright ni "copyleft" 
 */
package principal;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import principal.modele.Modele;
import principal.modele.Theme;

/** 
 * Contrôleur de InterfaceMenuPrincipal.fxml
 * @author groupe 32
 */
public class ControleurInterfaceMenuPrincipal {
    
	/* Au lancement de cette vue, désigne un thème par défaut */
    @FXML
    private void initialize() {
        Modele.setPalette(new Theme("#FFFFFF", "#000000"));
    }
    
    /*
     * Permet de changer de vue pour la vue du choix des pseudos
     * si le joueur clique sur "mode 2 joueurs".
     */
    @FXML
    void button2JoueursAppuyer(ActionEvent event) {
        Modele.setMode1Joueur(false);
        EchangeurDeVue.echangerAvec(2, false);
    }
    
    /*
     * Permet de changer de vue pour la vue du choix des pseudos
     * si le joueur clique sur "mode 1 joueur".
     */
    @FXML
    void button1JoueursAppuyer(ActionEvent event) {
        Modele.setMode1Joueur(true);
        EchangeurDeVue.echangerAvec(2, false);
    }
    
    /*
     * Permet de changer de vue pour la vue des chargements
     * si le joueur clique sur "charger".
     */
    @FXML
    void buttonChargerAppuyer(ActionEvent event) {
        Modele.setDernierMenuOuvert(0);
        EchangeurDeVue.echangerAvec(11, false);
    }
    
    /*
     * Permet de changer de vue pour la vue des chargements
     * si le joueur clique sur "charger".
     */
    @FXML
    void buttonAideAppuyer(ActionEvent event) {
        Modele.setDernierMenuOuvert(0);
        EchangeurDeVue.echangerAvec(6, false);
    }
    
    /*
     * Permet de changer de vue pour la vue des options
     * si le joueur clique sur "options".
     */
    @FXML
    void buttonOptionsAppuyer(ActionEvent event) {
        EchangeurDeVue.echangerAvec(9, false);
    }
    
    /*
     * Permet de quitter le logiciel
     * si le joueur clique sur "quitter".
     */
    @FXML
    void buttonQuitterAppuyer(ActionEvent event) {
        System.exit(0);
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
