package br.com.ufpb.projetoLovaPoo.entidades;

public class Funcionario extends Pessoa {

	private String matricula;
	private boolean gerente;

	public Funcionario() {
		// Construtor padrão
	}

	public Funcionario(String nome, String cpf, Endereco endreco,
			String matricula, boolean gerente) {
		super(nome, cpf, endreco);
		this.matricula = matricula;
		this.gerente = gerente;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public boolean isGerente() {
		return gerente;
	}

	public void setGerente(boolean gerente) {
		this.gerente = gerente;
	}

}
