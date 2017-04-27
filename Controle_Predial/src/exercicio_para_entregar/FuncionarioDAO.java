package exercicio_para_entregar;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ArrayList;
import javax.swing.*;

public class FuncionarioDAO
{
	//Atributos
	private ArrayList<Funcionario> todos;
	private ArrayList<String>  consulta = new ArrayList<String>( );

	//Cosntrutor
	public FuncionarioDAO( )
	{

	}

	//Cadastrar
	public boolean cadastrar( Funcionario f , String cnpj )
	{
		Connection conexao = null;
		AcessoBD acesso = new AcessoBD( );
		String sql = "insert into funcionario ( cpf , nome , endereco , telefone, "
				+ " dataNascimento , alteraTemperatura , "
				+ "Empresa_cnpj )" + "  values ( ? , ? , ? , ? , ? , ? , ? )";
		PreparedStatement st = null ;


		try
		{
			conexao = acesso.obtemConexao( );

			//Força a transação
			conexao.setAutoCommit( false );
			SimpleDateFormat formato = new SimpleDateFormat( "YYYY-MM-dd" );

			st = conexao.prepareStatement( sql );
			st.setString( 1 , f.getCpf( ) );
			st.setString( 2 , f.getNome( ) );
			st.setString( 3 , f.getEndereco( ) );
			st.setString( 4 , f.getTelefone( ) );
			st.setString( 5 , formato.format(  f.getDataNascimento( ) ) );
			st.setBoolean( 6 , f.getAlteraTemperatura( )  );
			st.setString( 7 , cnpj );
			st.execute( );

			//Efetiva inclusão
			conexao.commit( );

			st.close( );//Fecha Statement
			conexao.close( );//Fecha conexao

			return true;
		}
		catch( Exception e )
		{
System.err.println( e.getMessage( ) );
		}	
		return false;
	}


	//Consultar
	public ArrayList consultar( )
	{
		Connection conexao = null;
		AcessoBD acesso = new AcessoBD( );
		PreparedStatement st = null;
		ResultSet rs = null;
		String sql = "select * from funcionario order by cpf asc";

		todos = new ArrayList<Funcionario>( );		
		ArrayList  dados = new ArrayList( );

		try
		{
			conexao = acesso.obtemConexao( );

			st = conexao.prepareStatement( sql );

			rs = st.executeQuery( );

			Date s = new Date( );

			while( rs.next( ) )
			{				
				Funcionario e = new Funcionario(  );
				e.setCpf( rs.getString( "cpf" ) );
				e.setNome( rs.getString( "nome" ) );
				e.setEndereco( rs.getString( "endereco" ) );
				e.setTelefone( rs.getString( "telefone" ));
				e.setDataNascimento( rs.getDate( "dataNascimento" ) );
				e.setAlteraTemperatura( rs.getBoolean( "alteraTemperatura" ) );
				e.setCnpj( rs.getString( "Empresa_Cnpj" ) );
				todos.add( e );

				dados.add( new Object[ ]{ rs.getString( "cpf" ) , rs.getString( "nome" ) } );
			}
			st.close( );
			conexao.close( );


		}
		catch( Exception e )
		{
			System.out.println( e.getMessage());	
		}

		return dados;
	}

	public ArrayList<String> consultar( String cnpj )
	{
		Connection conexao = null;
		AcessoBD acesso = new AcessoBD( );
		PreparedStatement st = null;
		ResultSet rs = null;
		String sql = "select * from funcionario where Empresa_cnpj = ?";
		consulta = new ArrayList<String>( );

		try
		{
			conexao = acesso.obtemConexao( );

			st = conexao.prepareStatement( sql );
			st.setString( 1 ,  cnpj );


			rs = st.executeQuery( );


			while( rs.next( ) )
			{

				consulta.add( rs.getString( "cpf" ) );
			}
			st.close( );
			conexao.close( );


		}
		catch( Exception e )
		{
		}

		return consulta;
	}


	public ArrayList<Funcionario> getTodos( )
	{
		return todos;
	}

	
	//Alterar
	public boolean alterar( Funcionario f , String cnpj )
	{
		Connection conexao = null;
		AcessoBD banco = new AcessoBD( );
		String sql = 
				"update funcionario set cpf = ? , nome = ? , endereco = ? , telefone = ? , dataNascimento = ? "
						+ ", alteraTemperatura = ? , Empresa_cnpj = ? where cpf = ?";

		PreparedStatement st = null;

		try
		{			
			conexao = banco.obtemConexao( );


			//Força a transação
			conexao.setAutoCommit( false );
			SimpleDateFormat formato = new SimpleDateFormat( "YYYY-MM-dd" );


			st = conexao.prepareStatement( sql );

			st.setString( 1 , f.getCpf( ) );
			st.setString( 2 ,  f.getNome( ) );
			st.setString( 3  , f.getEndereco( ) );
			st.setString( 4 , f.getTelefone( ) );
			st.setString( 5 , formato.format( f.getDataNascimento( ) ) );
			st.setBoolean( 6 ,  f.getAlteraTemperatura( ) );
			st.setString( 7 ,  cnpj );
			st.setString( 8 ,  f.getCpf( ) );
			st.execute( );			

			//Efetiva transação
			conexao.commit( );		

			st.close( );
			conexao.close( );

			return true;
		}
		catch( Exception e )
		{
			System.out.println( "Erro aqui no FuncionarioDAO:" + e.getMessage( ) );
			return false;
		}
	}

	//Excluir
	public boolean excluir( String cpf  )
	{
		Connection conexao = null;
		AcessoBD banco = new AcessoBD( );
		String sql = "delete from funcionario where cpf = ?";
		PreparedStatement st = null;

		try
		{			
			conexao = banco.obtemConexao( );

			//Força a transação
			conexao.setAutoCommit( false );

			st = conexao.prepareStatement( sql );

			st.setString( 1  ,  cpf );
			st.execute( );			

			//Efetiva transação
			conexao.commit( );		

			st.close( );
			conexao.close( );

			return true;
		}
		catch( Exception e )
		{
			System.out.println( e.getMessage( ) );
			return false;
		}

	}

	public boolean excluir( String cnpj , String nada )
	{
		Connection conexao = null;
		AcessoBD banco = new AcessoBD( );
		String sql = "delete from funcionario where Empresa_cnpj = ?";
		PreparedStatement st = null;

		try
		{			
			conexao = banco.obtemConexao( );

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
		catch( Exception e )
		{
			System.out.println( e.getMessage( ) );
			return false ;
		}

	}
}//Fim da classe