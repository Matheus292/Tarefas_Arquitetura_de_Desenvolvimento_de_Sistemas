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

import br.com.usjt.refatoracao.model.Empresa;
import br.com.usjt.refatoracao.service.EmpresaService;

/**
 * Servlet implementation class ConsultarEmpresaController
 */
@WebServlet("/ConsultarEmpresa.do")
public class ListarEmpresaController extends HttpServlet {
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
	protected void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException
	{
		PrintWriter out = response.getWriter( );

		out.println( "<html><head><title>Empresas Cadastradas</title></head><body>" );
		out.println( "<a href = 'index.html'> Home </a><br>" );
		out.println( "<a href = 'cadastrar.html' >Cadastrar Empresa </a><br>" );
		out.println( "<a href = '#' > Consultar Empresa </a>" );
		out.println( "<h1> Empresas Cadastradas </h1>" );

		out.println
		(
				"<table border = '2'>"
						+ "<thead>"
						+ 	"<tr>" + "<td><b>CNPJ</b></td>" +
						"<td><b>Razão Social</b></td>" +
						"<td><b>Telefone</b></td>" +
						"<td><b>Endereço</b></td>" +
						"<td><b>Horario de Abertura</b></td>" + 
						"<td><b>Horario de Fechamento</b></td>" +
						"<td><b>Ação(es)</b></td>" +
						"</tr>" +
						"</thead>" 				
				);

		EmpresaService servico = new EmpresaService( );
		List< Empresa > lista = new ArrayList< >( );

		try
		{ 
			lista = servico.consultar( );


			for( Empresa empresa : lista )
			{
				out.println
				(
						"<tr>" +
								"<td>" + empresa.getCnpj( )+ "</td>" +
								"<td>" + empresa.getRazaoSocial( ) + "</td>" +
								"<td>" + empresa.getTelefone( ) + "</td>" +
								"<td>" + empresa.getEndereco( ) + "</td>" + 
								"<td>" + empresa.getHorarioAbertura( ) + "</td>" +
								"<td>" + empresa.getHorarioFechamento( ) + "</td>" +
								"<td>" + 

					"<a	href= 'VisualizarEmpresa.do?id=" + empresa.getCnpj( ) + "'>" +
					"<button title='Consultar'>Consultar</button>"+
					"</a>" +

					"<a href='ExcluirEmpresa.do?id=" + empresa.getCnpj( ) + "'>"
					+ "<button  title='Excluir'> Excluir </button>" +
					"</a>" +						
					"<a href='EditarEmpresa.do?id=" + empresa.getCnpj( ) + "'>" +
					"<button title='Alterar Empresa'> Alterar Empresa </button>"+
					"</a>" + 				
					"</td>" +
					"</tr>"
						);
			}
			out.println( "</table>" );
			out.println( "</body></html>" );

		}
		catch( SQLException e )
		{
			e.printStackTrace( );
			throw new IOException( e );
		}

	}		
}