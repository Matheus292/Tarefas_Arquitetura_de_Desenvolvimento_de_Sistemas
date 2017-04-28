package br.com.usjt.refatoracao.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
public class CadastrarEmpresaController extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	private static Empresa empresa;
	private static ControleTemperatura controle;

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

		String oQueFazer = request.getParameter( "OPCAO" );

		switch ( oQueFazer )
		{
		case "Salvar":
			cadastrar( request , response );
			break;
		case "Prosseguir":
			tranfereDado( request , response );
			break;
		}
	}		


	private void tranfereDado( HttpServletRequest request , HttpServletResponse response ) throws IOException
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

		//Instancia os Java Beans
		empresa = new Empresa( );
		empresa.setCnpj( cnpj );
		empresa.setRazaoSocial( razao );
		empresa.setEndereco( endereco );
		empresa.setTelefone( telefone );
		empresa.setHorarioAbertura( horarioInicial );
		empresa.setHorarioFechamento( horarioFinal );

		controle = new ControleTemperatura( );
		controle.setTemperaturaMaxima( temperatura );
		controle.setHorarioInicial( arHorarioInicial );
		controle.setHorarioFinal( arHorarioFinal );


		consultarDados( request , response );

	}






	public void consultarDados(  HttpServletRequest request , HttpServletResponse response ) throws IOException
	{
		PrintWriter out = response.getWriter( );

		out.println( "<html><head><title>Conjuntos Disponiveis</title></head><body>" );
		out.println( "<a href = 'index.html'> Home </a><br>" );
		out.println( "<a href = 'cadastrar.html' >Cadastrar Empresa </a><br>" );
		out.println( "<a href = 'ConsultarEmpresa.do' > Consultar Empresa </a>" );
		out.println( "<h1>Conjuntos Disponiveis</h1>");
		out.println( "<form action = 'ManterEmpresa.do' method = 'post' >" );

		ConjuntoService cs = new ConjuntoService( );
		try 
		{
			List<Conjunto> conjuntos = cs.consultarConjuntoDesocupado( );

			for( Conjunto c : conjuntos )
			{
				out.println(  c + "<input type = 'radio' name = 'CONJUNTO' value = " + c + " checked" );
				out.println( "</input>" );
			}
			out.println( "<br>" );
			out.println( "<input type = 'submit' name = 'OPCAO' value = Salvar>" );
			out.println( "</input>" );
			out.println( "<a href = 'index.html'>" );
			out.println( "<input type = 'button' value = 'Cancelar' >" );
			out.println( "</input" );
			out.println( "</a>" );
			out.println( "</form>" );
			out.println( "</body></html>" );
		}
		catch ( SQLException e )
		{
			e.printStackTrace( );
		}

	}


	public void cadastrar( HttpServletRequest request , HttpServletResponse response ) throws IOException
	{

		String[ ] conj = request.getParameterValues( "CONJUNTO" );

		List< Conjunto > lista = new ArrayList< >( );
		for( String x : conj )
		{
			Conjunto conjunto = new Conjunto( );
			conjunto.setId( Integer.parseInt( x ) );
			lista.add( conjunto );
		}


		//Instancia os Services
		EmpresaService servicoEmpresa = new EmpresaService( );
		ControleTemperaturaService servicoControle = new ControleTemperaturaService( );
		ConjuntoService servicoConjunto = new ConjuntoService( );

		try 
		{
			servicoEmpresa.cadastrar( empresa );
			servicoControle.cadastrar( controle , empresa );
			servicoConjunto.ocuparConjuntos( lista , empresa );

			PrintWriter out = response.getWriter( );
			out.println( "<html><head><title>Empresa Cadastrada</title></head><body>" );
			out.println( "<p> Empresa cadastrada com sucesso</p>" );
			out.println( "<a href = 'index.html'>" );
			out.println( "<input type = 'button' value = 'Home' >" );
			out.println( "</input" );
			out.println( "</a>" );
			out.println( "</body></html>" );
		} 
		catch ( SQLException e ) 
		{
			PrintWriter out = response.getWriter( );
			out.println( "<html><head><title>Empresa Cadastrada</title></head><body>" );
			out.println( "<p> Não foi possivel cadastrar empresa</p>" );
			out.println( "<a href = 'index.html'>" );
			out.println( "<input type = 'button' value = 'Home' >" );
			out.println( "</input" );
			out.println( "</a>" );
			out.println( "</body></html>" );
		}
		finally
		{
			empresa = null;
			controle = null;
		}
	}

}
