package br.com.ufpb.projetoLovaPoo.excessoes;

public class FuncionarioJaExisteException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 04L;
	
	public FuncionarioJaExisteException(){
		super("Funcionário já existe!");
	}

}
