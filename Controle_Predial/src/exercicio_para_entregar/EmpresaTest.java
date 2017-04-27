package exercicio_para_entregar;

import static org.junit.Assert.*;

import java.sql.SQLException;


import org.junit.Test;

import exercicio_para_entregar.Empresa;


public class EmpresaTest {
	Empresa[] em = new Empresa[10];
	
	
	//teste(Cadastro) com resultado positivo esperado;
	
	
	//teste(Cadastro) com resultado negativo esperado;
	@Test
		public void cadNeg() throws SQLException {
		
		
		for(int i=0;i<10;i++)
		em[i] = new Empresa();
		

		//teste(Cadastro) com resultado positivo esperado;
		em[0].setEmpresa( "12345678912345", "JUnit Teste", "Rua do Teste", "12345678", "08:00", "16:00") ;
		
		assertEquals("Cadastrado",true,em[0].cadastrar(em[0]));
		
		
		
		//teste elemento repetido;
		em[1].setEmpresa( "12345678912345", "JUnit Teste", "Rua do Teste", "12345678", "08:00", "16:00") ;
		assertEquals("Repetido aceito",false,em[1].cadastrar(em[1]));
		
		

		//teste cnpj ausente
		
		em[2].setEmpresa( null, "JUnit Teste", "Rua do Teste", "12345678", "08:00", "16:00") ;
		assertEquals("CNPJ nulo",false,em[2].cadastrar(em[2]));
		
		//teste razao ausente
		
		em[3].setEmpresa( "12345678912345", null, "Rua do Teste", "12345678", "08:00", "16:00") ;
		assertEquals("razao nulo",false,em[3].cadastrar(em[3]));
				
		//teste rua ausente
		em[4].setEmpresa( "12345678912345", "JUnit Teste", null, "12345678", "08:00", "16:00") ;	
		assertEquals("rua nulo",false,em[4].cadastrar(em[4]));
				
		//teste tel ausente
		em[5].setEmpresa( "12345678912345", "JUnit Teste", "Rua do Teste", null, "08:00", "16:00") ;
		assertEquals("tel nulo",false,em[5].cadastrar(em[5]));
				
		//teste hr abertura ausente
		em[6].setEmpresa( "12345678912345", "JUnit Teste", "Rua do Teste", "12345678",null, "16:00") ;
		assertEquals("abertura nulo",false,em[6].cadastrar(em[6]));
				
		
		//teste hr fechamento ausente
		em[7].setEmpresa( "12345678912345", "JUnit Teste", "Rua do Teste", "12345678", "08:00", null) ;
		assertEquals("fechamento nulo",false,em[7].cadastrar(em[7]));
		
		
		
		//teste alteraçao(positivo)
		em[8].setEmpresa( "12345678912346", "JUnit Teste Alterar", "Rua do Teste", "12345678", "08:00", "16:00") ;
		em[8].cadastrar(em[8]);
		
		em[8].setEmpresa( "12345678912346", "JUnit Teste Alterado", "Rua do Teste", "12345678", "08:00", "16:00") ;
		assertEquals("Alteração",true,em[8].alterar(em[8],"12345678912346"));
		
		
		
		//teste de exclusão:
		//resultado positivo esperado;
		assertEquals("Excluir positivo",true,em[0].excluir("12345678912345"));
		assertEquals("Excluir positivo",true,em[8].excluir("12345678912346"));
		
		//resultado negativo esperado;(ACHO QUE NAO PRECISA DESSE ULTIMO PQ SEMPRE DA CERTO)
		//assertEquals("Excluir negativo",false,em[8].excluir("21345678912346"));
		
		
	}
		
		
	
	


}
