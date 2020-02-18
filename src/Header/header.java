package Header;

public class Header {
	
	private String hash_prev;
	private String nonce;
	private String hash_raiz;
		
	public String getHash_prev() {
		return hash_prev;
	}
	public void setHash_prev(String hash_prev) {
		this.hash_prev = hash_prev;
	}
	public String getNonce() {
		return nonce;
	}
	public void setNonce(String nonce) {
		this.nonce = nonce;
	}
	public String getHash_raiz() {
		return hash_raiz;
	}
	public void setHash_raiz(String hash_raiz) {
		this.hash_raiz = hash_raiz;
	}	

}
