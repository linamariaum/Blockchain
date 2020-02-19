package Test;

import java.util.ArrayList;
import java.util.Scanner;

import Body.Body;
import Logic.Blockchain;
import Logic.Bloque;
import Logic.PruebaDeTrabajo;
import Logic.Transaccion;

public class Prueba {
	private boolean continuar = true;
	private static ArrayList<Bloque> red = new ArrayList<Bloque>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Bienvenido!");

		while (true) {
			int dificultad = solicitarDificultad();
			Transaccion tx = solicitarTransaccion();
			Body body = new Body();
			body.setTx(tx);
			String prevHash = "";
			if (red.size() == 0) {
				prevHash = "0";
			} else {
				Bloque lastBlock = red.get(red.size() - 1);
				prevHash = lastBlock.getHeader().getHash_propio();
			}
			Bloque nuevo = PruebaDeTrabajo.proofOfWork(dificultad, body, prevHash);
			System.out.println(nuevo.getBody().getTx().getRemitente());
			red.add(nuevo);

		}
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

	public static int solicitarDificultad() {
		System.out.println("Por favor introduzca la dificultad: ");
		String dif = "";
		Scanner escanerDificultad = new Scanner(System.in);
		dif = escanerDificultad.nextLine();
		return Integer.parseInt(dif);
	}

}
