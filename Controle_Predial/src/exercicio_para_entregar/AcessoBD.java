package exercicio_para_entregar;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class AcessoBD 
{
	//carrega o driver
	static
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
		}
		catch (ClassNotFoundException e)
		{
			throw new RuntimeException(e);
		}
	}	 

	// Obtém conexão com o banco de dados
	public Connection obtemConexao( ) throws SQLException
	{
		try
		{

			return DriverManager.getConnection(
					"jdbc:mysql://localhost/ProjetoIntegrado?user=root&password=matheus" );

		}
		catch( Exception e )
		{
			JOptionPane.showMessageDialog( null , "ERR: N - - >BD" , "ERR" , 0 );
			return null;
		}
	}
}