
package br.com.usjt.refatoracao.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

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
 * Servlet implementation class VisualizarEmpresaController
 */
@WebServlet("/VisualizarEmpresa.do")
public class VisualizarEmpresaController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost( request ,  response );
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PrintWriter out = response.getWriter( );

		String cnpj = request.getParameter( "id" );

		EmpresaService empService = new EmpresaService( );
		ConjuntoService conService = new ConjuntoService( );
		ControleTemperaturaService ctService = new ControleTemperaturaService( );

		try
		{
			Empresa empresa = empService.consultar( cnpj );
			Conjunto conjunto = conService.consultarConjuntoOcupado( empresa );
			ControleTemperatura controle = ctService.consultar( empresa );

			out.println( "<html><head><title>Dados da Empresa</title></head><body>" );
			out.println( "<a href = 'index.html'> Home </a><br>" );
			out.println( "<a href = 'cadastrar.html' >Cadastrar Empresa </a><br>" );
			out.println( "<a href = 'ConsultarEmpresa.do' > Consultar Empresa </a>" );
			out.println( "<h1> Dados da Empresa </h1>" );

			out.println
			(
					"<br>" + 
							"<label>CNPJ:</label>" +
							empresa.getCnpj( ) +
							"<br>" +

										"<label>Razão Social:</label>"+
										empresa.getRazaoSocial( ) +
										"<br>" +

								"<label>Endereço:</label>" +
								empresa.getEndereco( )
								+	"<br>" +

								"<label>Telefone:</label>"
								+ empresa.getTelefone( )
								+ "<br>" + 

								"<label>Horário de Funcionamento:</label>"
								+ empresa.getHorarioAbertura( )
								+ "<label> às </label>" + " " + empresa.getHorarioFechamento( ) + "<br>"


							+ "<label>Funcionamento do Ar Condicionado:</label>" +
							controle.getHorarioInicial( )
							+ "<label> às </label>" + " " +
							controle.getHorarioFinal( ) + 
							"<br>"

								+ "<label>Temperatura:</label>"
								+ controle.getTemperaturaMaxima( ) + "<br>"

								+ "<label>Conjunto ocupado pela empresa: </label>"
								+ conjunto + "<br>"		

								+ "<a 	href='ConsultarEmpresa.do'>" +
								"<button title='Listar empresas'>Listar empresas</button>"+
								"</a>" + 

								"<a href='ExcluirEmpresa.do?id=" + empresa.getCnpj( ) + "'>"
								+ "<button  title='Excluir'> Excluir </button>"
								+ "</a>" +										
								"<a href = 'EditarEmpresa.do?id=" + empresa.getCnpj( ) + "'>" + 
								"<button title='Alterar Empresa'> Alterar Empresa </button>"
								+"</a>"
					);

			out.println( "</body></html>" );

		}

		catch( SQLException e )
		{
			e.printStackTrace( );
			throw new IOException( e ); 
		}
	}
}


