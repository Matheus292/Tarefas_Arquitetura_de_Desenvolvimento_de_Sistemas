/**
 *Classe responsavel por manter os dados das empresas no banco de dados
 */
package br.com.usjt.refatoracao.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.usjt.refatoracao.model.Empresa;

/**
 * @author Matheus Ribeiro Barbosa Santos e Samuel Alves de Almeida
 */

public class EmpresaDAO 
{

	/**
	 *Construtor Padrão
	 */
	public EmpresaDAO( )
	{
		
	}

	/**
	 *Responsavel por cadastrar a empresa
	 *@param empresa
	 *@return true , false
	 * @throws SQLException 
	 */
	public boolean cadastrar( Empresa empresa ) throws SQLException
	{
		Connection conexao = null;

		ConnectionFactory fabricaConexao = new ConnectionFactory( ); 

		String sql = "insert into Empresa values ( ? , ? , ? , ? , ? , ? )";

		PreparedStatement st = null ;

		conexao = fabricaConexao.obtemConexao( );

		//Força a transação
		conexao.setAutoCommit( false );

		st = conexao.prepareStatement( sql );
		st.setString( 1 , empresa.getCnpj( ) );
		st.setString( 2 , empresa.getRazaoSocial( ) );
		st.setString( 3 , empresa.getTelefone( ) );
		st.setString( 4 , empresa.getEndereco( ) );
		st.setString( 5 , empresa.getHorarioAbertura( ) );
		st.setString( 6 , empresa.getHorarioFechamento( ) );
		st.execute( );

		//Efetiva inclusão
		conexao.commit( );

		st.close( );//Fecha Statement
		conexao.close( );//Fecha conexao

		return true;
	}


	/**
	 *Responsavel por trazer os dados das empresas
	 *@return lista;
	 * @throws SQLException 
	 */
	public List<Empresa> consultar( ) throws SQLException
	{
		
		Connection conexao = null;
		ConnectionFactory fabricaConexao = new ConnectionFactory( );
		PreparedStatement st = null;
		ResultSet rs = null;
		String sql = "select * from empresa";

		List<Empresa> lista = new ArrayList< >( );

			conexao = fabricaConexao.obtemConexao( );

			st = conexao.prepareStatement( sql );

			rs = st.executeQuery( );

			while( rs.next( ) )
			{				
				Empresa e = new Empresa(  );
				e.setCnpj( rs.getString( "cnpj" ) );
				e.setRazaoSocial( rs.getString( "razaoSocial" ) );
				e.setEndereco( rs.getString( "endereco" ) );
				e.setTelefone( rs.getString( "telefone" ));
				e.setHorarioAbertura( rs.getString( "horarioAbertura" ) );
				e.setHorarioFechamento( rs.getString( "horarioFechamento" ) );

				lista.add( e );
			}
			st.close( );
			conexao.close( );
		
			return lista;
	}
	
	
	/**
	 *Responsavel por alterar a empresa no banco de dados 
	 *@param empresa
	 *@return true,false
	 */
	public boolean alterar( Empresa empresa ) throws SQLException
	{
		Connection conexao = null;
		ConnectionFactory fabricaConexao = new ConnectionFactory( );
		
		String sql = 
				"update empresa set  razaoSocial = ? , telefone = ? , endereco = ? , horarioAbertura = ? "
						+ ", horarioFechamento = ? where cnpj = ?";

		PreparedStatement st = null;

			conexao = fabricaConexao.obtemConexao( );


			//Força a transação
			conexao.setAutoCommit( false );

			st = conexao.prepareStatement( sql );

			st.setString( 1 ,  empresa.getRazaoSocial( ) );
			st.setString( 2 , empresa.getTelefone( ) );
			st.setString( 3 ,  empresa.getEndereco( ) );
			st.setString( 4 , empresa.getHorarioAbertura( ) );
			st.setString( 5 ,  empresa.getHorarioFechamento( ) );
			st.setString( 6  ,  empresa.getCnpj( ) );
			st.execute( );			

			//Efetiva transação
			conexao.commit( );		

			st.close( );
			conexao.close( );

			return true;
		}
	
	/**
	 *Responsavel por excluir a empresa no banco de dados
	 *@param empresa
	 *@return true,false
	 * @throws SQLException 
	 */
	public boolean excluir( Empresa empresa ) throws SQLException
	{
		Connection conexao = null;
		ConnectionFactory fabricaConexao =  new ConnectionFactory( );
		String sql = "delete from empresa where cnpj = ?";
		PreparedStatement st = null;

			conexao = fabricaConexao.obtemConexao( );

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