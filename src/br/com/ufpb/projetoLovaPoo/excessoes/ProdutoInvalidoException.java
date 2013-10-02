package br.com.ufpb.projetoLovaPoo.excessoes;

public class ProdutoInvalidoException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 06L;
	
	public ProdutoInvalidoException(){
		super("Produto inválido!");
	}

}
