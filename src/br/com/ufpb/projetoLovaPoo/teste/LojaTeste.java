package br.com.ufpb.projetoLovaPoo.teste;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import br.com.ufpb.projetoLovaPoo.entidades.Cliente;
import br.com.ufpb.projetoLovaPoo.entidades.Endereco;
import br.com.ufpb.projetoLovaPoo.entidades.Funcionario;
import br.com.ufpb.projetoLovaPoo.entidades.Produto;
import br.com.ufpb.projetoLovaPoo.excessoes.ClienteJaExisteException;
import br.com.ufpb.projetoLovaPoo.excessoes.ClienteNaoExisteException;
import br.com.ufpb.projetoLovaPoo.excessoes.FuncionarioJaExisteException;
import br.com.ufpb.projetoLovaPoo.excessoes.FuncionarioNaoExisteException;
import br.com.ufpb.projetoLovaPoo.excessoes.ProdutoInvalidoException;
import br.com.ufpb.projetoLovaPoo.excessoes.ProdutoNaoExisteException;
import br.com.ufpb.projetoLovaPoo.fachada.FachadaLoja;

public class LojaTeste {

	FachadaLoja fachada;

	@Before
	public void iniciar() {
		fachada = new FachadaLoja();
	}

	// Teste Controle Cliente

	@Test
	public void novoCliente() throws ClienteJaExisteException {
		Cliente cliente = criarClienteMinimo();
		verificaCriacaoCliente(cliente);
	}

	@Test
	public void doisClientes() throws ClienteJaExisteException {
		Cliente cliente1 = criarClientePadrao();
		fachada.adicionarCliente(cliente1);
		Cliente cliente2 = criarClienteMinimo();
		fachada.adicionarCliente(cliente2);

		List<Cliente> clientes = fachada.getClientes();
		assertEquals(2, clientes.size());
		assertEquals(cliente1, clientes.get(0));
		assertEquals(cliente2, clientes.get(1));
	}

	@Test
	public void buscarClientePorCpf() throws ClienteNaoExisteException,
			ClienteJaExisteException {
		Cliente cliente1 = criarClientePadrao();
		fachada.adicionarCliente(cliente1);
		Cliente cliente2 = criarClienteMinimo();
		fachada.adicionarCliente(cliente2);

		assertEquals(cliente1, fachada.buscarClientePorCpf("000.003.300-03"));
		assertEquals(cliente2, fachada.buscarClientePorCpf("001.010.100-00"));
	}

	@Test
	public void removerCliente() throws ClienteNaoExisteException,
			ClienteJaExisteException {
		Cliente cliente1 = criarClientePadrao();
		fachada.adicionarCliente(cliente1);
		Cliente cliente2 = criarClienteMinimo();
		fachada.adicionarCliente(cliente2);

		fachada.removerCliente("000.003.300-03");
		assertFalse(fachada.getClientes().contains(cliente1));
	}

	@Test
	public void buscarClientesPorNome() throws ClienteJaExisteException {
		List<Cliente> clientesCadastrados = listaClientes();
		adicionarClientesFachada(clientesCadastrados);

		List<Cliente> clientesPorNome = fachada.buscarClientePorNome("José");
		assertEquals(3, clientesPorNome.size());
		assertTrue(clientesPorNome.contains(clientesCadastrados.get(0)));
		assertTrue(clientesPorNome.contains(clientesCadastrados.get(1)));
		assertFalse(clientesPorNome.contains(clientesCadastrados.get(2)));
		assertTrue(clientesPorNome.contains(clientesCadastrados.get(3)));
	}

	@Test
	public void buscarClientesAtivosParaCrediario()
			throws ClienteJaExisteException {
		List<Cliente> clientesCadastrados = listaClientes();
		adicionarClientesFachada(clientesCadastrados);

		List<Cliente> clientesAtivos = fachada
				.buscarClientesAtivosParaCrediario();
		assertEquals(2, clientesAtivos.size());
		assertTrue(clientesAtivos.contains(clientesCadastrados.get(0)));
		assertFalse(clientesAtivos.contains(clientesCadastrados.get(1)));
		assertTrue(clientesAtivos.contains(clientesCadastrados.get(2)));
		assertFalse(clientesAtivos.contains(clientesCadastrados.get(3)));
	}

