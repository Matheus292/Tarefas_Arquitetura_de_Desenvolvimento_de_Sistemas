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
 * Servlet implementation class AlterarEmpresaController
 */
@WebServlet("/EditarEmpresa.do")
public class EditarEmpresaController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost( request , response );
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try
		{

			String cnpj = request.getParameter( "id" );



			Empresa empresa = new Empresa( );
			ControleTemperatura controle = new ControleTemperatura( );
			Conjunto conjunto = new Conjunto( );


			EmpresaService empService = new EmpresaService( );
			ControleTemperaturaService conService = new ControleTemperaturaService( );
			ConjuntoService cjService = new ConjuntoService( );


			empresa = empService.consultar( cnpj );
			controle = conService.consultar( empresa );
			conjunto = cjService.consultarConjuntoOcupado( empresa );

			
			List< Conjunto > lista = new ArrayList< >( );
			

			PrintWriter out = response.getWriter( );

			
			out.println( "<html><head><title>Alterar Empresa</title></head><body>" );
			out.println( "<a href = 'index.html'> Home </a><br>" );
			out.println( "<a href = 'cadastrar.html' >Cadastrar Empresa </a><br>" );
			out.println( "<a href = 'ConsultarEmpresa.do' > Consultar Empresa </a>" );
			out.println( "<h1> Alterar Empresa </h1>" );
		
			
			out.println
			(
					"<form action = 'AlterarEmpresa.do' method = 'post' > " +
					"<input type = 'hidden' name='cnpj' value='" + empresa.getCnpj( ) + "'"+ ">" + "</input>" +
					"CNPJ: <input type = 'text'  value= '" + empresa.getCnpj( ) + "'"  + " required maxlength='14' disabled /><br>" +

					"Razão Social: <input type = 'text' name = 'razao'  required " + "value='"+empresa.getRazaoSocial( ) + "'" + "/><br>" +

					"Endereço: <input type = 'text' name = 'endereco'  required " +  "value='"+empresa.getEndereco( ) + "'" + "/><br>" +

					"Telefone: <input type = 'text' name = 'fone'  required "  +  "value='"+empresa.getTelefone( ) + "'" + "/><br>" +

					"Horário de Funcionameto: <input type = 'time' name = 'horarioInicial' value=" + empresa.getHorarioAbertura( ) + " required /> às "
					+ "<input type = 'time' name = 'horarioFinal' value = " + empresa.getHorarioFechamento( )  + " required/><br>" +

					"Funcionamento do Ar Condicionado: <input type = 'time' name = 'arHorarioInicial' value = " + controle.getHorarioInicial( ) 
					+ " required/> às <input type = 'time' name = 'arHorarioFinal' value = "+ controle.getHorarioFinal( )  + " required /><br>" +

					"Temperatura máxima do Ar Condicionado: <input type = 'number' name = 'temperatura' value = " + controle.getTemperaturaMaxima( ) + " min = '0' max = '40'/><br>" +


					"Conjunto Ocupado pela Empresa: " + conjunto + " <input type = 'radio' name = 'CONJUNTO' value = " + conjunto + " checked />" 	+

					"<br>"
					);


			out.println( "<br>Conjunto(s) Disponíveis: " );
			
			lista = cjService.consultarConjuntoDesocupado( );
			
			for( Conjunto c : lista )
			{
				out.println(  c + "<input type = 'radio' name = 'CONJUNTO' value = " + c );
				out.println( "</input>" );
			}
				

			out.println
			(
					"<br><br>" +
							"<input type = 'submit' title = 'Salvar' value = 'Salvar Alterações' />" +
							"</form>" + 
							" <a href = 'ConsultarEmpresa.do'> <button> Cancelar </button> </a>" 
							

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
