package br.com.usjt.refatoracao.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.usjt.refatoracao.controller.command.Command;

/**
 * Servlet implementation class ServletController
 * 
 * @author Matheus Ribeiro Barbosa Santos e Samuel Alves de Almeida
 */
@WebServlet( "/controller.do" )
public class ServletController extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	/**
	 * Responsavel por executar o servlet
	 * @param HttpServletRequest , HttpServletResponse  
	 */
	protected void doExecute( HttpServletRequest request , HttpServletResponse response ) throws ServletException , IOException
	{
		try
		{
			request.setCharacterEncoding( "UTF-8" );
			
			Command comando = ( Command )Class.forName( "br.com.usjt.refatoracao.controller.command." + request.getParameter( "command" ) ).newInstance( );
					
			comando.executar( request , response );
			
		}
		catch(  InstantiationException | IllegalAccessException | ClassNotFoundException e )
		{
			e.printStackTrace( );
			
			throw new ServletException( e );
		}		
		
	}	
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet( HttpServletRequest request , HttpServletResponse response )  throws ServletException , IOException 
	{
		doExecute( request , response );
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost( HttpServletRequest request , HttpServletResponse response ) throws ServletException , IOException
	{
		doExecute( request ,  response );
	}

}//Fim do Servlet