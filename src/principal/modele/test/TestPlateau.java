/*
 * TestJoueur.java                                      2 juin 2023
 * IUT Rodez, info1 2022-2023, pas de copyright ni "copyleft" 
 */
package principal.modele.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import principal.modele.Joueur;
import principal.modele.Plateau;
import principal.modele.Theme;

class TestPlateau {

	Plateau plateauTest = new Plateau(new Theme("#FFFFFF", "#000000"));

	int[] coordonneTest = {0,0} ;

	@Test
	void testPlateau() {
		assertDoesNotThrow(() -> new Theme("#FFFFFF", "#000000"));
	}

	@Test
	void testJetonExiste() {
		fail("Not yet implemented");
	}

	@Test
	void testChercherPlacementsPossible() {
		fail("Not yet implemented");
	}

	@Test
	void testRetournerJetons() {
		fail("Not yet implemented");
	}

	@Test
	void testTrouveJetonMatrice() {
		fail("Not yet implemented");
	}

	@Test
	void testChangeCouleur() {
		fail("Not yet implemented");
	}

	@Test
	void testIsCoordValide() {
		//assertTrue(plateauTest.isCoordValide(coordonneTest));
	}
	
}  

