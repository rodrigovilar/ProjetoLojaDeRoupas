package br.com.ufpb.projetoLovaPoo.entidades;

public class Cliente extends Pessoa {

	private boolean clienteAtivoParaCrediario;

	public Cliente() {
		// Construtor padrão
	}

	public Cliente(String nome, String cpf, Endereco endreco, boolean clienteAtivoParaCrediario) {
		super(nome, cpf, endreco);
		this.clienteAtivoParaCrediario = clienteAtivoParaCrediario;
	}

	public boolean isClienteAtivoParaCrediario() {
		return clienteAtivoParaCrediario;
	}

	public void setClienteAtivoParaCrediario(boolean clienteAtivoParaCrediario) {
		this.clienteAtivoParaCrediario = clienteAtivoParaCrediario;
	}

}
