package Test;

import java.util.Scanner;

public class Prueba {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Por favor introduzca una cadena por teclado:");
		String entradaTeclado = "";

		Scanner entradaEscaner = new Scanner(System.in);

		entradaTeclado = entradaEscaner.nextLine();

		System.out.println("Entrada recibida por teclado es: \"" + entradaTeclado + "\"");

		int x = entradaTeclado.length();
		boolean empiezaConA = entradaTeclado.substring(0).startsWith("a")
				|| entradaTeclado.substring(0).startsWith("A");

		if (x < 5) {
			System.out.println("La cadena introducida tiene menos de 5 caracteres");

		} else if (5 <= x && x <= 15) {
			System.out.println("La cadena introducida tiene entre 5 y 15 caracteres");

		} else if (x > 15) {
			System.out.println("La cadena introducida tiene más de 15 caracteres");
		}
		mostrarSiEmpiezaConA(empiezaConA);
	}

	public static void mostrarSiEmpiezaConA(boolean empiezaConA) {
		if (empiezaConA) {
			System.out.println("Además comienza por la letra A");
		} else {
			System.out.println("Y no comienza por la letra A");
		}
	}

}
