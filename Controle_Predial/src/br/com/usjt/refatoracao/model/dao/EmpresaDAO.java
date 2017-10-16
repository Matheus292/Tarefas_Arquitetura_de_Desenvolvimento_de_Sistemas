/**
 *Classe responsavel por manter os dados das empresas no banco de dados
 */
package br.com.usjt.refatoracao.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.usjt.refatoracao.model.bean.Empresa;

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

			String sql = "insert into Empresa values ( ? , ? , ? , ? , ? , ? )";

		PreparedStatement st = null ;

		conexao = ConnectionFactory.obtemConexao( );

		//Força a transação
		conexao.setAutoCommit( false );

		st = conexao.prepareStatement( sql );
		st.setString( 1 , empresa.getCnpj( ) );
		st.setString( 2 , empresa.getRazaoSocial( ) );
		st.setString( 4 , empresa.getTelefone( ) );
		st.setString( 3 , empresa.getEndereco( ) );
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
		PreparedStatement st = null;
		ResultSet rs = null;
		String sql = "select * from empresa";

		List<Empresa> lista = new ArrayList< >( );

		conexao = ConnectionFactory.obtemConexao( );

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
	
		String sql = 
				"update empresa set  razaoSocial = ? , telefone = ? , endereco = ? , horarioAbertura = ? "
						+ ", horarioFechamento = ? where cnpj = ?";

		PreparedStatement st = null;

		conexao = ConnectionFactory.obtemConexao( );


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
		
		String sql = "delete from empresa where cnpj = ?";
		PreparedStatement st = null;

		conexao = ConnectionFactory.obtemConexao( );

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

	public boolean excluirPorCnpj( String cnpj ) throws SQLException
	{
		Connection conexao = null;
		
		String sql = "delete from empresa where cnpj = ?";
		PreparedStatement st = null;

		conexao = ConnectionFactory.obtemConexao( );

		//Força a transação
		conexao.setAutoCommit( false );

		st = conexao.prepareStatement( sql );

		st.setString( 1  ,  cnpj );
		st.execute( );			

		//Efetiva transação
		conexao.commit( );		

		st.close( );
		conexao.close( );

		return true;

	}

	public Empresa consultar( String cnpj) throws SQLException
	{

		Connection conexao = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		String sql = "select * from empresa where cnpj = ?";

		Empresa e = new Empresa(  );
		conexao = ConnectionFactory.obtemConexao( );

		//Força a transação
		conexao.setAutoCommit( false );

		st = conexao.prepareStatement( sql );

		st.setString( 1  ,  cnpj );

		rs = st.executeQuery( );

		if(rs.next()){

			e.setCnpj( rs.getString( "cnpj" ) );
			e.setRazaoSocial( rs.getString( "razaoSocial" ) );
			e.setEndereco( rs.getString( "endereco" ) );
			e.setTelefone( rs.getString( "telefone" ));
			e.setHorarioAbertura( rs.getString( "horarioAbertura" ) );
			e.setHorarioFechamento( rs.getString( "horarioFechamento" ) );

		}

		st.close( );
		conexao.close( );

		return e;
	}


}//Fim da classe