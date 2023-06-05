/*
 * PlateauDeJeu.java                                      30 mai 2023
 * IUT Rodez, info1 2022-2023, pas de copyright ni "copyleft" 
 */
package principal.modele;

import java.util.Stack;

import javafx.scene.paint.Paint;

/** 
 * TODO comment class responsibility (SRP)
 * @author groupe 32
 */
public class Plateau {
    
    /* taille de la matrice qui représente le plateau de jeu */
    private final int TAILLE = 8;
    
    /* Matrice qui représente le plateau de jeu */
    private Jeton[][] matrice;
    
    /** 
     * Constructeur du plateau de jeu, une matrice de 8 cases par 8 cases, 
     * chacune contenant un jeton.
     */
    public Plateau () {
        this.matrice = new Jeton[TAILLE][TAILLE];
        for (int x = 0; x < TAILLE; x++) {
            for (int y = 0; y < TAILLE; y++) {
                this.matrice[x][y] = new Jeton();
            }
        }
    }
    
    /**
     * Permet de rendre visible un jeton dans une case précise du plateau.
     * @param x les coordonnées en x du jeton
     * @param y les coordonnées en y du jeton
     * @param couleur la couleur que doit prendre ce jeton
     */
    public void jetonExiste(int x, int y, Paint couleur) {
        this.matrice[x][y].devientAfficher();
        if (couleur.equals(Paint.valueOf(Modele.getPalette().getCouleurJ1()))) {
            this.matrice[x][y].setCouleurJ1(true);
        }
    }
    
    /* méthode permettant de s'assurer qu'une coordonnée est valide, 
     * c'est-à-dire que ses valeurs en x et en y sont comprises entre 0 et 7 */
    private boolean isCoordValide(int[] coord) {
        return coord[0] >= 0 && coord[0] < TAILLE &&
               coord[1] >= 0 && coord[1] < TAILLE;
    }
    
    /** 
     * 
     * 
     * @return TODO
     */
    public int[][] chercherPlacementsPossible() {
        Stack<int[]> coordsPossible = new Stack<int[]>();
        Stack<int[]> coords = new Stack<int[]>();
        for (int x = 0; x < TAILLE; x++) {
            for (int y = 0; y < TAILLE; y++) {
                if (Modele.getPalette().getCouleurActive().equals(
                        Modele.getPalette().getCouleurJ1())) {
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
                            if (Modele.getPalette().getCouleurActive().equals(
                                Modele.getPalette().getCouleurJ2()) &&
                                couleurRecherche) {
                                coordsPossible.push(trouveFinLigneRecursif(newCoord, 
                                                     offSet, couleurRecherche));
                                if (coordsPossible.peek()[0] == -1) {
                                    coordsPossible.pop();
                                }
                            } else if (Modele.getPalette().getCouleurActive().equals(
                                       Modele.getPalette().getCouleurJ1()) &&
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
     * @param retourneModel 
     * @return TODO : modifier
     */
    public int[][] retournerJetons(int abscisse, int ordonnee) {
        Stack<int[]> coordsATourner = new Stack<int[]>();
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
                        if (Modele.getPalette().getCouleurActive().equals(
                            Modele.getPalette().getCouleurJ2()) &&
                            couleurRecherche) {
                            coordsATourner.addAll((jetonsSurCheminRecursif(newCoord,
                                                offSet, couleurRecherche)));
                            if (coordsATourner.peek()[0] == -1) {
                                coordsATourner.pop();
                            }
                        } else if (Modele.getPalette().getCouleurActive().equals(
                                    Modele.getPalette().getCouleurJ1()) &&
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
        }
        return resultat;
    }
    
    /** TODO comment method role
     * @return
     */
    private Stack<int[]> jetonsSurCheminRecursif(int[] coord, int[] offSet, boolean couleurCherche) {
        int[] newCoord = {coord[0] + offSet[0], coord[1] + offSet[1]};
        int[] errCoord = {-1};

        Stack<int[]> chemain = new Stack<int[]>();
        Stack<int[]> chemainErr = new Stack<int[]>();
        chemainErr.add(errCoord);
        if (!isCoordValide(newCoord) || 
            !matrice[newCoord[0]][newCoord[1]].isAfficher()) {
            return chemainErr;
        } else if (matrice[newCoord[0]][newCoord[1]].isCouleurJ1() == 
                                                               couleurCherche) {
            chemain.add(coord);
            Stack<int[]> tmp = jetonsSurCheminRecursif(newCoord, offSet, couleurCherche);
            if (tmp.peek()[0] == -1) {
                return chemainErr;
            }
            chemain.addAll(tmp);
            return chemain;
            
        } else {
            chemain.add(coord);
            return chemain;
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
    
    /** TODO comment method role
     * @param aChanger
     */
    public void changeCouleurArray(int[][] aChanger) {
        for (int[] elt : aChanger) {
            matrice[elt[0]][elt[1]].switchCouleurJ1(); 
        }
    }
    
    /** TODO comment method role
     * @return TODO
     * 
     */
    public int[] ordinateurFacile() {
        int[][] possibilites = chercherPlacementsPossible();
        int[] aucunePossiblite = {-1, -1};
        int nbRandom = (int) (Math.random() * possibilites.length);
        if (possibilites.length == 0) {
            return aucunePossiblite;
        } else {
            return possibilites[nbRandom];
        }
    }
    
    /** TODO comment method role
     * @return TODO
     * 
     */
    public int[] ordinateurDifficile() {
        int[][] possibilites = chercherPlacementsPossible();
        int maxLength = 0;
        int[][] tmp;
        int[] resultat = {-1, -1};
        for (int[] elt : possibilites) {
            tmp = retournerJetons(elt[0], elt[1]);
            if (tmp.length >= maxLength) {
                resultat = elt;
                maxLength = tmp.length;
            }
        }
        return resultat;
        
        
        
    }

    /** @return valeur de matrice */
    public Jeton[][] getMatriceJeton() {
        return matrice;
    }

    /** @param matrice nouvelle valeur de matrice */
    public void setMatriceJeton(Jeton[][] matrice) {
        this.matrice = matrice;
    }
}
