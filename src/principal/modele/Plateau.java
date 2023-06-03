/*
 * PlateauDeJeu.java                                      30 mai 2023
 * IUT Rodez, info1 2022-2023, pas de copyright ni "copyleft" 
 */
package principal.modele;

import java.util.Stack;

import javafx.scene.paint.Paint;

/** TODO comment class responsibility (SRP)
 * @author groupe 32
 *
 */
public class Plateau {
    
    private Theme couleurs;
    
    /* taille de la matrice qui représente le plateau de jeu */
    private final int TAILLE = 8;
    
    /* Matrice qui représente le plateau de jeu */
    private Jeton[][] matrice;
    
    /** TODO comment intial state
     * @param couleurs 
     * 
     */
    public Plateau (Theme couleurs) {
        this.couleurs = couleurs;
        this.matrice = new Jeton[TAILLE][TAILLE];
        for (int x = 0; x < TAILLE; x++) {
            for (int y = 0; y < TAILLE; y++) {
                this.matrice[x][y] = new Jeton();
            }
        }
    }
    
    /** TODO comment method role
     * @param x 
     * @param y 
     * @param couleur 
     */
    public void jetonExiste(int x, int y, Paint couleur) {
        this.matrice[x][y].devientAfficher();
        if (couleur.equals(Paint.valueOf(couleurs.getCouleurJ1()))) {
            this.matrice[x][y].setCouleurJ1(true);
        }
    }
    
    private boolean isCoordValide(int[] coord) {
        return coord[0] >= 0 && coord[0] < TAILLE &&
               coord[1] >= 0 && coord[1] < TAILLE;
    }
    
    /** TODO comment method role
     * @return TODO
     */
    public int[][] chercherPlacementsPossible() {
        Stack<int[]> coordsPossible = new Stack();
        Stack<int[]> coords = new Stack();
        for (int x = 0; x < TAILLE; x++) {
            for (int y = 0; y < TAILLE; y++) {
                if (couleurs.getCouleurActive().equals(
                        couleurs.getCouleurJ1())) {
                    if (matrice[x][y].isAfficher() && 
                        matrice[x][y].isCouleurJ1()) {
                        int [] coord = {x, y};
                        coords.push(coord);
                    }
                } else {
                    if (matrice[x][y].isAfficher() &&
                        !matrice[x][y].isCouleurJ1()) {
                        int [] coord = {x, y};
                        coords.push(coord);
                    }
                }
                
            }
        }
        while (!coords.isEmpty()) {
            int[] coord =  coords.pop();
            for (int x = -1; x <= 1; x++) {
                for (int y = -1; y <= 1; y++) {
                    if (!(x == 0 && y == 0)) { 
                        int[] newCoord = {coord[0] + x, coord[1] + y};
                        if (isCoordValide(newCoord) && 
                            matrice[newCoord[0]][newCoord[1]].isAfficher()) {
                            int[] offSet = {x, y};
                            boolean couleurRecherche = 
                                matrice[newCoord[0]][newCoord[1]].isCouleurJ1();
                            if (couleurs.getCouleurActive().equals(
                                couleurs.getCouleurJ2()) &&
                                couleurRecherche) {
                                coordsPossible.push(trouveFinLigneRecursif(newCoord, 
                                                     offSet, couleurRecherche));
                                if (coordsPossible.peek()[0] == -1) {
                                    coordsPossible.pop();
                                }
                            } else if (couleurs.getCouleurActive().equals(
                                       couleurs.getCouleurJ1()) &&
                                       !couleurRecherche){
                                coordsPossible.push(trouveFinLigneRecursif(newCoord, 
                                        offSet, couleurRecherche));
                                if (coordsPossible.peek()[0] == -1) {
                                    coordsPossible.pop();
                                }
                                
                            }
                        }
                    }
                }
            }
        }
        int[][] resultat = new int[coordsPossible.size()][2];
        int i = 0;
        while (!coordsPossible.isEmpty()) {
            resultat[i] = coordsPossible.pop();
            i++;
        }
        return resultat;
    }
    
