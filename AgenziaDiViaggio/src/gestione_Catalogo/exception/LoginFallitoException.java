/**
 * 
 */
package gestione_Catalogo.exception;

/**
 * @authors
 * Remo Sperlongano
 * Ivan Torre
 */
public class LoginFallitoException extends Exception {
	
	private static final long	serialVersionUID	= 1L;

	public LoginFallitoException(){
		
	}
	
	public LoginFallitoException(String m){
		super(m);
	}
	
	public String toString(){
		return "Password errata o utente non registrato";
	}
	
}
