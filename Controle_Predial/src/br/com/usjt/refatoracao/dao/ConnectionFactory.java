/**
 * Classe responsável por retornar a conexão com o banco de dados
 */
package br.com.usjt.refatoracao.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**@author Matheus Ribeiro Barbosa Santos e Samuel Alves de Almeida
 */
public class ConnectionFactory 
{

	//Carrega o driver
	static
	{
		try
		{
			Class.forName( "com.mysql.jdbc.Driver" );
		}
		catch( ClassNotFoundException e )
		{
			throw new RuntimeException( "Sem driver de banco dados" );
		}
	}

	/**
	 *Método responsável por retornar a conexão com o banco de dados
	 */
	public  Connection obtemConexao( ) throws SQLException
	{
		return DriverManager.getConnection(
				"jdbc:mysql://localhost/ControlePredial?user=root&password=matheus" );

	}

}//Fim da classe