    /** TODO comment method role
     * @return
     */
    private int[] trouveFinLigneRecursif(int[] coord, int[] offSet, boolean couleurCherche) { //TODO : changer nom
        int[] newCoord = {coord[0] + offSet[0], coord[1] + offSet[1]};
        if (!isCoordValide(newCoord)) {
            newCoord[0] = -1;
            newCoord[1] = -1;
            return newCoord;
        } else if (!matrice[newCoord[0]][newCoord[1]].isAfficher()) {
            return newCoord;
        } else if (matrice[newCoord[0]][newCoord[1]].isCouleurJ1() != 
                                                               couleurCherche) {
            newCoord[0] = -1;
            newCoord[1] = -1;
            return newCoord;
        } else {
            return trouveFinLigneRecursif(newCoord, offSet, couleurCherche);
        }
    }
    
    /** TODO comment method role
     * @param abscisse
     * @param ordonnee
     * @return TODO : modifier
     */
    public int[][] retournerJetons(int abscisse, int ordonnee) {
        Stack<int[]> coordsATourner = new Stack();
        int[] coord = {abscisse, ordonnee};
        for (int x = -1; x <= 1; x++) {
            for (int y = -1; y <= 1; y++) {
                if (!(x == 0 && y == 0)) { 
                    int[] newCoord = {coord[0] + x, coord[1] + y};
                    if (isCoordValide(newCoord) && 
                        matrice[newCoord[0]][newCoord[1]].isAfficher()) {
                        int[] offSet = {x, y};
                        boolean couleurRecherche = 
                            matrice[newCoord[0]][newCoord[1]].isCouleurJ1();
                        if (couleurs.getCouleurActive().equals(
                            couleurs.getCouleurJ2()) &&
                            couleurRecherche) {
                            coordsATourner.addAll((jetonsSurCheminRecursif(newCoord,
                                                offSet, couleurRecherche)));
                            if (coordsATourner.peek()[0] == -1) {
                                coordsATourner.pop();
                            }
                        } else if (couleurs.getCouleurActive().equals(
                                    couleurs.getCouleurJ1()) &&
                                    !couleurRecherche){
                            coordsATourner.addAll(jetonsSurCheminRecursif(newCoord,
                                        offSet, couleurRecherche));
                            if (coordsATourner.peek()[0] == -1) {
                                coordsATourner.pop();
                            }   
                        }
                    }
                }
            }
        }
        int[][] resultat = new int[coordsATourner.size()][2];
        for (int i = 0; i < resultat.length; i++) {
            resultat[i] = coordsATourner.pop();
            changeCouleur(resultat[i][0], resultat[i][1]);
        }
        return resultat;
    }
    
    /** TODO comment method role
     * @return
     */
    private Stack<int[]> jetonsSurCheminRecursif(int[] coord, int[] offSet, boolean couleurCherche) {
        int[] newCoord = {coord[0] + offSet[0], coord[1] + offSet[1]};
        int[] errCoord = {-1};
        Stack<int[]> chemin = new Stack();
        Stack<int[]> cheminErr = new Stack();
        cheminErr.add(errCoord);
        if (!isCoordValide(newCoord) || 
            !matrice[newCoord[0]][newCoord[1]].isAfficher()) {
            return cheminErr;
        } else if (matrice[newCoord[0]][newCoord[1]].isCouleurJ1() == 
                                                               couleurCherche) {
            chemin.add(coord);
            Stack<int[]> tmp = jetonsSurCheminRecursif(newCoord, offSet, couleurCherche);
            if (tmp.peek()[0] == -1) {
                return cheminErr;
            }
            chemin.addAll(tmp);
            return chemin;
            
        } else {
            chemin.add(coord);
            return chemin;
        }
    }

    /** TODO comment method role
     * @param rechercher 
     * @return les coordonees [x, y] du jeton chercher si il est trouvé, sinon
     * [-1, -1]
     */
    public int[] trouveJetonMatrice(Jeton rechercher) {
        int[] resultat = {-1, -1};
        for (int x= 0; x < matrice.length; x++) {
            for (int y = 0; y < matrice[x].length; y++) {
                if (matrice[x][y].equals(rechercher)) {
                    resultat[0] = x;
                    resultat[1] = y;
                }
            }
        }
        return resultat;
    }
    
    void changeCouleur(int x, int y) {
        matrice[x][y].switchCouleurJ1();
    }

}
