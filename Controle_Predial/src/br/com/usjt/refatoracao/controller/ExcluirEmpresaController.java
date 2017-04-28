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
import br.com.usjt.refatoracao.model.Empresa;
import br.com.usjt.refatoracao.service.ConjuntoService;
import br.com.usjt.refatoracao.service.ControleTemperaturaService;
import br.com.usjt.refatoracao.service.EmpresaService;

/**
 * Servlet implementation class ExcluirEmpresaController
 */
@WebServlet("/ExcluirEmpresa.do")
public class ExcluirEmpresaController extends HttpServlet 
{
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet( HttpServletRequest request , HttpServletResponse response ) throws ServletException, IOException {

		doPost( request , response );

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		try
		{
			String cnpj = request.getParameter( "id" );

			List< Conjunto > lista = new ArrayList< >( );

			Empresa empresa = new Empresa( );
			Conjunto conjunto = new Conjunto( );

			EmpresaService empService = new EmpresaService( );
			ControleTemperaturaService conService = new ControleTemperaturaService( );
			ConjuntoService cjService = new ConjuntoService( );

			empresa = empService.consultar( cnpj );
						
			
			conjunto = cjService.consultarConjuntoOcupado( empresa );
			lista.add( conjunto );			
			
			cjService.desocuparConjuntos( lista );
			conService.excluir( empresa );
			empService.excluir( empresa );
			RequestDispatcher dispatcher = request.getRequestDispatcher( "ConsultarEmpresa.do" );
			dispatcher.forward( request , response );

		}
		catch( SQLException e )
		{
			e.printStackTrace( );
			throw new IOException( e );
		}
	}

}
