package exercicio_para_entregar;

import java.util.ArrayList;
import java.util.Date;

public class Funcionario 
{


	//Atributos 
	private String cpf , nome , endereco , telefone , cnpj ;
	private Date dataNascimento ;
	private boolean alteraTemperatura ;
	private FuncionarioDAO dao;

	//Construtor
	public Funcionario( )
	{
		dao = new FuncionarioDAO( );
	}

	//Sets
	public void setCpf( String cpf )
	{
		this.cpf = cpf ;
	}

	public void setNome( String nome )
	{
		this.nome = nome;
	}

	public void setEndereco( String endereco )
	{
		this.endereco = endereco;
	}

	public void setTelefone( String telefone )
	{
		this.telefone = telefone;
	}

	public void setDataNascimento( Date data )
	{
		this.dataNascimento = data;
	}

	public void setAlteraTemperatura( boolean altera )
	{
		this.alteraTemperatura = altera;
	}
	
	public void setCnpj( String cnpj )
	{
		this.cnpj = cnpj;
	}
	
	
	//Gets
	public String getCpf( )
	{
		return cpf;
	}

	public String getNome( )
	{
		return nome;
	}

	public String getEndereco( )
	{
		return endereco;
	}

	public String getTelefone( )
	{
		return telefone;
	}

	public Date getDataNascimento( )
	{
		return dataNascimento;
	}

	public boolean getAlteraTemperatura( )
	{
		return alteraTemperatura;
	}
	
	public String getCnpj( )
	{
		return cnpj;
	}
	
	/**********************Cadastrar Funcionario*************************/
	public boolean cadastrar( Funcionario f  , String cnpj )
	{
		return dao.cadastrar( f  , cnpj );
				
	}
	
	/***********************Consultar Funcionario************************/
	public ArrayList consultar(  )
	{
		return dao.consultar( );
	}
	
	public ArrayList<Funcionario> todosFuncionarios( )
	{
		return dao.getTodos( );
	}
	
	public ArrayList<String> consultar( String cnpj )
	{
		return dao.consultar( cnpj );
	}
	
		
	
	/**********************Alterar Funcionario*******************************/
	public boolean alterar( Funcionario f , String cnpj )
	{
		return dao.alterar( f , cnpj );
	}

	/**********************Deletar Funcionario********************************/
	public boolean excluir( String cpf )
	{
		return dao.excluir( cpf );
	}
	
	public boolean excluir( String cnpj , String cpf )
	{
		return dao.excluir( cnpj , cpf );
	}

	//Equals
	@Override
	public boolean equals( Object obj ) 
	{
		if ( this == obj )
			return true;
		if ( obj == null )
			return false;
		if ( getClass( ) != obj.getClass( ) )
			return false;
		Funcionario other = ( Funcionario ) obj;
		if ( cpf == null ) 
		{
			if ( other.cpf != null )
				return false;
		} 
		else 
			if ( !cpf.equals( other.cpf ) )
			return false;
		if ( endereco == null )
		{
			if ( other.endereco != null )
				return false;
		} 
		else
			if ( !endereco.equals( other.endereco ) )
			return false;
		if ( nome == null )
		{
			if ( other.nome != null )
				return false;
		}
		else 
			if ( !nome.equals( other.nome ) )
			return false;
		return true;
	}
	
	
	
	
}