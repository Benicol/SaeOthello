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
    
    private SetCouleur couleurs;
    
    /* taille de la matrice qui représente le plateau de jeu */
    private final int TAILLE = 8;
    
    /* Matrice qui représente le plateau de jeu */
    private Jeton[][] matrice;
    
    /** TODO comment intial state
     * @param couleurs 
     * 
     */
    public Plateau (SetCouleur couleurs) {
        this.couleurs = couleurs;
        this.matrice = new Jeton[TAILLE][TAILLE];
        for (int x = 0; x < 8; x++) {
            for (int y = 0; y < 8; y++) {
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
    
    /** TODO comment method role
     */
    public void test() {
        
        System.out.println("couleur active : " + couleurs.getCouleurActive());
        System.out.println("couleur J1 : " + couleurs.getCouleurJ1());
        System.out.println("couleur J2 : " + couleurs.getCouleurJ2());
        Stack<int[]> coordsPossible = new Stack();
        Stack<int[]> coords = new Stack();
        for (int x = 0; x < 8; x++) {
            for (int y = 0; y < 8; y++) {
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
                        System.out.print(coord[0] + "/" + coord[1] + "{" + x + ", " + y + "} => " + newCoord[0] + " / " + newCoord[1] + " => ");
                        if (isCoordValide(newCoord) && 
                            matrice[newCoord[0]][newCoord[1]].isAfficher()) {
                            int[] offSet = {x, y};
                            boolean couleurRecherche = 
                                matrice[newCoord[0]][newCoord[1]].isCouleurJ1();
                            if (couleurs.getCouleurActive().equals(
                                couleurs.getCouleurJ2()) &&
                                couleurRecherche) {
                                coordsPossible.push(tmpName(newCoord, 
                                                     offSet, couleurRecherche));
                                System.out.print(coordsPossible.peek()[0] + " / " + coordsPossible.peek()[1]);
                                if (coordsPossible.peek()[0] == -1) {
                                    coordsPossible.pop();
                                }
                            } else if (couleurs.getCouleurActive().equals(
                                       couleurs.getCouleurJ1()) &&
                                       !couleurRecherche){
                                coordsPossible.push(tmpName(newCoord, 
                                        offSet, couleurRecherche));
                                System.out.print(coordsPossible.peek()[0] + " / " + coordsPossible.peek()[1]);
                                if (coordsPossible.peek()[0] == -1) {
                                    coordsPossible.pop();
                                }
                                
                            }
                        }
                    }
                    System.out.println();
                }
            }
        }
        int[] tmp;
        System.out.println("RESULTAT : ");
        while (!coordsPossible.isEmpty()) {
            tmp = coordsPossible.pop();
            System.out.print(tmp[0] + " / " + tmp[1] + " - ");
        }
    }
    
    /** TODO comment method role
     * @return
     */
    private int[] tmpName(int[] coord, int[] offSet, boolean couleurCherche) {
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
            return tmpName(newCoord, offSet, couleurCherche);
        }
    }
    
    /** TODO comment method role
     * @return
     */
    private Stack<int[]> tmpName2(int[] coord, int[] offSet, boolean couleurCherche) {
        int[] newCoord = {coord[0] + offSet[0], coord[1] + offSet[1]};
        int[] errCoord = {-1};
        Stack<int[]> chemain = new Stack();
        Stack<int[]> chemainErr = new Stack();
        chemainErr.add(errCoord);
        if (!isCoordValide(newCoord) || 
            !matrice[newCoord[0]][newCoord[1]].isAfficher()) {
            return chemainErr;
        } else if (matrice[newCoord[0]][newCoord[1]].isCouleurJ1() == 
                                                               couleurCherche) {
            chemain.add(coord);
            Stack<int[]> tmp = tmpName2(newCoord, offSet, couleurCherche);
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
    
    private static boolean isCoordValide(int[] coord) {
        return coord[0] >= 0 && coord[0] <= 7 && coord[1] >= 0 && coord[1] <= 7;
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
                    System.out.print(coord[0] + "/" + coord[1] + "{" + x + ", " + y + "} => " + newCoord[0] + " / " + newCoord[1] + " => ");
                    if (isCoordValide(newCoord) && 
                        matrice[newCoord[0]][newCoord[1]].isAfficher()) {
                        System.out.print("le sommet existe.... (" + couleurs.getCouleurActive() + ", " + couleurs.getCouleurJ1() + ", " + couleurs.getCouleurJ2() + ")");
                        int[] offSet = {x, y};
                        boolean couleurRecherche = 
                            matrice[newCoord[0]][newCoord[1]].isCouleurJ1();
                        System.out.print("(" + couleurRecherche + ") ");
                        if (couleurs.getCouleurActive().equals(
                            couleurs.getCouleurJ2()) &&
                            couleurRecherche) {
                            System.out.print("1chercher sommets....");
                            coordsATourner.addAll((tmpName2(newCoord,
                                                offSet, couleurRecherche)));
                            if (coordsATourner.peek()[0] == -1) {
                                coordsATourner.pop();
                            }
                        } else if (couleurs.getCouleurActive().equals(
                                    couleurs.getCouleurJ1()) &&
                                    !couleurRecherche){
                            System.out.print("2chercher sommets....");
                            coordsATourner.addAll(tmpName2(newCoord,
                                        offSet, couleurRecherche));
                            if (coordsATourner.peek()[0] == -1) {
                                coordsATourner.pop();
                            }   
                        }
                    }
                }
                System.out.println();
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
