package Repositorio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import DAL.ConectaBd;
import Produto.Produto;

public class RepositorioProduto {
	Connection conn;

	public RepositorioProduto() throws ClassNotFoundException {
		this.conn = ConectaBd.conectabd();
	}

	public void cadastrar(Produto produto) throws SQLException {
		
		// Criando a String SQL
		String sql = "insert into produto (nome,quantidade) values (?,?)";

		// Criar o PreparedStatement, objeto para executar a query
		PreparedStatement preStatement = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

		// Atualizando o primeiro parametro
		preStatement.setString(1, produto.getNome());
		preStatement.setInt(2, produto.getQuantidade());
	
		

		preStatement.execute();

		// Retorna um ResultSet com todas as chaves geradas
		ResultSet resultSet = preStatement.getGeneratedKeys();
		Integer clienteId = 0;

		// Pegando o identificador gerado a partir do último insert
		while (resultSet.next()) {
			clienteId = resultSet.getInt(1);
		}
		System.out.println("ID do Insert no Banco " + clienteId);
		JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso");
	}

	
	public void atualizar(Produto produto) throws SQLException {

		// Criando a String SQL
		String sql = "update produto set nome= ?, quantidade=? where id = ?";
		// Criar o PreparedStatement, objeto para executar a query
		PreparedStatement preStatement;

		preStatement = conn.prepareStatement(sql);

		preStatement.setString(1, produto.getNome());
	

		// Executando o select
		preStatement.executeUpdate();
		
		System.out.println("Atualizado Com Sucesso");
		JOptionPane.showMessageDialog(null, "Atualizado Com Sucesso");
	}

	
	public void remover(int id) throws SQLException {

		// Criando a String SQL
		String sql = "delete from Produto where id = ?";

		// Criar o PreparedStatement, objeto para executar a query
		PreparedStatement preStatement = conn.prepareStatement(sql);

		preStatement.setInt(1, id);

		// Executando o select
		preStatement.executeUpdate();
		
		
		JOptionPane.showMessageDialog(null, "REMOVIDO COM SUCESSO");
		
	}

	
	public Produto procurar(String nome1) throws SQLException {

		String sql = "select * from produto where nome= ?";

		PreparedStatement preStatement = conn.prepareStatement(sql);

		preStatement.setString(1, nome1);
		ResultSet resultSet = preStatement.executeQuery();
		while (resultSet.next()) {
		int codigo = resultSet.getInt(1);
		String nome = resultSet.getString(2);
		int quantidade = Integer.parseInt(resultSet.getString(3));
		
		
		Produto produto = new Produto(nome, quantidade,codigo);
		return produto;
		
		}
		
		return null;
		
	}

	
	public boolean existe(int id) throws SQLException {
		
		String sql = "select * from produto where id= ?";

		PreparedStatement preStatement = conn.prepareStatement(sql);

		preStatement.setInt(1, id);
		ResultSet resultSet = preStatement.executeQuery();
		return true;
	}

	public ArrayList<Produto> listar() throws SQLException {

		ArrayList<Produto> arrayListProduto = new ArrayList<Produto>();

		// Criando a String SQL
		String sql = "select * from produto";

		// Criar o PreparedStatement, objeto para executar a query
		PreparedStatement preStatement = conn.prepareStatement(sql);

		ResultSet resultSet = preStatement.executeQuery();

		// Verifica se retornou dados na consulta
		while (resultSet.next()) {
			// Pegando as colunas do registro
			int codigo = resultSet.getInt(1);
			String nome = resultSet.getString(2);
			int quantidade = Integer.parseInt(resultSet.getString(3));
			
			Produto produto = new Produto(nome, quantidade,codigo);
			arrayListProduto.add(produto);
		}

		return arrayListProduto;
	}

}
