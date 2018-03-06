import java.util.Scanner;

public class Rebonds2 {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		//Constante de gravité
		final double G = 9.81;
		// Déclarations
		// vitesses avant et après le rebond
		double v = 0.0;
		double v1 = 0.0;
		// hauteur avant le rebond, hauteur de remontée
		double h = 0.0;
		double h1 = 0.0;
		double h0 = 0.0;
		double eps = 0.0;
		double h_fin = 0.0;
		
		/*
		 * Entrée des valeurs par l'utilisateur,
		 * avec test de validité
		 */
		do {
			System.out.print("Coefficient de rebond (0 <= coeff < 1) : ");
			eps = scanner.nextDouble();
		} while ((eps < 0.0) || (eps >= 1.0));
		do {
			System.out.print("Hauteur initiale (0 <= H0) : ");
			h0 = scanner.nextDouble();
		} while (h0 < 0.0);
		do {
			System.out.println("Hauteur finale (0 <= h_fin ) : ");
			h_fin = scanner.nextDouble();
		} while (h_fin < 0.0 || h_fin > h0);
		
		// Boucle de calcul
		h = h0;
		int count = 0;
		do {
			v = Math.sqrt(2.0 * G * h);
			// vitesse après le rebond
			v1 = eps * v;
			// incrémente le nombre de rebonds
			count++;
			// la hauteur à laquelle elle remonte...
			h1 = (v1 * v1) / (2.0 * G);
			// ...qui devient la nouvelle hauteur initiale
			h = h1;
			System.out.println("rebond " + count + " : " + h );
		} while (h1 > h_fin);
		
		// Affichage du résultat
		System.out.print("Le nombre de rebonds pour que la hauteur de la balle soit inférieure ou égale à " + h + " est " + count);

		scanner.close();

	}

}
