/*
 * Controleur.java                                      26 2023
 * IUT Rodez, info1 2022-2023, pas de copyright ni "copyleft" 
 */
package principal;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.HPos;
import javafx.scene.Node;
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
    }
    
    @FXML
    void nodePressed(ActionEvent event) {
        Button btn = (Button) event.getSource();
        btn.setDisable(true);
        Integer x = GridPane.getColumnIndex((Node) event.getSource());
        x = x == null ? 0 : x;
        Integer y = GridPane.getRowIndex((Node) event.getSource());
        y = y == null ? 0 : y;
        System.out.println("new circle at : [x=" + x + "; y=" + y + "]");
        Circle cercle = new Circle(0,0,18);
        GridPane.setHalignment(cercle, HPos.CENTER);
        grille.add(cercle, x, y); 
    }
}