	// Teste de Controle Funcionário

	@Test
	public void novoFuncionario() throws FuncionarioJaExisteException {
		Funcionario funcionario = criarFuncionarioPadrao();
		verificaCriacaoFuncionario(funcionario);
	}

	@Test
	public void doisFuncionarios() throws FuncionarioJaExisteException {
		Funcionario func1 = criarFuncionarioGerentePadrao();
		fachada.adicionarFuncionario(func1);
		Funcionario func2 = criarFuncionarioPadrao();
		fachada.adicionarFuncionario(func2);

		List<Funcionario> funcionarios = fachada.getFuncionarios();
		assertEquals(2, funcionarios.size());
		assertEquals(func1, funcionarios.get(0));
		assertEquals(func2, funcionarios.get(1));
	}

	@Test
	public void buscarFuncionarioPorMatricula()
			throws FuncionarioNaoExisteException, FuncionarioJaExisteException {
		Funcionario func1 = criarFuncionarioGerentePadrao();
		fachada.adicionarFuncionario(func1);
		Funcionario func2 = criarFuncionarioPadrao();
		fachada.adicionarFuncionario(func2);

		assertEquals(func1,
				fachada.buscarFuncionarioPorMatriculaOuCpf("31121450"));
		assertEquals(func2,
				fachada.buscarFuncionarioPorMatriculaOuCpf("31121354"));
	}

	@Test
	public void buscarFuncionarioPorCpf() throws FuncionarioNaoExisteException,
			FuncionarioJaExisteException {
		Funcionario func1 = criarFuncionarioGerentePadrao();
		fachada.adicionarFuncionario(func1);
		Funcionario func2 = criarFuncionarioPadrao();
		fachada.adicionarFuncionario(func2);

		assertEquals(func1,
				fachada.buscarFuncionarioPorMatriculaOuCpf("200.020.002-00"));
		assertEquals(func2,
				fachada.buscarFuncionarioPorMatriculaOuCpf("002.020.200-00"));
	}

	@Test
	public void removerFuncionario() throws FuncionarioNaoExisteException,
			FuncionarioJaExisteException {
		Funcionario func1 = criarFuncionarioGerentePadrao();
		fachada.adicionarFuncionario(func1);
		Funcionario func2 = criarFuncionarioPadrao();
		fachada.adicionarFuncionario(func2);

		fachada.removerFuncionario("31121450");
		assertFalse(fachada.getFuncionarios().contains(func1));
	}

	@Test
	public void buscarFuncionariosPorNome() throws FuncionarioJaExisteException {
		List<Funcionario> funcionariosCadastrados = listaFuncionarios();
		adicionaarFuncionarioFachada(funcionariosCadastrados);

		List<Funcionario> funcionariosPorNome = fachada
				.buscarFuncionariosPorNome("Marcelina");
		assertEquals(1, funcionariosPorNome.size());
		assertFalse(funcionariosPorNome
				.contains(funcionariosCadastrados.get(0)));
		assertFalse(funcionariosPorNome
				.contains(funcionariosCadastrados.get(1)));
		assertTrue(funcionariosPorNome.contains(funcionariosCadastrados.get(2)));
		assertFalse(funcionariosPorNome
				.contains(funcionariosCadastrados.get(3)));
	}

	@Test
	public void buscarGerentes() throws FuncionarioJaExisteException {
		List<Funcionario> funcionariosCadastrados = listaFuncionarios();
		adicionaarFuncionarioFachada(funcionariosCadastrados);

		List<Funcionario> funcionariosPorNome = fachada.buscarGerentes();
		assertEquals(2, funcionariosPorNome.size());
		assertTrue(funcionariosPorNome.contains(funcionariosCadastrados.get(0)));
		assertFalse(funcionariosPorNome
				.contains(funcionariosCadastrados.get(1)));
		assertTrue(funcionariosPorNome.contains(funcionariosCadastrados.get(2)));
		assertFalse(funcionariosPorNome
				.contains(funcionariosCadastrados.get(3)));
	}

