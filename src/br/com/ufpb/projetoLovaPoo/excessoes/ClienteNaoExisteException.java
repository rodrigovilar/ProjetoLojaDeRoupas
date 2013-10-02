package br.com.ufpb.projetoLovaPoo.excessoes;

public class ClienteNaoExisteException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 01L;

	public ClienteNaoExisteException(){
		super("Cliente não existe!");
	}

}
