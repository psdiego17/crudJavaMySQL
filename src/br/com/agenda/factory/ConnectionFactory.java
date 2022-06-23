package br.com.agenda.factory;

import java.sql.Connection;
import java.sql.DriverManager;

//import com.mysql.jdbc.Connection;

public class ConnectionFactory {
	
	private static final String USERNAME = "root";
	private static final String PASSWORD = "root";
	private static final String DATABASE_URL = "jdbc:mysql://127.0.0.1:3306/agenda";
	
	
	//Conex�o com o banco de dados
	public static Connection createConnectionToMySQL() throws Exception{
		
		//Faz com que a classe seja carregada pela JVM
		
		//Class.forName("com.mysql.jdbc.Driver");
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		//Cria conex�o com o banco de dados
		Connection connection = (Connection) DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
		
		return connection;
	}
	
	
	public static void main(String[] args) throws Exception {
		//Recupera uma conex�o com o banco de dados
		Connection con = createConnectionToMySQL();
		
		//Testar se a conex�o � nula
		if(con!=null) {
			System.out.println("Conex�o obtida com suceso");
			con.close();
		}
	}
	
}