	// Teste de Controle Produto

	@Test
	public void novoProduto() throws ProdutoInvalidoException {
		Produto produto = criarProdutoMinimo();
		verificaCriacaoProduto(produto);
	}

	@Test
	public void doisProdutos() throws ProdutoInvalidoException {
		Produto produto1 = criarProdutoMinimo();
		fachada.adicionarProduto(produto1);
		Produto produto2 = criarProdutoPadrao();
		fachada.adicionarProduto(produto2);

		List<Produto> produtos = fachada.getProdutos();
		assertEquals(2, produtos.size());
		assertEquals(produto1, produtos.get(0));
		assertEquals(produto2, produtos.get(1));
	}

	@Test
	public void buscarProdutoPorCodigoDeBarras()
			throws ProdutoNaoExisteException, ProdutoInvalidoException {
		Produto produto1 = criarProdutoMinimo();
		fachada.adicionarProduto(produto1);
		Produto produto2 = criarProdutoPadrao();
		fachada.adicionarProduto(produto2);

		assertEquals(produto1,
				fachada.buscarProdutoPorCodigoDeBarras("00000000001214301"));
		assertEquals(produto2,
				fachada.buscarProdutoPorCodigoDeBarras("00000000001214302"));
	}

	@Test
	public void removerProduto() throws ProdutoNaoExisteException,
			ProdutoInvalidoException {
		Produto produto1 = criarProdutoMinimo();
		fachada.adicionarProduto(produto1);
		Produto produto2 = criarProdutoPadrao();
		fachada.adicionarProduto(produto2);

		fachada.removerProduto("00000000001214301");
		assertFalse(fachada.getProdutos().contains(produto1));
	}

	@Test
	public void buscarProdutoPorNome() throws ProdutoInvalidoException {
		List<Produto> produtosExtras = produtosExtras();
		adicionarProdutosFachada(produtosExtras);
		List<Produto> produtosPorNome = fachada
				.buscarProdutosPorNomeOuMarcaOuTamanho("Camisa");
		assertEquals(3, produtosPorNome.size());
		assertTrue(produtosPorNome.contains(produtosExtras.get(0)));
		assertTrue(produtosPorNome.contains(produtosExtras.get(1)));
		assertTrue(produtosPorNome.contains(produtosExtras.get(2)));
	}

	@Test
	public void buscarProdutoPorMarca() throws ProdutoInvalidoException {
		List<Produto> produtosExtras = produtosExtras();
		adicionarProdutosFachada(produtosExtras);
		List<Produto> produtosPorMarca = fachada
				.buscarProdutosPorNomeOuMarcaOuTamanho("Hering");
		assertEquals(2, produtosPorMarca.size());
		assertTrue(produtosPorMarca.contains(produtosExtras.get(0)));
		assertTrue(produtosPorMarca.contains(produtosExtras.get(1)));
	}

	@Test
	public void buscarProdutoPorTamanho() throws ProdutoInvalidoException {
		List<Produto> produtosExtras = produtosExtras();
		adicionarProdutosFachada(produtosExtras);
		List<Produto> produtosPorTamanho = fachada
				.buscarProdutosPorNomeOuMarcaOuTamanho("P");
		assertEquals(3, produtosPorTamanho.size());
		assertTrue(produtosPorTamanho.contains(produtosExtras.get(0)));
		assertTrue(produtosPorTamanho.contains(produtosExtras.get(1)));
		assertTrue(produtosPorTamanho.contains(produtosExtras.get(2)));
	}

	// Teste de Exceções

