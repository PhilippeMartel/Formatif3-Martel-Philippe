package lireEtudiant.tests;

import lireEtudiant.Etudiant;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class EtudiantTest {

    @Test
    void compareTo() {
        Etudiant etudiant1 = new Etudiant("1234567", "Alice", "Dupont", 85.0);
        Etudiant etudiant2 = new Etudiant("2345678", "Bob", "Martin", 90.0);
        Etudiant etudiant3 = new Etudiant("3456789", "Alice", "Durand", 78.0);

        // Alice < Bob (ordre alphabétique)
        assertTrue(etudiant1.compareTo(etudiant2) < 0);

        // Bob > Alice
        assertTrue(etudiant2.compareTo(etudiant1) > 0);

        // Alice Dupont > Alice Durand (comparaison sur le nom)
        assertTrue(etudiant1.compareTo(etudiant3) < 0);
    }

    @Test
    void testEquals() {
        Etudiant etudiant1 = new Etudiant("1234567", "Alice", "Dupont", 85.0);
        Etudiant etudiant2 = new Etudiant("1234567", "Alice", "Dupont", 85.0);
        Etudiant etudiant3 = new Etudiant("2345678", "Bob", "Martin", 90.0);

        // Deux étudiants avec le même matricule sont égaux
        assertEquals(etudiant1, etudiant2);

        // Deux étudiants avec des matricules différents ne sont pas égaux
        assertNotEquals(etudiant1, etudiant3);

        // Comparaison avec null
        assertNotEquals(etudiant1, null);

        // Comparaison avec un autre type d'objet
        assertNotEquals(etudiant1, "Un texte");
    }
}
