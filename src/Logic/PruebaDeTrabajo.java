package Logic;

import Body.Body;

public class PruebaDeTrabajo {
	
	private int dificultad;
	private Bloque bloque;
	private int nonce;
		
	/**
	 * Constructor
	 */
	public PruebaDeTrabajo(int dificultad, Body body) {
		this.dificultad = dificultad;
		this.nonce = 0;
		
	}
	
	public int getDificultad() {
		return dificultad;
	}
	public void setDificultad(int dificultad) {
		this.dificultad = dificultad;
	}
	public Bloque getBloque() {
		return bloque;
	}
	public void setBloque(Bloque bloque) {
		this.bloque = bloque;
	}
	public int getNonce() {
		return nonce;
	}
	public void setNonce(int nonce) {
		this.nonce = nonce;
	}
	
	
}
