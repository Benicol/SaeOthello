/*
 * EchangeurDeVue.java                                     26/05/2023
 * IUT Rodez, info1 2022-2023, pas de copyright ni "copyleft"
 */
package principal;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;

/**
 * Classe outil permettant de gérer le changement de la vue affichée par la
 * scene de l'application. 
 * @author groupe 32
 */
public class EchangeurDeVue {

    /**
     * Table de hachage
     */
    private static Map<Integer, Parent> cache;
    
    // création de la table cache
    static {
        cache = new HashMap<>();
    }

    /** Scene courante, ou scène qui est associée à la fenêtre principale */
    private static Scene sceneCourante;
    
    private static Stage primaryStage;

    /**
     * Affecte à la sceneCourante la scène créée dans la méthode start, donc celle
     * associée à la fenêtre principale
     * @param nouvelleScene Scene à affecter
     */
    public static void setSceneCourante(Scene nouvelleScene) {
        sceneCourante = nouvelleScene;
    }
    
    /**
     * Affecte à la sceneCourante la scène créée dans la méthode start, donc celle
     * associée à la fenêtre principale
     * @param stage 
     */
    public static void setStage(Stage stage) {
        primaryStage = stage;
    }
    
    /**
     * Modifie la vue associée à la scène courante, pour qu'elle devienne celle dont
     * le code est donné en argument La scène courante doit avoir été initialisée
     * 
     * @param codeVue code de la vue à placer sur la scène courante
     * @param garderEnMemoire TODO
     */
    public static void echangerAvec(int codeVue, boolean garderEnMemoire) {
        if (sceneCourante == null) {

            // pas de scène courante : impossible de modifier sa vue
            throw new IllegalStateException("Echange de vue impossible. Pas de scène courante.");
        }

        try {
            Parent racine; // recevra le conteneur racine de la -vue à afficher
            if (cache.containsKey(codeVue)) {

                /*
                 * la vue associée au codeVue est présente dans la table cache, ce qui signifie
                 * qu'elle a déjà été chargée. Pour optimiser, on ne la recharge pas. Au
                 * contraire, on la récupère dans la table cache, à partir de sa clé (codeVue)
                 */
                racine = cache.get(codeVue);
            } else {

                /*
                 * La vue associée au codeVue n'est pas présente dans la table cache. Elle n'a
                 * donc pas encore été chargée. Il faut donc la charger et ensuite on la stocke
                 * dans la table (pour éviter de la recharger à nouveau si l'utilisateur
                 * souhaite revenir sur cette vue)
                 */
                racine = FXMLLoader.load(EchangeurDeVue.class.getResource(EnsembleDesVues.getNomVue(codeVue)));

                // ajout de la vue à la table cache
                if (garderEnMemoire) {
                    cache.put(codeVue, racine);
                }
            }
            sceneCourante.setRoot(racine);
        } catch (IOException erreur) {

            // problème lors de l'accès au fichier décrivant la vue
            System.out.println("Echec du chargement de la vue de code " + codeVue + " => " + erreur.getMessage());
        }
    }
    
    /**
     * @param codeVue code de la vue à placer sur la scène courante
     */
    public static void supprimerCache(int codeVue) {
        if (cache.containsKey(codeVue)) {
            cache.remove(codeVue);
        }
    }
}