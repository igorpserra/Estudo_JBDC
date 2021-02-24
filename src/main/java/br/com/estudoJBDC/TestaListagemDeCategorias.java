package br.com.estudoJBDC;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import br.com.estudoJBDC.dao.CategoriaDAO;
import br.com.estudoJBDC.dao.ProdutoDAO;
import br.com.estudoJBDC.factory.ConnectionFactory;
import br.com.estudoJBDC.modelo.Categoria;
import br.com.estudoJBDC.modelo.Produto;

public class TestaListagemDeCategorias {

	public static void main(String[] args) throws SQLException {

		try(Connection connection = new ConnectionFactory().recuperarConexao()) {
			CategoriaDAO categoriaDAO = new CategoriaDAO(connection);	
			List<Categoria> listaDeCategorias = categoriaDAO.listarComProduto();
			listaDeCategorias.stream().forEach(ct -> {
				System.out.println(ct.getNome());
				for(Produto produto : ct.getProdutos()) {
					System.out.println(ct.getNome() + " - " + produto.getNome());
				}
			});
		}
	}
}
