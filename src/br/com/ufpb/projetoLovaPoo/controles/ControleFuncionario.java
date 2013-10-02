package br.com.ufpb.projetoLovaPoo.controles;

import java.util.ArrayList;
import java.util.List;

import br.com.ufpb.projetoLovaPoo.entidades.Funcionario;
import br.com.ufpb.projetoLovaPoo.excessoes.FuncionarioJaExisteException;
import br.com.ufpb.projetoLovaPoo.excessoes.FuncionarioNaoExisteException;

public class ControleFuncionario {

	private List<Funcionario> funcionarios;

	public ControleFuncionario() {
		funcionarios = new ArrayList<Funcionario>();
	}

	public List<Funcionario> getFuncionarios() {
		return funcionarios;
	}

	public void addFuncionario(Funcionario f)
			throws FuncionarioJaExisteException {
		boolean cont = true;
		if(funcionarios.size() > 0){
			for (Funcionario fun : funcionarios) {
				if (fun.getCpf().equalsIgnoreCase(f.getCpf())) {
					cont = false;					
				}
			}
		}
		if(cont == false){
			throw new FuncionarioJaExisteException();
		}
		funcionarios.add(f);
	}

	public void removerFuncionario(String matricula)
			throws FuncionarioNaoExisteException {
		boolean remover = false;
		for (Funcionario f : funcionarios) {
			if (f.getMatricula().equalsIgnoreCase(matricula)) {
				remover = true;
				funcionarios.remove(f);
			}
		}
		if (remover == false) {
			throw new FuncionarioNaoExisteException();
		}
	}

	public Funcionario buscarFuncionarioPorMatriculaOuCpf(String mc)
			throws FuncionarioNaoExisteException {
		for (Funcionario f : funcionarios) {
			if (f.getMatricula().equalsIgnoreCase(mc)
					|| f.getCpf().equalsIgnoreCase(mc)) {
				return f;
			}
		}
		throw new FuncionarioNaoExisteException();
	}

	public List<Funcionario> buscarFuncionarioPorNome(String nome) {
		List<Funcionario> listaFuncionariosPorNome = new ArrayList<Funcionario>();
		for (Funcionario f : funcionarios) {
			if (f.getNome().indexOf(nome) == 0) {
				listaFuncionariosPorNome.add(f);
			}
		}
		return listaFuncionariosPorNome;
	}

	public List<Funcionario> buscarGerentes() {
		List<Funcionario> listaDeGerentes = new ArrayList<Funcionario>();
		for (Funcionario f : funcionarios) {
			if (f.isGerente() == true) {
				listaDeGerentes.add(f);
			}
		}
		return listaDeGerentes;
	}

}
