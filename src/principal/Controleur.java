/*
 * Controleur.java                                      26 2023
 * IUT Rodez, info1 2022-2023, pas de copyright ni "copyleft" 
 */
package principal;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.HPos;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Circle;

/**
 * TODO comment class responsibility (SRP)
 * 
 * @author jodie.monterde
 *
 */
public class Controleur {
    @FXML
    private TextField nomJ1;

    @FXML
    private TextField scoreJ1;

    @FXML
    private TextField nomJ2;

    @FXML
    private TextField scoreJ2;

    @FXML
    private Button menu;

    @FXML
    private GridPane grille;

    @FXML
    private Button passerTour;

    @FXML
    private Circle couleurJoueurActif;
    
    @FXML
    void testing(ActionEvent event) {
        Circle test = new Circle(0,0,18);
        GridPane.setHalignment(test, HPos.CENTER);
        grille.add(test, 3, 4);     
    }
    
    @FXML
    void testing2(ActionEvent event) {
        System.out.println(event.getSource().toString());
    }
}