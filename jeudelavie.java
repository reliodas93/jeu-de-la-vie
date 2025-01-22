import java.util.Scanner;

public class jeudelavie {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Initialisation de la grille
        System.out.print("Entrez le nombre de lignes : ");
        int lignes = sc.nextInt();
        System.out.print("Entrez le nombre de colonnes : ");
        int colonnes = sc.nextInt();

        boolean[][] grille = new boolean[lignes][colonnes];
        boolean[][] nouvelleGrille = new boolean[lignes][colonnes];

        // Initialisation des cellules vivantes
        System.out.println("Entrez les coordonnées des cellules vivantes (ligne colonne). Entrez -1 -1 pour terminer :");
        while (true) {
            System.out.print("Ligne : ");
            int ligne = sc.nextInt();
            System.out.print("Colonne : ");
            int colonne = sc.nextInt();

            if (ligne == -1 && colonne == -1) break; // Terminer l'initialisation

            if (ligne >= 0 && ligne < lignes && colonne >= 0 && colonne < colonnes) {
                grille[ligne][colonne] = true;
            } else {
                System.out.println("Coordonnées invalides, réessayez !");
            }
        }
    }
}
