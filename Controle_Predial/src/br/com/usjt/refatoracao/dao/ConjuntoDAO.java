/**
 *Classe Responsavel por manter os dados dos conjuntos no banco de dados 
 */
package br.com.usjt.refatoracao.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

import br.com.usjt.refatoracao.model.Conjunto;
import br.com.usjt.refatoracao.model.Empresa;

/**
 * @author Matheus Ribeiro Barbosa Santos e Samuel Alves de Almeida
 */
public class ConjuntoDAO 
{
	/**
	 *Construtor Padrão
	 */
	public ConjuntoDAO( )
	{

	}

	/**
	 *Responsavel por mostrar todos os conjuntos pertecentes a alguma empresa
	 *@param empresa
	 *@return conjuntos
	 * @throws SQLException 
	 */
	public Conjunto consultarConjuntoOcupado( Empresa empresa ) throws SQLException
	{
		PreparedStatement st = null;
		ResultSet rs = null;

		Conjunto conjunto = new Conjunto( );

		ConnectionFactory fabricaConexao = new ConnectionFactory( );
		Connection conexao = null;
		

			String sql = "select * from conjunto where Empresa_cnpj = ? ";
			conexao = fabricaConexao.obtemConexao( );
			
			st = conexao.prepareStatement( sql );
			st.setString( 1 , empresa.getCnpj( ) );
			
			rs = st.executeQuery( );

			if( rs.next( ) )
			{
				conjunto.setId( rs.getInt( 1 ) );
				conjunto.setDisponibilidade( rs.getBoolean( 2 ) );
			}

				st.close( );
				conexao.close( );

		return conjunto;
	}

	
	
	/**
	 *Metodo por retornar todos os Conjuntos desocupados
	 * @throws SQLException 
	 */
	public List<Conjunto> consultarConjuntoDesocupado( ) throws SQLException
	{
		PreparedStatement st = null;
		ResultSet rs = null;
		String sql = "select * from conjunto where disponibilidade = true";

		List<Conjunto> conjuntos = new Vector<>( );
		ConnectionFactory fabricaConexao = new ConnectionFactory( );

		Connection conexao = null;

		conexao = fabricaConexao.obtemConexao( );
		st = conexao.prepareStatement( sql );
		rs = st.executeQuery( );

		while( rs.next( ) )
		{
			Conjunto c = new Conjunto( );

			c.setId( rs.getInt( "id" ) );
			c.setDisponibilidade( rs.getBoolean( "disponibilidade" ) );

			conjuntos.add( c );
		}
		st.close( );
		conexao.close( );

		return conjuntos;

	}

	/**
	 *Metodo responsavel por alterar os dados do conjunto no banco de dados
	 *@param conjuntos , empresa
	 * @throws SQLException 
	 */
	public boolean ocuparConjuntos( List<Conjunto> conjuntos , Empresa empresa ) throws SQLException
	{
		Connection conexao = null;
		PreparedStatement st = null;
		ConnectionFactory fabricaConexao = new ConnectionFactory( );

		if( conjuntos.size( ) != 0 )
		{
			for( Conjunto conjunto : conjuntos )
			{
				String sql = "update Conjunto set Empresa_cnpj = ? , disponibilidade = false where id = ?";
				conexao = fabricaConexao.obtemConexao( );

				st = conexao.prepareStatement( sql );
				st.setString( 1 , empresa.getCnpj( ) );
				st.setInt( 2 , conjunto.getId( ) );
				st.execute( );				

			}

			st.close( );
			conexao.close( );
		}
		return true;
	}

	/**
	 *Metodo responsavel por alterar os dados do conjunto no banco de dados
	 *@param conjuntos 
	 * @throws SQLException
	 * @return true,false 
	 */
	public boolean desocuparConjuntos( List<Conjunto> conjuntos ) throws SQLException
	{
		Connection conexao = null;
		PreparedStatement st = null;
		ConnectionFactory fabricaConexao = new ConnectionFactory( );

		if( conjuntos.size( ) != 0 )
		{

			for( Conjunto conjunto : conjuntos )
			{
				String sql = "update Conjunto set Empresa_cnpj = null , disponibilidade = true where id = ?";
				conexao = fabricaConexao.obtemConexao( );

				st = conexao.prepareStatement( sql );
				st.setInt( 1 , conjunto.getId( ) );
				st.execute( );				

			}

			st.close( );
			conexao.close( );
		}
		return true;
	}


	/**
	 *Responsavel por mostrar todos os conjuntos pertecentes a alguma empresa
	 *@param empresa
	 *@return conjuntos
	 * @throws SQLException 
	 */
	public List<List<Conjunto>> consultarConjuntoOcupado( List<Empresa> empresa ) throws SQLException
	{
		PreparedStatement st = null;
		ResultSet rs = null;

		List<List<Conjunto>> conjuntos = new Vector< >( );

		ConnectionFactory fabricaConexao = new ConnectionFactory( );
		Connection conexao = null;

		for( Empresa e : empresa )
		{

			String sql = "select * from conjunto where Empresa_cnpj = ? ";
			conexao = fabricaConexao.obtemConexao( );
			st = conexao.prepareStatement( sql );
			st.setString( 1 , e.getCnpj( ) );
			rs = st.executeQuery( );

			List<Conjunto> lista = new Vector< >( );

			while( rs.next( ) )
			{
				Conjunto c = new Conjunto( );
				c.setId( rs.getInt( 0 ) );
				c.setDisponibilidade( rs.getBoolean( 1 ) );
				lista.add( c );
			}
			conjuntos.add( lista );

		}
		st.close( );
		conexao.close( );

		return conjuntos;
	}
}//Fim da classe