package br.com.usjt.refatoracao.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.usjt.refatoracao.controller.json.JSonFacade;
import br.com.usjt.refatoracao.model.bean.Conjunto;
import br.com.usjt.refatoracao.model.bean.ControleTemperatura;
import br.com.usjt.refatoracao.model.bean.Empresa;
import br.com.usjt.refatoracao.model.service.ConjuntoService;
import br.com.usjt.refatoracao.model.service.ControleTemperaturaService;
import br.com.usjt.refatoracao.model.service.EmpresaService;

/**
 * Servlet implementation class ServicoManterEmpresa
 */
@WebServlet( "/Empresa" )
public class ServicoManterEmpresa extends HttpServlet 
{
	private static final long serialVersionUID = 1L;

	/**
	 *Responsavel por configurar a request e a response para os outros metodos 
	 */
	@Override
	protected void service( HttpServletRequest request , HttpServletResponse response ) throws ServletException , IOException
	{
		request.setCharacterEncoding( "UTF-8" );
		response.setContentType( "application/json" );   
		response.setCharacterEncoding( "UTF-8" );  
		super.service( request , response );  
	}


	/**
	 * Listar Empresas
	 */
	@Override
	protected void doGet( HttpServletRequest request , HttpServletResponse response ) throws ServletException , IOException 
	{
		EmpresaService empresaServico = new EmpresaService( );
		ControleTemperaturaService temperaturaServico = new ControleTemperaturaService( );
		ConjuntoService conjuntoService = new ConjuntoService( );

		List< Empresa > empLista = new ArrayList< >( ); 
		List< ControleTemperatura > tempLista = new ArrayList< >( );
		List< Conjunto >conjLista = new ArrayList< >( );

		PrintWriter out = response.getWriter( );
		
		try
		{
			empLista = empresaServico.consultar( );
			tempLista = temperaturaServico.consultar( );

			for( Empresa empresa : empLista )
			{
				Conjunto c = conjuntoService.consultarConjuntoOcupado( empresa );
				conjLista.add( c );
			}
			out.println( JSonFacade.mostraDados( empLista , tempLista , conjLista ) );		
		}
		catch( Exception e )
		{
			e.printStackTrace( );
		}


	}


	/**
	 * Adicionar Empresa
	 */
	@Override
	protected void doPost( HttpServletRequest request , HttpServletResponse response ) throws ServletException , IOException 
	{
		StringBuilder sb = JSonFacade.montaJSon( request );
		PrintWriter out = response.getWriter( );

		try
		{
			//Instancia objetos 
			Empresa empresa = JSonFacade.jSonToEmpresa( sb.toString( ) );
			ControleTemperatura controle = JSonFacade.jSonToControle( sb.toString( ) );
			Conjunto conjunto = JSonFacade.jSonToConjunto( sb.toString( ) );
			List< Conjunto > lista = new ArrayList< > ( );
			lista.add( conjunto );
			
			//Instancia services
			EmpresaService empresaService = new EmpresaService( );
			ControleTemperaturaService controleService = new ControleTemperaturaService( );
			ConjuntoService conjuntoService = new ConjuntoService( );
			
			//cria novo registro no banco
			empresaService.cadastrar( empresa );
			controleService.cadastrar( controle , empresa );
			conjuntoService.ocuparConjuntos( lista , empresa );
			
			out.println( JSonFacade.dadosToJSon( empresa , controle , conjunto ) );

		}
		catch( Exception e )
		{
			e.printStackTrace( );
		}

	}//Fim do método

	/**
	 * Alterar Empresa
	 */
	protected void doPut( HttpServletRequest request , HttpServletResponse response ) throws ServletException , IOException
	{
		StringBuilder sb = JSonFacade.montaJSon( request );
		PrintWriter out = response.getWriter( );

		try
		{
			//Intancia objetos
			Empresa empresa = JSonFacade.jSonToEmpresa( sb.toString( ) );
			ControleTemperatura controle = JSonFacade.jSonToControle( sb.toString( ) );
			Conjunto conjunto = JSonFacade.jSonToConjunto( sb.toString( ) );
			
			List< Conjunto > lista = new ArrayList< >( );
			lista.add( conjunto );
			
			//Instancia Services
			EmpresaService empresaService = new EmpresaService( );
			ConjuntoService conjuntoService = new ConjuntoService( );
			ControleTemperaturaService controleTemperaturaService = new ControleTemperaturaService( );
			
			empresaService.alterar( empresa );
			controleTemperaturaService.alterar( controle , empresa );
			conjuntoService.desocuparConjuntos( empresa.getCnpj( ) );
			conjuntoService.ocuparConjuntos( lista , empresa );
			
		
			out.println( JSonFacade.dadosToJSon( empresa , controle , conjunto ) );

		}
		catch( Exception e )
		{
			e.printStackTrace( );
		}
	}

	/**
	 * Excluir Empresa
	 */
	protected void doDelete( HttpServletRequest request , HttpServletResponse response ) throws ServletException , IOException 
	{
		StringBuilder sb = JSonFacade.montaJSon( request );
		PrintWriter out = response.getWriter( );

		try 
		{
			//Instancia Objeto
			Empresa empresa = JSonFacade.jSonToEmpresa( sb.toString( ) );
			ControleTemperatura controle = JSonFacade.jSonToControle( sb.toString( ) );
			Conjunto conjunto = JSonFacade.jSonToConjunto( sb.toString( ) );
			
			List< Conjunto > lista = new ArrayList< >( );
			lista.add( conjunto );
			
			//Instancia Services
			EmpresaService empresaService = new EmpresaService( );
			ControleTemperaturaService controleService = new ControleTemperaturaService( );
			ConjuntoService conjuntoService = new ConjuntoService( );
			
			//Exclui o registro do banco de dados
			conjuntoService.desocuparConjuntos( lista );
			controleService.excluir( empresa );
			empresaService.excluir( empresa );
			
			out.println( JSonFacade.dadosToJSon( empresa , controle , conjunto ) );
			
		}
		catch( Exception e )
		{
			e.printStackTrace( );
			out.println( JSonFacade.errorToJSon( e ) );
		}
	}

}
