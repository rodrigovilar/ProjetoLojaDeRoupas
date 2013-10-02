package br.com.ufpb.projetoLovaPoo.excessoes;

public class FuncionarioNaoExisteException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 05L;
	
	public FuncionarioNaoExisteException(){
		super("Funcionario não existe!");
	}

}
