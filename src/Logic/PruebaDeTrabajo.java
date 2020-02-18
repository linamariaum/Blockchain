package Logic;

public class PruebaDeTrabajo {

	private int dificultad;
	private Bloque bloque;
	private String nonce;
	private String nuevoHash;
	private myHashCode myHash = new myHashCode();
	
	
	public Bloque proofOfWork(int dificultad, Bloque bloque) {
		this.dificultad = dificultad;
		this.bloque = bloque;
		Transaccion tx = this.bloque.getBody().getTx();
		String cadenaBody = tx.getRemitente() + tx.getCantidad() + tx.getDestinatario();
		cadenaBody = myHash.myHashCodeSha256(cadenaBody);
		if (cadenaBody != null) {
			int nonceAux = 0;
			this.nonce = String.valueOf(nonceAux);
			this.nuevoHash = cadenaBody + this.nonce;
			verificarDificultad(this.nuevoHash);
		}
		return bloque;
	}


	private void verificarDificultad(String nuevoHash) {
		
		// TODO Auto-generated method stub
		// VALIDAR QUE TENGA EL NUMERO CORRECTO DE CEROS
		
	}
	
	

	
}
