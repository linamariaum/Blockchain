package Logic;

import Body.Body;
import Header.Header;

public class PruebaDeTrabajo {

	private static myHashCode myHash = new myHashCode();

	public static Bloque proofOfWork(int dificultad, Body body, String hash_prev) {
		String numCeros = "";
		if (dificultad == 0) {
			dificultad = 2;
		}
		for (int i = 0; i < dificultad; i++) {
			numCeros = numCeros + "0";
		}
		Bloque bloque = new Bloque();
		bloque.setBody(body);
		Header header = new Header();
		header.setHash_prev(hash_prev);

		Transaccion tx = body.getTx();
		String cadenaBody = tx.getRemitente() + tx.getCantidad() + tx.getDestinatario();
		cadenaBody = myHash.myHashCodeSha256(cadenaBody);

		if (cadenaBody != null) {
			header.setHash_raiz(cadenaBody);
			int nonceAux = 0;
			String nonce = String.valueOf(nonceAux);
			String nuevoHash = myHash.myHashCodeSha256(hash_prev + cadenaBody + nonce);
			while (!verificarDificultad(nuevoHash, numCeros)) {
				nonceAux = (int) (Math.random() * 922337203 + 1);
				// nonceAux =
				// Math.floor(Math.random()*(1-9223372036854775807+1)+9223372036854775807);
				nonce = String.valueOf(nonceAux);
				nuevoHash = myHash.myHashCodeSha256(cadenaBody + nonce);
				System.out.println(nuevoHash);
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			header.setNonce(nonce);
			header.setHash_propio(nuevoHash);
			bloque.setHeader(header);
		}
		return bloque;
	}

	private static boolean verificarDificultad(String nuevoHash, String numCeros) {
		return nuevoHash.substring(0).startsWith(numCeros);
	}

}