	@Test(expected = ClienteJaExisteException.class)
	public void testeClienteJaExisteException() throws ClienteJaExisteException {
		fachada.adicionarCliente(criarClienteMinimo());
		fachada.adicionarCliente(criarClienteMinimo());
	}

	@Test(expected = ClienteNaoExisteException.class)
	public void testeClienteNaoExisteException()
			throws ClienteNaoExisteException, ClienteJaExisteException {
		fachada.adicionarCliente(criarClienteMinimo());
		fachada.adicionarCliente(criarClientePadrao());
		fachada.removerCliente("003.030.300-00");
	}

	@Test(expected = FuncionarioJaExisteException.class)
	public void testeFuncionarioJaExisteException()
			throws FuncionarioJaExisteException {
		fachada.adicionarFuncionario(criarFuncionarioPadrao());
		fachada.adicionarFuncionario(criarFuncionarioPadrao());
	}

	@Test(expected = FuncionarioNaoExisteException.class)
	public void testeFuncionarioNaoExisteException()
			throws FuncionarioNaoExisteException, FuncionarioJaExisteException {
		fachada.adicionarFuncionario(criarFuncionarioGerentePadrao());
		fachada.adicionarFuncionario(criarFuncionarioPadrao());
		fachada.buscarFuncionarioPorMatriculaOuCpf("81231231");
		fachada.buscarFuncionarioPorMatriculaOuCpf("003.030.300-01");
	}

	@Test(expected = ProdutoInvalidoException.class)
	public void testeProdutoInvalidoException() throws ProdutoInvalidoException {
		fachada.adicionarProduto(null);
		fachada.adicionarProduto(null);
	}

	@Test(expected = ProdutoNaoExisteException.class)
	public void testeProdutoNaoExisteException()
			throws ProdutoNaoExisteException, ProdutoInvalidoException {
		fachada.adicionarProduto(criarProdutoMinimo());
		fachada.adicionarProduto(criarProdutoPadrao());
		fachada.buscarProdutoPorCodigoDeBarras("00000000002749374");
	}

	// Métodos Necessários

	private void adicionarProdutosFachada(List<Produto> produtosExtras)
			throws ProdutoInvalidoException {
		for (Produto p : produtosExtras) {
			fachada.adicionarProduto(p);
		}
	}

	private void adicionaarFuncionarioFachada(
			List<Funcionario> funcionariosCadastrados)
			throws FuncionarioJaExisteException {
		for (Funcionario f : funcionariosCadastrados) {
			fachada.adicionarFuncionario(f);
		}
	}

	private void adicionarClientesFachada(List<Cliente> clientesCadastrados)
			throws ClienteJaExisteException {
		for (Cliente c : clientesCadastrados) {
			fachada.adicionarCliente(c);
		}
	}

	private List<Funcionario> listaFuncionarios() {
		String[] nomes = { "José Carlos", "José Everaldo", "Marcelina Dantas",
				"José Francisco" };
		String[] cpfs = { "001.010.100-01", "002.020.200-02", "003.030.300-03",
				"004.040.400-04" };
		boolean[] gerente = { true, false, true, false };
		List<Funcionario> funcionarios = new ArrayList<Funcionario>();

		int quantClientes = 4;
		for (int i = 0; i < quantClientes; i++) {
			Funcionario f = new Funcionario();
			f.setNome(nomes[i]);
			f.setCpf(cpfs[i]);
			f.setGerente(gerente[i]);
			funcionarios.add(f);
		}
		return funcionarios;
	}

	private List<Cliente> listaClientes() {
		String[] nomes = { "José Carlos", "José Everaldo", "Marcelina Dantas",
				"José Francisco" };
		String[] cpfs = { "001.010.100-01", "002.020.200-02", "003.030.300-03",
				"004.040.400-04" };
		boolean[] ativarCrediario = { true, false, true, false };
		List<Cliente> clientes = new ArrayList<Cliente>();

		int quantClientes = 4;
		for (int i = 0; i < quantClientes; i++) {
			Cliente c = new Cliente();
			c.setNome(nomes[i]);
			c.setCpf(cpfs[i]);
			c.setClienteAtivoParaCrediario(ativarCrediario[i]);
			clientes.add(c);
		}
		return clientes;
	}

