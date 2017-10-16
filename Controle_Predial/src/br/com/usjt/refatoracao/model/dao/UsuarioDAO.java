/**
 * Classe responsavel por fazer operações com a tabela de usuarios do banco de dados
 */
package br.com.usjt.refatoracao.model.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.usjt.refatoracao.model.bean.Usuario;

/**
 * @author Matheus Ribeiro Barbosa Santos e Samuel Alves de Almeida
 *
 */
public class UsuarioDAO 
{
	/**
	 *Contrutor Padrão
	 */
	public UsuarioDAO( )
	{

	}

	/**
	 *Método responsavel por validar o login
	 *@param Usuario usuario
	 *@return true or false
	 * @throws IOException 
	 */
	public boolean validar( Usuario usuario ) throws IOException
	{

		boolean sucesso = false;

		String sql = "select * from usuario where login = ? and senha = ?";

		try
		{
			Connection conn = ConnectionFactory.obtemConexao( );
			PreparedStatement st = conn.prepareStatement( sql );
			ResultSet rs = null;

			st.setString( 1 ,  usuario.getLogin( ) );
			st.setString( 2 ,  usuario.getSenha( ) );


			rs = st.executeQuery( );


			if( rs.next( ) )
			{			

				String login = rs.getString( 1 );
				String senha = rs.getString( 2 );
				
		
				//Aqui é feita uma comparação pois o sql nao é case sensitive, entao comparo o que é digitado com o resultado da pesquisa		
				if( login.equals( usuario.getLogin( ) ) && senha.equals( usuario.getSenha( ) ) )
				{
					sucesso = true;
				}
				st.close( );
				conn.close( );
			}		

		}
		catch( SQLException e )
		{
			e.printStackTrace( );
			System.out.println( e.getMessage( ) );
			throw new IOException( e );
		}
		return sucesso;
	}



}//Fim da clase