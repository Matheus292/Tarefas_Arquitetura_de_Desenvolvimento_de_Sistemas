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
@WebServlet("/ManterEmpresa.do")
public class ManterEmpresaController extends HttpServlet
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

		//Instancia os Java Beans
		Empresa empresa = new Empresa( );
		ControleTemperatura controle = new ControleTemperatura( );

		//Instancia os Services
		EmpresaService servicoEmpresa = new EmpresaService( );
		ControleTemperaturaService servicoControle = new ControleTemperaturaService( );
		ConjuntoService servicoConjunto = new ConjuntoService( );		


		RequestDispatcher dispatcher = null ;		

		if( opcao.equals( "Cadastrar" ) )
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
				Conjunto conjunto = new Conjunto( );

				conjunto.setId( Integer.parseInt( x ) );
				lista.add( conjunto );
			}		
			try 
			{
				servicoEmpresa.cadastrar( empresa );
				servicoControle.cadastrar( controle , empresa );
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
		else
		{

			if( opcao.equals( "Consultar" ) )
			{
				try
				{
					String id = request.getParameter( "id" );

					empresa = servicoEmpresa.consultar( id );										
					controle =  servicoControle.consultar( empresa );
					Conjunto conjunto = servicoConjunto.consultarConjuntoOcupado( empresa );

					request.setAttribute( "empresa" , empresa );
					request.setAttribute( "controle" , controle );
					request.setAttribute( "conjunto" , conjunto );					

					dispatcher = request.getRequestDispatcher( "visualizar.jsp" );
					dispatcher.forward( request , response );
				}
				catch ( SQLException sql )
				{
					sql.printStackTrace( );
				}
			}
			else
			{
				if( opcao.equals( "Excluir" ) )
				{
					String cnpj = request.getParameter( "id" );

					empresa.setCnpj( cnpj );

					try 
					{
						servicoConjunto.desocuparConjuntos( empresa.getCnpj( ) );
						servicoControle.excluir( empresa );
						servicoEmpresa.excluir( empresa );
						dispatcher = request.getRequestDispatcher( "ManterEmpresa.do?opcao=listar" );			
						dispatcher.forward( request , response );
					} 
					catch ( SQLException e )
					{
						e.printStackTrace( );
					}
				}
				else
				{
					if( opcao.equals( "listar" ) )
					{
						EmpresaService empresaService = new EmpresaService();
						try 
						{
							List<Empresa> lista = empresaService.consultar( );
							request.setAttribute( "lista" , lista );
						} 
						catch ( SQLException e )
						{
							e.printStackTrace();
						}
						dispatcher = request.getRequestDispatcher( "consultar.jsp" );			
						dispatcher.forward( request , response );
					
					}
				}
					
			}

		}
	}

}