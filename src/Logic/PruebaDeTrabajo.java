package Logic;

import Body.Body;
import Header.Header;

public class PruebaDeTrabajo {

	private Bloque bloque;
	private String nonce;
	private String numCeros;
	private String nuevoHash;
	private myHashCode myHash = new myHashCode();	
	
	public Bloque proofOfWork(int dificultad, Body body, String hash_prev) {		
		this.numCeros = "";
		if (dificultad == 0) {
			dificultad = 2;
		}
		for (int i=0; i < dificultad; i++) {
			this.numCeros = this.numCeros+"0";
		}
		this.bloque = new Bloque();
		this.bloque.setBody(body);
		Header header = new Header();
		header.setHash_prev(hash_prev);
				
		Transaccion tx = body.getTx();
		String cadenaBody = tx.getRemitente() + tx.getCantidad() + tx.getDestinatario();		
		cadenaBody = myHash.myHashCodeSha256(cadenaBody);
		
		if (cadenaBody != null) {
			header.setHash_raiz(cadenaBody);
			int nonceAux = 0;
			this.nonce = String.valueOf(nonceAux);
			this.nuevoHash = myHash.myHashCodeSha256(hash_prev + cadenaBody + this.nonce);
			while(!verificarDificultad(this.nuevoHash, this.numCeros)) {
				nonceAux = (int)(Math.random()*922337203+1);
				//nonceAux = Math.floor(Math.random()*(1-9223372036854775807+1)+9223372036854775807);
				this.nonce = String.valueOf(nonceAux);
				this.nuevoHash = myHash.myHashCodeSha256(cadenaBody + this.nonce);				
			}
			header.setNonce(this.nonce);
			header.setHash_propio(this.nuevoHash);
			this.bloque.setHeader(header);			
		}
		return bloque;
	}

	private boolean verificarDificultad(String nuevoHash, String numCeros) {
		return nuevoHash.substring(0).startsWith(numCeros);
	}
	
}
