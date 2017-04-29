package br.com.usjt.refatoracao.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.usjt.refatoracao.model.Conjunto;
import br.com.usjt.refatoracao.service.ConjuntoService;

/**
 * Servlet implementation class CarregaConjuntoController
 */
@WebServlet("/cadastro.do")
public class CarregaConjuntoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doPost( request , response );
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
			try
			{
				ConjuntoService servicoConjunto = new ConjuntoService( );
				List<Conjunto> lista =  servicoConjunto.consultarConjuntoDesocupado( );
				request.setAttribute( "lista" , lista );
				RequestDispatcher dispatcher = request.getRequestDispatcher( "cadastrar.jsp" );
				dispatcher.forward( request , response );
				
			} 
			catch ( SQLException e ) 
			{
				e.printStackTrace();
			}
		}

		
	}

