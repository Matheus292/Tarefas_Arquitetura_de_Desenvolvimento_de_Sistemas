/**
 * Responsavel por salvar as alterações feitas
 */
package br.com.usjt.refatoracao.controller.command;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.usjt.refatoracao.model.bean.Conjunto;
import br.com.usjt.refatoracao.model.bean.ControleTemperatura;
import br.com.usjt.refatoracao.model.bean.Empresa;
import br.com.usjt.refatoracao.model.service.ConjuntoService;
import br.com.usjt.refatoracao.model.service.ControleTemperaturaService;
import br.com.usjt.refatoracao.model.service.EmpresaService;

/**
 * @author Matheus Ribeiro Barbosa Santos e Samuel Alves de Almeida
 *
 */
public class SalvarAlteracao implements Command
{

	@Override
	public void executar( HttpServletRequest request , HttpServletResponse response ) throws ServletException , IOException
	{
		RequestDispatcher dispatcher = null ;

		//Instancia os Java Beans
		Empresa empresa = new Empresa( );
		ControleTemperatura controle = new ControleTemperatura( );
		Conjunto conjunto = new Conjunto( );


		//Instancia os Services
		EmpresaService servicoEmpresa = new EmpresaService( );
		ControleTemperaturaService servicoControle = new ControleTemperaturaService( );
		ConjuntoService servicoConjunto = new ConjuntoService( );



		String cnpj = request.getParameter( "cnpj" );
		String razao = request.getParameter( "razao" );
		String endereco = request.getParameter( "endereco" );
		String telefone = request.getParameter( "fone" );
		String horarioInicial = request.getParameter( "horarioInicial" );
		String horarioFinal = request.getParameter( "horarioFinal" );
		String arHorarioInicial = request.getParameter( "arHorarioInicial" );
		String arHorarioFinal = request.getParameter( "arHorarioFinal" );
		short temperatura = Short.parseShort( request.getParameter( "temperatura" ) );
		String[ ] conj = request.getParameterValues( "CONJUNTO" );

		empresa.setCnpj( cnpj );
		empresa.setRazaoSocial( razao );
		empresa.setEndereco( endereco );
		empresa.setTelefone( telefone );
		empresa.setHorarioAbertura( horarioInicial );
		empresa.setHorarioFechamento( horarioFinal );

		controle.setTemperaturaMaxima( temperatura );
		controle.setHorarioInicial( arHorarioInicial );
		controle.setHorarioFinal( arHorarioFinal );

		List< Conjunto > lista = new ArrayList< >( );

		for( String x : conj )
		{

			conjunto.setId( Integer.parseInt( x ) );
			lista.add( conjunto );
		}

		try 
		{
			servicoEmpresa.alterar( empresa );
			servicoControle.alterar( controle , empresa );
			servicoConjunto.desocuparConjuntos( empresa.getCnpj( ) );
			servicoConjunto.ocuparConjuntos( lista , empresa );

			request.setAttribute( "empresa" , empresa );
			request.setAttribute( "controle" , controle );
			request.setAttribute( "lista" , lista );			

			dispatcher = request.getRequestDispatcher( "redirecionamento.jsp" );
			dispatcher.forward( request , response );

		}
		catch( SQLException sql )
		{
			dispatcher = request.getRequestDispatcher( "erro.jsp" );
			dispatcher.forward( request , response );

		}


	}

}
