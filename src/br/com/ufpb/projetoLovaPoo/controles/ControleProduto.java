package br.com.ufpb.projetoLovaPoo.controles;

import java.util.ArrayList;
import java.util.List;

import br.com.ufpb.projetoLovaPoo.entidades.Produto;
import br.com.ufpb.projetoLovaPoo.excessoes.ProdutoInvalidoException;
import br.com.ufpb.projetoLovaPoo.excessoes.ProdutoNaoExisteException;

;

public class ControleProduto {

	private List<Produto> produtos;

	public ControleProduto() {
		produtos = new ArrayList<Produto>();
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void addProduto(Produto p) throws ProdutoInvalidoException {
		if (p == null) {
			throw new ProdutoInvalidoException();
		} else {
			produtos.add(p);
		}
	}

	public void removerProduto(String codigoDeBarras)
			throws ProdutoNaoExisteException {
		boolean remover = false;
		for (Produto p : produtos) {
			if (p.getCodigoBarras().equalsIgnoreCase(codigoDeBarras)) {
				produtos.remove(p);
				remover = true;
			}
		}
		if (remover == false) {
			throw new ProdutoNaoExisteException();
		}
	}

	public Produto buscarProdutoPorCodigoDeBarras(String codigoDeBarras)
			throws ProdutoNaoExisteException {
		for (Produto p : produtos) {
			if (p.getCodigoBarras().equalsIgnoreCase(codigoDeBarras)) {
				return p;
			}
		}
		throw new ProdutoNaoExisteException();
	}

	public List<Produto> buscarProdutosPorNomeOuMarcaOuTamanho(String s) {
		List<Produto> listaProdutosPorNomeOuMarcaOuTamanho = new ArrayList<Produto>();
		for (Produto p : produtos) {
			if (p.getNome().indexOf(s) == 0 || p.getMarca().indexOf(s) == 0
					|| p.getTamanho().equalsIgnoreCase(s)) {
				listaProdutosPorNomeOuMarcaOuTamanho.add(p);
			}
		}
		return listaProdutosPorNomeOuMarcaOuTamanho;
	}

}
