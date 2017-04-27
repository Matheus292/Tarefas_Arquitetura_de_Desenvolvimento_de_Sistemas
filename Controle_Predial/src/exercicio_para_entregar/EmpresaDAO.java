package exercicio_para_entregar;

import java.sql.*;
import java.util.*;

public class EmpresaDAO
{
	//Atributos
	private Empresa empresa;
	private ArrayList<Empresa> empresas;

	//Construtor
	public EmpresaDAO( )
	{

	}


	//Cadastrar
	public boolean cadastrar( Empresa emp ) throws SQLException
	{
		empresa = emp;
		Connection conexao = null;
		AcessoBD acesso = new AcessoBD( );
		String sql = "insert into Empresa values ( ? , ? , ? , ? , ? , ? )";
		PreparedStatement st = null ;


		try
		{
			conexao = acesso.obtemConexao( );

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

			//st.close( );//Fecha Statement
			//conexao.close( );//Fecha conexao

			return true;
		}
		catch( Exception e )
		{
			
			return false;
		}finally{
			st.close( );//Fecha Statement
			conexao.close( );//Fecha conexao
		}	


		
	}


	//Consultar
	public ArrayList consultar( )
	{
		ArrayList<Object> dados;
		
		Connection conexao = null;
		AcessoBD acesso = new AcessoBD( );
		PreparedStatement st = null;
		ResultSet rs = null;
		String sql = "select * from empresa";

		empresas = new ArrayList<Empresa>( );		
		dados = new ArrayList( );

		try
		{
			conexao = acesso.obtemConexao( );

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

				empresas.add( e );

				dados.add( new Object[ ]{ rs.getString( "cnpj" ) , rs.getString( "razaoSocial" ) } );
			}
			st.close( );
			conexao.close( );


		}
		catch( Exception e )
		{

		}


		return dados;
	}

	public ArrayList<Empresa> getEmpresas( )
	{
		return empresas;
	}


	public String consultar( String cpf )
	{
		Connection conexao = null;
		AcessoBD acesso = new AcessoBD( );
		PreparedStatement st = null;
		ResultSet rs = null;
		String sql = "select Empresa_cnpj from funcionario where cpf = ?";
		String retorno = "todos";

		try
		{
			conexao = acesso.obtemConexao( );

			st = conexao.prepareStatement( sql );
			st.setString( 1 , cpf );


			rs = st.executeQuery( );

			if( rs.next( ) )
			{
				retorno = rs.getString( "Empresa_cnpj" ) ;
			}
			st.close( );
			conexao.close( );
		}
		catch( Exception e )
		{
			System.out.println( "Erro aqui " + e.getMessage());	
		}
		return retorno;
	}




	//Alterar dados da empresa
	public boolean alterar( Empresa empresa , String cnpj ) throws SQLException
	{
		Connection conexao = null;
		AcessoBD banco = new AcessoBD( );
		String sql = 
				"update empresa set cnpj = ? , razaoSocial = ? , telefone = ? , endereco = ? , horarioAbertura = ? "
						+ ", horarioFechamento = ? where cnpj = ?";

		PreparedStatement st = null;

		try
		{			
			conexao = banco.obtemConexao( );


			//Força a transação
			conexao.setAutoCommit( false );

			st = conexao.prepareStatement( sql );

			st.setString( 1  ,  empresa.getCnpj( ) );
			st.setString( 2 ,  empresa.getRazaoSocial( ) );
			st.setString( 3 , empresa.getTelefone( ) );
			st.setString( 4 ,  empresa.getEndereco( ) );
			st.setString( 5 , empresa.getHorarioAbertura( ) );
			st.setString( 6 ,  empresa.getHorarioFechamento( ) );
			st.setString( 7 , cnpj );			
			st.execute( );			

			//Efetiva transação
			conexao.commit( );		
			
			st.close( );
			conexao.close( );
			
			return true;
		}
		catch( Exception e )
		{
			e.printStackTrace();
			
		}finally{
			st.close( );//Fecha Statement
			conexao.close( );//Fecha conexao
			
		}	
		return false;
	}


	//Deletar empresa
	public boolean excluir( String cnpj ) throws SQLException
	{
		Connection conexao = null;
		AcessoBD banco = new AcessoBD( );
		String sql = "delete from empresa where cnpj = ?";
		PreparedStatement st = null;

		try
		{			
			conexao = banco.obtemConexao( );

			//Força a transação
			conexao.setAutoCommit( false );

			st = conexao.prepareStatement( sql );

			st.setString( 1  ,  cnpj );
			st.executeUpdate( );			

			//Efetiva transação
			conexao.commit( );		

			st.close( );
			conexao.close( );

			return true;
		}
		catch( Exception e )
		{
			e.printStackTrace();
		}finally{
				st.close( );//Fecha Statement
				conexao.close( );//Fecha conexao
				
			}	
			return false;

	}
}//Fim da classe