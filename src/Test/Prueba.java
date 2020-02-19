package Test;

import java.util.Scanner;

import Body.Body;
import Logic.Transaccion;

public class Prueba {
	private boolean continuar = true;
	private static Transaccion tx;
	private int dificultad = 2;
	private Body body;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Bienvenido!");
		tx = solicitarTransaccion();
		solicitarDificultad();

	}

	public static Transaccion solicitarTransaccion() {
		System.out.println("Por favor introduzca la transaccion");

		System.out.println("Remitente:");
		String txRemitente = "";
		Scanner escanerRemitente = new Scanner(System.in);
		txRemitente = escanerRemitente.nextLine();

		System.out.println("Cantidad:");
		String txCantidad = "";
		Scanner escanerCantidad = new Scanner(System.in);
		txCantidad = escanerCantidad.nextLine();

		System.out.println("Destinatario:");
		String txDestinatario = "";
		Scanner escanerDestinatario = new Scanner(System.in);
		txDestinatario = escanerDestinatario.nextLine();

		// System.out.println("Entrada recibida para la Transaccion es: \"" +
		// txRemitente + txCantidad + txDestinatario + "\"");
		
		Transaccion trans = new Transaccion();
		trans.setRemitente(txRemitente);
		trans.setCantidad(txCantidad);
		trans.setDestinatario(txDestinatario);
		
		return trans;

	}

	public static void solicitarDificultad() {
		System.out.println("Por favor introduzca la dificultad: ");
		String dif = "";
		Scanner escanerDificultad = new Scanner(System.in);
		dif = escanerDificultad.nextLine();
		// string to int
		//this.dificultad = 

	}

}
