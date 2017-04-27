package exercicio_para_entregar;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder( MethodSorters.NAME_ASCENDING ) 

public class FuncionarioTest 
{

	Funcionario funcionario , funcionario1 ;
	
	@Before
	public void setUp( )
	{
		funcionario = new Funcionario( );
		funcionario.setCpf( "13345678901");
		funcionario.setNome( "João Pedro" );
		funcionario.setTelefone( "( 11 ) 2345 - 4323" );
		funcionario.setEndereco( "Rua dos bobos , 0" );
		funcionario.setAlteraTemperatura( true );
		funcionario.setDataNascimento( new Date( ) );
		
		
		funcionario1 = new Funcionario( );
		funcionario1.setCpf( "13345678901");
		funcionario1.setNome( "João Pedro" );
		funcionario1.setTelefone( "( 11 ) 2345 - 4323" );
		funcionario1.setEndereco( "Rua dos bobos , 0" );
		funcionario1.setAlteraTemperatura( true );
		//funcionario1.setPerfil( 1 );
		funcionario1.setDataNascimento( new Date( ) );
		
	} 
	
	
	//Este método testa se o funcionario foi cadastrado
	@Test
	public void test00Cadastrar( )
	{
		assertTrue( "O metodo deve conseguir inserir o funcionario" , funcionario.cadastrar( funcionario , "23456789012345") );
	}
	
	
	//Este metodo vera se existe funcionarios cadastrados no banco de dados
	@Test
	public void test01Consultar( )
	{
		assertNotNull( "A consulta deverá trazer algo" , funcionario.consultar( ) );
	}
	
	//Este metodo altera o endereco do funcionario e deve retornar true
	@Test
	public void test02Alterar( )
	{
		funcionario.setEndereco( "Rua Taquari, 213");
		assertTrue( "O método deverá alterar e retornar true" , funcionario.alterar( funcionario , "23456789012345") );
	}
	
	//Este metodo exclui o funcionario do banco de dados
	@Test
	public void test03Excluir( )
	{
		assertTrue( "O método deverá excluir e retornar true" , funcionario.excluir( "13345678901" ) );
	}
	
	@Test
	public void test05Iguais( )
	{		
		assertEquals( "Os objetos deverão ser iguais" , funcionario , funcionario1 ) ;
	}
	
	

}
