import java.util.Scanner;

public class Rebonds2 {

	public static void main(String[] args) {
		
		Scanner clavier = new Scanner(System.in);
		
		double g = 9.81, H0, eps, v, v1, h;
		int nbr = 0;
		
		do {
			System.out.print("Entrez la heuteur initiale H0 = ");
			H0 = clavier.nextDouble();	
		} while (H0 < 0);
		
		do {
			System.out.print("Entrez le coefficient de rebond (0 <= esp < 1) eps = ");
			eps = clavier.nextDouble();	
		} while (eps < 0 && eps >1);
		
		do {
			System.out.print("Entrez la hauteur finale désirée (0 < h < H0) h = ");
			h = clavier.nextDouble();	
		} while (h < 0 && h > H0);
		
		v = Math.sqrt(2*H0*g);
		
		do {
			v1 = eps*v;
			H0 = v1*v1/(2*g);
			v = Math.sqrt(2*H0*g);
			nbr++;
		} while (H0 > h);
		
		System.out.print("Le nombre de rebonds pour que la hauteur de la balle soit inférieure ou égale à " + h + " est " + nbr);
		
		clavier.close();

	}

}
