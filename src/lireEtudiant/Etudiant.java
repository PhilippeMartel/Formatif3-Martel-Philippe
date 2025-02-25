/**
 * Classe Etudiant
 * Cette classe définie les attributs et les fonctions d'un Etudiant
 *
 * @author Philippe Martel
 * @version 1.1 : 2 février 2025
 */

package lireEtudiant;

import java.util.Objects;

/**
 * Représente un étudiant avec un matricule, un prénom, un nom et une moyenne.
 * Implémente {@code Comparable<lireEtudiant.Etudiant>} pour permettre le tri des étudiants.
 */
public class Etudiant implements Comparable<Etudiant> {

    // Attributs
    private String matricule;
    private String prenom;
    private String nom;
    private double moyenne;

    // Constantes de validation
    public static final double MIN_MOYENNE = 0.0;
    public static final double MAX_MOYENNE = 100.0;
    private static final int NB_CHIFFRES_MATRICULE = 7;

    /**
     * Constructeur de la classe {@code lireEtudiant.Etudiant}.
     *
     * @param matricule Le matricule de l'étudiant (doit contenir exactement 7 chiffres).
     * @param prenom    Le prénom de l'étudiant (ne peut pas être vide).
     * @param nom       Le nom de l'étudiant (ne peut pas être vide).
     * @param moyenne   La moyenne de l'étudiant (doit être comprise entre {@code MIN_MOYENNE} et {@code MAX_MOYENNE}).
     * @throws IllegalArgumentException Si l'un des paramètres est invalide.
     */
    public Etudiant(String matricule, String prenom, String nom, double moyenne) {
        setMatricule(matricule);
        setPrenom(prenom);
        setNom(nom);
        setMoyenne(moyenne);
    }

    // Accesseurs

    /**
     * Retourne le matricule de l'étudiant.
     *
     * @return Le matricule sous forme de chaîne de caractères.
     */
    public String getMatricule() {
        return matricule;
    }

    /**
     * Retourne le prénom de l'étudiant.
     *
     * @return Le prénom sous forme de chaîne de caractères.
     */
    public String getPrenom() {
        return prenom;
    }

    /**
     * Retourne le nom de l'étudiant.
     *
     * @return Le nom sous forme de chaîne de caractères.
     */
    public String getNom() {
        return nom;
    }

    /**
     * Retourne la moyenne de l'étudiant.
     *
     * @return La moyenne sous forme de double.
     */
    public double getMoyenne() {
        return moyenne;
    }

    // Mutateurs

    /**
     * Modifie le matricule de l'étudiant.
     *
     * @param matricule Le nouveau matricule (doit contenir exactement 7 chiffres).
     * @throws IllegalArgumentException Si le matricule est invalide.
     */
    public void setMatricule(String matricule) {
        if (!validerMatricule(matricule)) {
            throw new IllegalArgumentException("Matricule invalide, doit contenir exactement 7 chiffres.");
        }
        this.matricule = matricule;
    }

    /**
     * Modifie le prénom de l'étudiant.
     *
     * @param prenom Le nouveau prénom (ne peut pas être vide).
     * @throws IllegalArgumentException Si le prénom est vide.
     */
    public void setPrenom(String prenom) {
        if (prenom.isEmpty()) {
            throw new IllegalArgumentException("Le prénom ne peut pas être vide.");
        }
        this.prenom = prenom;
    }

    /**
     * Modifie le nom de l'étudiant.
     *
     * @param nom Le nouveau nom (ne peut pas être vide).
     * @throws IllegalArgumentException Si le nom est vide.
     */
    public void setNom(String nom) {
        if (nom.isEmpty()) {
            throw new IllegalArgumentException("Le nom ne peut pas être vide.");
        }
        this.nom = nom;
    }

    /**
     * Modifie la moyenne de l'étudiant.
     *
     * @param moyenne La nouvelle moyenne (doit être comprise entre {@code MIN_MOYENNE} et {@code MAX_MOYENNE}).
     * @throws IllegalArgumentException Si la moyenne est hors des limites autorisées.
     */
    public void setMoyenne(double moyenne) {
        if (!validerMoyenne(moyenne)) {
            throw new IllegalArgumentException("Moyenne invalide, doit être entre 0 et 100.");
        }
        this.moyenne = moyenne;
    }

    // Méthodes de validation

    /**
     * Vérifie si un matricule est valide (exactement 7 caractères).
     *
     * @param matricule Le matricule à valider.
     * @return {@code true} si le matricule est valide, {@code false} sinon.
     */
    public boolean validerMatricule(String matricule) {
        return matricule.length() == NB_CHIFFRES_MATRICULE;
    }

    /**
     * Vérifie si une moyenne est valide (comprise entre {@code MIN_MOYENNE} et {@code MAX_MOYENNE}).
     *
     * @param moyenne La moyenne à valider.
     * @return {@code true} si la moyenne est valide, {@code false} sinon.
     */
    public boolean validerMoyenne(double moyenne) {
        return moyenne >= MIN_MOYENNE && moyenne <= MAX_MOYENNE;
    }

    /**
     * Retourne une représentation textuelle de l'étudiant.
     *
     * @return Une chaîne contenant les informations de l'étudiant.
     */
    @Override
    public String toString() {
        return "Matricule: " + this.matricule +
                ", Prenom: " + this.prenom +
                ", Nom: " + this.nom +
                ", Moyenne: " + this.moyenne;
    }

    /**
     * Compare cet étudiant à un autre en fonction du prénom, puis du nom si les prénoms sont identiques.
     *
     * @param autre L'autre étudiant à comparer.
     * @return Un entier négatif si cet étudiant est avant {@code autre}, positif s'il est après, et 0 s'ils sont égaux.
     */
    @Override
    public int compareTo(Etudiant autre) {
        if(this.prenom != autre.getPrenom()) {
            return this.prenom.compareTo(autre.getPrenom());
        }else{
            return this.nom.compareTo(autre.getNom());
        }
    }

    /**
     * Vérifie si cet étudiant est égal à un autre objet.
     * Deux étudiants sont considérés comme égaux s'ils ont le même matricule.
     *
     * @param obj L'objet à comparer.
     * @return {@code true} si les étudiants ont le même matricule, {@code false} sinon.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        } else if (obj == null) {
            return false;
        } else if (this.getClass() != obj.getClass()){
            return false;
        }else {
            return this.getMatricule() == ((Etudiant)obj).getMatricule();
        }
    }

    /**
     * Génère un code de hachage basé sur le matricule de l'étudiant.
     *
     * @return Un entier représentant le code de hachage.
     */
    @Override
    public int hashCode() {
        return Objects.hash(matricule);
    }
}
