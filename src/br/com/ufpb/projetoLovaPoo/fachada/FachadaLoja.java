package br.com.ufpb.projetoLovaPoo.fachada;

import java.util.List;

import br.com.ufpb.projetoLovaPoo.controles.ControleCliente;
import br.com.ufpb.projetoLovaPoo.controles.ControleFuncionario;
import br.com.ufpb.projetoLovaPoo.controles.ControleProduto;
import br.com.ufpb.projetoLovaPoo.entidades.Cliente;
import br.com.ufpb.projetoLovaPoo.entidades.Funcionario;
import br.com.ufpb.projetoLovaPoo.entidades.Produto;
import br.com.ufpb.projetoLovaPoo.excessoes.ClienteJaExisteException;
import br.com.ufpb.projetoLovaPoo.excessoes.ClienteNaoExisteException;
import br.com.ufpb.projetoLovaPoo.excessoes.FuncionarioJaExisteException;
import br.com.ufpb.projetoLovaPoo.excessoes.FuncionarioNaoExisteException;
import br.com.ufpb.projetoLovaPoo.excessoes.ProdutoInvalidoException;
import br.com.ufpb.projetoLovaPoo.excessoes.ProdutoNaoExisteException;

public class FachadaLoja {

	ControleCliente controlCustomer;
	ControleProduto controlProduct;
	ControleFuncionario controlWorker;

	public FachadaLoja() {
		controlCustomer = new ControleCliente();
		controlProduct = new ControleProduto();
		controlWorker = new ControleFuncionario();
	}

	/*
	 * Controle Cliente
	 */

	public List<Cliente> getClientes() {
		return controlCustomer.getClientes();
	}

	public void adicionarCliente(Cliente c) throws ClienteJaExisteException {
		controlCustomer.addCliente(c);
	}

	public void removerCliente(String cpf) throws ClienteNaoExisteException {
		controlCustomer.removerCliente(cpf);
	}

	public Cliente buscarClientePorCpf(String cpf)
			throws ClienteNaoExisteException {
		return controlCustomer.buscarClientePorCpf(cpf);
	}

	public List<Cliente> buscarClientePorNome(String nome) {
		return controlCustomer.buscarClientePorNome(nome);
	}

	public List<Cliente> buscarClientesAtivosParaCrediario() {
		return controlCustomer.buscarClientesAtivosParaCrediario();
	}

	/*
	 * Controle Produto
	 */

	public List<Produto> getProdutos() {
		return controlProduct.getProdutos();
	}

	public void adicionarProduto(Produto p) throws ProdutoInvalidoException {
		controlProduct.addProduto(p);
	}

	public void removerProduto(String codigoDeBarras)
			throws ProdutoNaoExisteException {
		controlProduct.removerProduto(codigoDeBarras);
	}

	public Produto buscarProdutoPorCodigoDeBarras(String codigoDeBarras)
			throws ProdutoNaoExisteException {
		return controlProduct.buscarProdutoPorCodigoDeBarras(codigoDeBarras);
	}

	public List<Produto> buscarProdutosPorNomeOuMarcaOuTamanho(String n) {
		return controlProduct.buscarProdutosPorNomeOuMarcaOuTamanho(n);
	}

	/*
	 * Controle Funcionário
	 */

	public List<Funcionario> getFuncionarios() {
		return controlWorker.getFuncionarios();
	}

	public void adicionarFuncionario(Funcionario f)
			throws FuncionarioJaExisteException {
		controlWorker.addFuncionario(f);
	}

	public void removerFuncionario(String matricula)
			throws FuncionarioNaoExisteException {
		controlWorker.removerFuncionario(matricula);
	}

	public Funcionario buscarFuncionarioPorMatriculaOuCpf(String mc)
			throws FuncionarioNaoExisteException {
		return controlWorker.buscarFuncionarioPorMatriculaOuCpf(mc);
	}

	public List<Funcionario> buscarFuncionariosPorNome(String nome) {
		return controlWorker.buscarFuncionarioPorNome(nome);
	}

	public List<Funcionario> buscarGerentes() {
		return controlWorker.buscarGerentes();
	}

}
