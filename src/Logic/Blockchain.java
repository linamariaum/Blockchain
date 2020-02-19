package Logic;

import java.util.ArrayList;

public class Blockchain {
	
	ArrayList<Bloque> red = new ArrayList<Bloque>();

	public ArrayList<Bloque> getRed() {
		return red;
	}

	public void setRed(ArrayList<Bloque> red) {
		this.red = red;
	}
	
	public void agregarBloque(Bloque bloque) {
		this.red.add(bloque);
	}
	
}