	private List<Produto> produtosExtras() {
		String[] nomes = { "Camisa Casual", "Camisa Casual", "Camisa Polo",
				"Calça Jeans" };
		String[] marcas = { "Hering", "Hering", "Online", "Colcci" };
		String[] tamanhos = { "P", "P", "P", "M" };
		String[] codigoBarras = { "0000000000274937", "0000000000274937",
				"0000000000274937", "0000000000274937" };
		List<Produto> produtosExtras = new ArrayList<Produto>();
		int quantProdutos = 4;
		for (int i = 0; i < quantProdutos; i++) {
			Produto p = new Produto();
			p.setNome(nomes[i]);
			p.setMarca(marcas[i]);
			p.setTamanho(tamanhos[i]);
			p.setCodigoBarras(codigoBarras[i] + Integer.toString(i));
			produtosExtras.add(p);
		}
		return produtosExtras;

	}

	private void verificaCriacaoCliente(Cliente c)
			throws ClienteJaExisteException {
		fachada.adicionarCliente(c);
		List<Cliente> clientes = fachada.getClientes();

		assertEquals(1, clientes.size());
		assertEquals(c, clientes.get(0));

	}

	private void verificaCriacaoProduto(Produto produto)
			throws ProdutoInvalidoException {
		fachada.adicionarProduto(produto);
		List<Produto> produtos = fachada.getProdutos();

		assertEquals(1, produtos.size());
		assertEquals(produto, produtos.get(0));

	}

	private void verificaCriacaoFuncionario(Funcionario funcionario)
			throws FuncionarioJaExisteException {
		fachada.adicionarFuncionario(funcionario);
		List<Funcionario> funcionarios = fachada.getFuncionarios();

		assertEquals(1, funcionarios.size());
		assertEquals(funcionario, funcionarios.get(0));
	}

	private Funcionario criarFuncionarioGerentePadrao() {
		Funcionario f = criarFuncionarioPadrao();
		f.setCpf("200.020.002-00");
		f.setGerente(true);
		f.setMatricula("31121450");
		return f;
	}

	private Cliente criarClientePadrao() {
		Cliente c = criarClienteMinimo();
		c.setCpf("000.003.300-03");
		c.setEndereco(criarEnderecoPadrao());
		c.setClienteAtivoParaCrediario(true);
		return c;
	}

	private Produto criarProdutoMinimo() {
		Produto p = new Produto();
		p.setNome("Camisa Casual");
		p.setMarca("Hering");
		p.setCodigoBarras("00000000001214301");
		p.setQuantProdutos(2);
		return p;
	}

	private Produto criarProdutoPadrao() {
		Produto p = criarProdutoMinimo();
		p.setCodigoBarras("00000000001214302");
		p.setPrecoDeCusto(72.90);
		p.setPrecoDeVenda(83.90);
		p.setTamanho("M");
		p.setDisponivelParaVendas(true);
		return p;
	}

	private Funcionario criarFuncionarioPadrao() {
		Funcionario f = new Funcionario();
		f.setNome("Ittalo Pessoa");
		f.setCpf("002.020.200-00");
		f.setGerente(false);
		f.setMatricula("31121354");
		return f;
	}

	private Cliente criarClienteMinimo() {
		Cliente c = new Cliente();
		c.setNome("José Paulo");
		c.setCpf("001.010.100-00");
		return c;
	}

	private Endereco criarEnderecoPadrao() {
		Endereco e = new Endereco();
		e.setLogradouro("Rua Rio Tinto");
		e.setNumeroCasa(112);
		e.setBairro("Centro");
		e.setCep("58000-000");
		e.setCidade("Rio Tinto");
		e.setEstado("PB");
		e.setTelefone("83 8888-8888");
		return e;
	}

}