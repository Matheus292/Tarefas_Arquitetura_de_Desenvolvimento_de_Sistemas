/**
 * Classe que mantem os dados de controle de temperatura no banco de dados
 */
package br.com.usjt.refatoracao.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.usjt.refatoracao.model.ControleTemperatura;
import br.com.usjt.refatoracao.model.Empresa;

/**
 * @author Matheus Ribeiro Barbosa Santos e Samuel Alves de Almeida
 */
public class ControleTemperaturaDAO
{

	/**
	 *Construtor Padrão
	 */
	public ControleTemperaturaDAO( )
	{

	}

	/**
	 *Cadastra um novo controle de temperatura
	 * @param controleTemperatura , empresa
	 * @throws SQLException 
	 */
	public boolean cadastrar( ControleTemperatura controleTemperatura , Empresa empresa ) throws SQLException
	{

		Connection conexao = null;
		ConnectionFactory fabricaConexao = new ConnectionFactory( );

		String sql = "insert into ControleTemperatura ( temperaturaMaxima , horarioInicio , horarioFim , Empresa_cnpj ) values ( ? , ? , ? , ?  )";

		PreparedStatement st = null ;

		conexao = fabricaConexao.obtemConexao( );

		//Força a transação
		conexao.setAutoCommit( false );

		st = conexao.prepareStatement( sql );
		st.setShort( 1 , controleTemperatura.getTemperaturaMaxima( ) );
		st.setString( 2 ,  controleTemperatura.getHorarioInicial( ) );
		st.setString( 3 ,  controleTemperatura.getHorarioFinal( ) );
		st.setString( 4 ,  empresa.getCnpj( ) );
		st.execute( );
		conexao.commit( );

		st.close( );
		conexao.close( );

		return true;

	}

	/**
	 *Metodo que serve para consultar os controles de temeperatura
	 * @throws SQLException 
	 *@ return lista
	 */
	public List<ControleTemperatura> consultar( ) throws SQLException
	{
		List<ControleTemperatura> controle = new ArrayList< >( );

		ConnectionFactory fabricaConexao = new ConnectionFactory( );
		Connection conexao = null;
		ResultSet rs = null;
		PreparedStatement st = null;

		String sql = "select * from controletemperatura order by Empresa_Cnpj ASC";

		conexao = fabricaConexao.obtemConexao( );				

		st = conexao.prepareStatement( sql );
		rs = st.executeQuery( );



		while( rs.next( ) )
		{
			ControleTemperatura c = new ControleTemperatura( );
			c.setId( rs.getInt( 1 ) );
			c.setTemperaturaMaxima( rs.getShort( 2 ) );
			c.setHorarioInicial( rs.getString( 3 ) );
			c.setHorarioFinal( rs.getString( 4 ) );
			controle.add( c );
		}
		st.close( );
		conexao.close( );

		return controle;
	}

	/**
	 *Responsavel por alterar o controle de temperatura
	 *@param controleTemperatura
	 *@return true, false
	 */
	public boolean alterar( ControleTemperatura controleTemperatura , Empresa empresa ) throws SQLException
	{
		Connection conexao = null;
		ConnectionFactory fabricaConexao = new ConnectionFactory( );

		String sql = 
				"update ControleTemperatura set temperaturaMaxima = ? , horarioInicio = ? ,"
						+ "horarioFim = ?  where Empresa_cnpj = ?";

		PreparedStatement st = null;

		conexao = fabricaConexao.obtemConexao( );

		//Força a transação
		conexao.setAutoCommit( false );
		st = conexao.prepareStatement( sql );

		st.setShort( 1  , controleTemperatura.getTemperaturaMaxima( ) );
		st.setString( 2 ,  controleTemperatura.getHorarioInicial( ) );
		st.setString( 3 , controleTemperatura.getHorarioFinal( ));
		st.setString( 4 , empresa.getCnpj( ) );
		st.execute( );			

		//Efetiva inclusão
		conexao.commit( );


		st.close( );
		conexao.close( );

		return true;
	}	

	/**
	 *Responsavel por excluir o controle de temperatura no banco de dados
	 *@param controleTemperatura , empresa
	 *@return true,false
	 * @throws SQLException 
	 */
	public boolean excluir( Empresa empresa ) throws SQLException 
	{
		Connection conexao = null;
		ConnectionFactory banco = new ConnectionFactory( );
		String sql = "delete from ControleTemperatura where Empresa_cnpj = ?";
		PreparedStatement st = null;

			conexao = banco.obtemConexao( );

			//Força a transação
			conexao.setAutoCommit( false );

			st = conexao.prepareStatement( sql );

			st.setString( 1  ,  empresa.getCnpj( ) );
			st.execute( );			

			//Efetiva transação
			conexao.commit( );		

			st.close( );
			conexao.close( );

			return true;
	}
}//Fim da classe