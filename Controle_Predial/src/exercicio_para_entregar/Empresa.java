package exercicio_para_entregar;


import java.sql.SQLException;
import java.util.*;


public class Empresa 
{
	//Atributos
	private String cnpj , razaoSocial , endereco , telefone ;
	private String horarioAbertura , horarioFechamento ;
	private EmpresaDAO emp;


	//Construtor
	public Empresa( ) 
	{
		emp = new EmpresaDAO( );	
	}
	
	
	
	
	
	
	public void setEmpresa(String cnpj, String razaoSocial, String endereco, String telefone, String horarioAbertura,
			String horarioFechamento) {
		
		this.cnpj = cnpj;
		this.razaoSocial = razaoSocial;
		this.endereco = endereco;
		this.telefone = telefone;
		this.horarioAbertura = horarioAbertura;
		this.horarioFechamento = horarioFechamento;
		
	}






	//Sets
	public void setCnpj( String cnpj )
	{
		this.cnpj = cnpj ;
	}

	public void setRazaoSocial( String razaoSocial )
	{
		this.razaoSocial = razaoSocial;
	}

	public void setEndereco( String endereco )
	{
		this.endereco = endereco;
	}

	public void setTelefone( String telefone )
	{
		this.telefone = telefone;
	}

	public void setHorarioAbertura( String hora )
	{
		this.horarioAbertura = hora; 
	}

	public void setHorarioFechamento( String hora )
	{
		this.horarioFechamento = hora;
	}

	//Gets
	public String getCnpj( )
	{
		return cnpj;
	}

	public String getRazaoSocial( )
	{
		return razaoSocial;
	}

	public String getEndereco( )
	{
		return endereco;
	}

	public String getTelefone( )
	{
		return telefone;
	}

	public String getHorarioAbertura( )
	{
		return horarioAbertura;	
	}

	public String getHorarioFechamento( )
	{
		return horarioFechamento;
	}


	//*************************************** Metodos que fazem as operações do sistema *********************** 

	//Metodo Cadastrar
	public boolean cadastrar( Empresa e ) throws SQLException
	{
		return emp.cadastrar( e );
	}

	//Metodo consultar
	public ArrayList consultar( )
	{
		ArrayList< Object > empresa; 
		empresa =  emp.consultar( );		
		return empresa;	
	}

	public ArrayList<Empresa> retornaDados( )
	{
		return emp.getEmpresas( );
	}

	public String consultar( String cpf )
	{
		return emp.consultar( cpf );
	}	
	
	//Metodo que altera
	public boolean alterar( Empresa e , String x ) throws SQLException
	{
		return emp.alterar( e , x );
	}

	//Excluir empresa
	public boolean excluir( String cnpj ) throws SQLException
	{
		return emp.excluir( cnpj );
	}
	
}//Fim da classe
