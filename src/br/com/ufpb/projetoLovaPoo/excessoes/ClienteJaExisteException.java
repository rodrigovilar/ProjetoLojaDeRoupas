package br.com.ufpb.projetoLovaPoo.excessoes;

public class ClienteJaExisteException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 03L;
	
	public ClienteJaExisteException(){
		super("Cliente já existe!");
	}
	
}
