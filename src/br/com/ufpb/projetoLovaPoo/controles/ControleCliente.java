package br.com.ufpb.projetoLovaPoo.controles;

import java.util.ArrayList;
import java.util.List;

import br.com.ufpb.projetoLovaPoo.entidades.Cliente;
import br.com.ufpb.projetoLovaPoo.excessoes.ClienteJaExisteException;
import br.com.ufpb.projetoLovaPoo.excessoes.ClienteNaoExisteException;

public class ControleCliente {

	private List<Cliente> clientes;

	public ControleCliente() {
		clientes = new ArrayList<Cliente>();
	}

	public List<Cliente> getClientes() {
		return clientes;
	}

	public void addCliente(Cliente c) throws ClienteJaExisteException {
		boolean cont = true;
		if(clientes.size() > 0){
			for (Cliente cliente : clientes) {
				if (cliente.getCpf().equalsIgnoreCase(c.getCpf())) {
					cont = false;					
				}
			}
		}if (cont == false) {
			throw new ClienteJaExisteException();
		}else{
		clientes.add(c);
		}
	}

	public void removerCliente(String cpf) throws ClienteNaoExisteException {
		boolean cont = false;
		if(clientes.size() > 0){
			for (Cliente c : clientes){
				if(c.getCpf().equalsIgnoreCase(cpf)){
					cont = true;
					clientes.remove(c);
				}
			}
		}if(cont == false){
			throw new ClienteNaoExisteException();
		}
	}

	public Cliente buscarClientePorCpf(String cpf)
			throws ClienteNaoExisteException {
		for (Cliente c : clientes) {
			if (c.getCpf().equalsIgnoreCase(cpf)) {
				return c;
			}
		}
		throw new ClienteNaoExisteException();
	}

	public List<Cliente> buscarClientePorNome(String nome) {
		List<Cliente> listaClientePorNome = new ArrayList<Cliente>();
		for (Cliente c : clientes){
			if(c.getNome().indexOf(nome) == 0){
				listaClientePorNome.add(c);
			}
		}
		return listaClientePorNome;

	}
	
	public List<Cliente> buscarClientesAtivosParaCrediario(){
		List<Cliente> listaClienteAtivoParaCrediario = new ArrayList<Cliente>();
		for(Cliente c : clientes){
			if(c.isClienteAtivoParaCrediario() == true){
				listaClienteAtivoParaCrediario.add(c);
			}
		}
		return listaClienteAtivoParaCrediario;
	}

}
