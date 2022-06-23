package br.com.agenda.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
//import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.QueryReturnType;
import com.mysql.cj.protocol.Resultset;
//import com.mysql.cj.xdevapi.Result;

//import com.mysql.jdbc.Connection;
//import com.mysql.jdbc.PreparedStatement;

import br.com.agenda.factory.ConnectionFactory;
import br.com.agenda.model.Contato;

public class ContatoDAO {
	
	Contato contato;
	
	public void salvar(Contato contato) {

		String queryInsert = "INSERT INTO contatos(nome, idade, dataCadastro) VALUES (?, ?, ?)";

		Connection conn = null;

		PreparedStatement pstm = null;

		try {
			// Criar uma conexão com o banco de dados
			conn = ConnectionFactory.createConnectionToMySQL();

			// Criar um PreparedStatement para executar uma query
			pstm = (PreparedStatement) conn.prepareStatement(queryInsert);

			// Adicionar os valores que são esperados pela query
			pstm.setString(1, contato.getNome());
			pstm.setInt(2, contato.getIdade());
			pstm.setDate(3, new Date(contato.getDataCadastro().getTime()));

			// Executar a query
			pstm.execute();
			System.out.println("Dados salvos com sucesso!");

		} catch (Exception e) {
			e.getMessage();
			e.printStackTrace();

		} finally {

			// Fechar as conexões do banco
			try {

				if (pstm != null) {
					pstm.close();
				}

				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public List<Contato> listar() {

		String queryRead = "SELECT * FROM contatos";

		List<Contato> contatos = new ArrayList<>();

		Connection conn = null;

		PreparedStatement pstm = null;

		// Classe que vai recuperar os dados do banco
		Resultset rset = null;

		try {

			conn = ConnectionFactory.createConnectionToMySQL();

			pstm = (PreparedStatement) conn.prepareStatement(queryRead);

			rset = (Resultset) pstm.executeQuery();

			while (((ResultSet) rset).next()) {

				Contato contato = new Contato();

				// Recuperar os dados
				contato.setId(((ResultSet) rset).getInt("id"));
				contato.setNome(((ResultSet) rset).getString("nome"));
				contato.setIdade(((ResultSet) rset).getInt("idade"));
				contato.setDataCadastro(((ResultSet) rset).getDate("dataCadastro"));

				contatos.add(contato);
			}

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			try {

				if (rset != null) {
					// ((Connection) rset).close();
				}

				if (pstm != null) {
					pstm.close();
				}

				if (conn != null) {
					conn.close();
				}

			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

		return contatos;
	}

	public void atualizar(Contato contato) {

		String queryUpdate = "UPDATE contatos SET nome = ?, idade = ?, dataCadastro = ?" + "WHERE id = ?";

		Connection conn = null;

		PreparedStatement pstm = null;

		try {

			// Criar conexão com o banco de dados
			conn = ConnectionFactory.createConnectionToMySQL();

			// Criar a classe para executar a query
			pstm = (PreparedStatement) conn.prepareStatement(queryUpdate);

			// Adicionar os valores para atualizar
			pstm.setString(1, contato.getNome());
			pstm.setInt(2, contato.getIdade());
			pstm.setDate(3, new Date(contato.getDataCadastro().getTime()));

			pstm.setInt(4, contato.getId()); //ID do registro que deseja atualizar

			// Executar a query
			pstm.execute();

		} catch (Exception e) {
			e.printStackTrace();

		} finally {

			try {
				if (pstm != null) {

					pstm.close();
				}

				if (conn != null) {

					conn.close();
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	public void deletar(int id) {
		
		String queryDelete = "DELETE FROM contatos WHERE id = ?";
		
		Connection conn = null;
		
		PreparedStatement pstm = null;
		
		try {
		
			conn = ConnectionFactory.createConnectionToMySQL();
			
			pstm = (PreparedStatement)conn.prepareStatement(queryDelete);
			
			pstm.setInt(1, id);
			
			int linhasAfetadas = pstm.executeUpdate();
			
			pstm.execute();
			System.out.println("\nDeletado com sucesso "+linhasAfetadas+", linha(s) foi(ram) afetadas");
			
		}catch (Exception e) {
			System.out.println("ID não localizado no banco de dados");
			e.getMessage();
			e.printStackTrace();
			
		}finally {
			
			try {
				
				if(pstm!=null) {
					pstm.close();
				}
				
				if(conn!=null) {
					conn.close();
				}
				
			}catch (Exception e) {
				e.printStackTrace();
			}
			
		}
	}
}
