/*
 * ControleurJeuMenu.java                                      30 mai 2023
 * IUT Rodez, info1 2022-2023, pas de copyright ni "copyleft" 
 */
package principal;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import principal.modele.Modele;

/** 
 * Contrôleur de JeuMenu.fxml
 * @author groupe 32
 */
public class ControleurJeuMenu {
    
	/*
     * Permet de changer de vue pour retourner au jeu en cours
     * si le joueur clique sur "reprendre la partie".
     */
    @FXML
    void reprendrePartiePressed(ActionEvent event) {
        EchangeurDeVue.echangerAvec(1, false);
    }
    
    /*
     * Permet de changer de vue pour une nouvelle partie 
     * (avec les mêmes pseudos) si le joueur clique sur "redémarrer".
     */
    @FXML
    void redemarrerPressed(ActionEvent event) {
        EchangeurDeVue.supprimerCache(1);
        EchangeurDeVue.echangerAvec(1, true);
    }
    
    /*
     * Permet de changer de vue pour la vue des sauvegardes 
     * si le joueur clique sur "sauvegarder".
     */
    @FXML
    void sauvegarderPressed(ActionEvent event) {
        EchangeurDeVue.echangerAvec(10, false);
    }
    
    /*
     * Permet de changer de vue pour la vue des chargements 
     * si le joueur clique sur "charger".
     */
    @FXML
    void chargerPressed(ActionEvent event) {
        Modele.setDernierMenuOuvert(5);
        EchangeurDeVue.echangerAvec(11, false);
    }
    
    /*
     * Permet de changer de vue pour la vue des aides de jeu 
     * si le joueur clique sur "aide".
     */
    @FXML
    void aidePressed(ActionEvent event) {
        Modele.setDernierMenuOuvert(5);
        EchangeurDeVue.echangerAvec(6, false);
    }
    
    /*
     * Permet de changer de vue pour la vue du menu principal 
     * si le joueur clique sur "menu principal".
     */
    @FXML
    void menuPressed(ActionEvent event) {
        EchangeurDeVue.supprimerCache(1);
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
