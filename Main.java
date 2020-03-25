package Examen;
import java.sql.SQLException;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {

		Conector instancia = Conector.getInstancia();
		
		// Ejecercio 1
		System.out.println("EJERCICIO 1");
		System.out.println("Mostrar los nombres del artistas por orden de popularidad de menor a mayor");
		System.out.println("Artis  Reproducciones");
		try {
			ArrayList<String> listPopularidad = instancia.getPopularidad();
			for (String Ejercicio1 : listPopularidad) {
				System.out.println(Ejercicio1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println();
		// Ejercicio 2
				System.out.println("EJERCICIO 2");
				System.out.println(" Mostrar el nombre del album de las canciones que terminen con 'y'";
				System.out.println("Song         Album");
				try {
					ArrayList<String> listCanciones = instancia.getCanciones();
					for (String Ejercicio1 : listCanciones) {
						System.out.println(Ejercicio1);
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
				System.out.println();
		
		}

	}

}
