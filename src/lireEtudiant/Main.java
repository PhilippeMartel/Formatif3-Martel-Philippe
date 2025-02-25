package lireEtudiant;

public class Main {
    public static void main(String[] args) {
        // Instanciation d'une liste d'étudiants
        ListeEtudiants listeEtudiants = new ListeEtudiants();

        // Lecture des étudiants contenu dans le fichier etudiants.csv
        listeEtudiants.lireEtudiants();

        listeEtudiants.trier();

        listeEtudiants.ecrireEtudiants();

        // Impression en console de la liste d'étudiants
        System.out.println(listeEtudiants);
    }
}