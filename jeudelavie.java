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

            if (ligne == -1 && colonne == -1) break;

            if (ligne >= 0 && ligne < lignes && colonne >= 0 && colonne < colonnes) {
                grille[ligne][colonne] = true;
            } else {
                System.out.println("Coordonnées invalides, réessayez !");
            }
        }
        // Demande du nombre d'itérations
        System.out.print("Entrez le nombre de generation : ");
        int iterations = sc.nextInt();

        // Boucle pour faire évoluer la grille
        for (int generation = 0; generation < iterations; generation++) {
            System.out.println("Génération " + (generation + 1) + ":");

            // Afficher la grille
            for (int i = 0; i < lignes; i++) {
                for (int j = 0; j < colonnes; j++) {
                    System.out.print(grille[i][j] ? "1 " : "0 ");
                }
                System.out.println();
            }
            System.out.println();
        }
        // Calculer la prochaine génération
        for (int i = 0; i < lignes; i++) {
            for (int j = 0; j < colonnes; j++) {
                int voisinsVivants = 0;

                // Compter les voisins vivants
                for (int di = -1; di <= 1; di++) {
                    for (int dj = -1; dj <= 1; dj++) {
                        if (di == 0 && dj == 0) continue;
                        int voisinX = i + di;
                        int voisinY = j + dj;

                        if (voisinX >= 0 && voisinX < lignes && voisinY >= 0 && voisinY < colonnes && grille[voisinX][voisinY]) {
                            voisinsVivants++;
                        }
                    }
                }

                // Appliquer les règles
                if (grille[i][j]) {
                    nouvelleGrille[i][j] = (voisinsVivants == 2 || voisinsVivants == 3);
                } else {
                    nouvelleGrille[i][j] = (voisinsVivants == 3);
                }
            }
        }

    }
}