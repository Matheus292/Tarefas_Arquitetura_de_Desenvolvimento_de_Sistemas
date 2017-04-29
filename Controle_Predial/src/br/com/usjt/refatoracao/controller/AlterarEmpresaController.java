package br.com.usjt.refatoracao.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.usjt.refatoracao.model.Conjunto;
import br.com.usjt.refatoracao.model.ControleTemperatura;
import br.com.usjt.refatoracao.model.Empresa;
import br.com.usjt.refatoracao.service.ConjuntoService;
import br.com.usjt.refatoracao.service.ControleTemperaturaService;
import br.com.usjt.refatoracao.service.EmpresaService;

/**
 * Servlet implementation class ManterEmpresaController
 */
@WebServlet("/AlterarEmpresa.do")
public class AlterarEmpresaController extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet( HttpServletRequest request , HttpServletResponse response ) throws ServletException, IOException 
	{
		doPost( request , response );
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */

	protected void doPost( HttpServletRequest request , HttpServletResponse response ) throws ServletException , IOException
	{	
		String opcao = request.getParameter( "opcao" );

		RequestDispatcher dispatcher = null ;

		//Instancia os Java Beans
		Empresa empresa = new Empresa( );
		ControleTemperatura controle = new ControleTemperatura( );
		Conjunto conjunto = new Conjunto( );


		//Instancia os Services
		EmpresaService servicoEmpresa = new EmpresaService( );
		ControleTemperaturaService servicoControle = new ControleTemperaturaService( );
		ConjuntoService servicoConjunto = new ConjuntoService( );


		if( opcao.equals( "editar" ) )
		{
			String cnpj = request.getParameter( "id" );			
			empresa.setCnpj( cnpj );		

			try
			{
				empresa = servicoEmpresa.consultar( empresa.getCnpj( ) );
				controle = servicoControle.consultar( empresa );
				conjunto = servicoConjunto.consultarConjuntoOcupado( empresa );
				
				List<Conjunto> desocupado =  servicoConjunto.consultarConjuntoDesocupado( );
				
				request.setAttribute( "lista" , desocupado );
				request.setAttribute( "empresa" , empresa );
				request.setAttribute( "controle" , controle );
				request.setAttribute( "ocupado" , conjunto );
				
				dispatcher = request.getRequestDispatcher( "alterar.jsp" );
				dispatcher.forward( request , response );
				
			}
			catch( SQLException exception )
			{

			}
		}
		else
		{
			if( opcao.equals( "salvar" ) )
			{
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
		}


		
}
