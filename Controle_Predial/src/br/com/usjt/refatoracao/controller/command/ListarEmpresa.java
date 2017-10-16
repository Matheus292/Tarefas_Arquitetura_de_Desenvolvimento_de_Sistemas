/**
 * Responsavel por executar a listagem de empresas pelo servlet
 */
package br.com.usjt.refatoracao.controller.command;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.usjt.refatoracao.model.bean.Empresa;
import br.com.usjt.refatoracao.model.service.EmpresaService;

/**
 * @author Matheus Ribeiro Barbosa Santos e Samuel Alves de Almeida
 *
 */
public class ListarEmpresa implements Command
{

	@Override
	public void executar( HttpServletRequest request , HttpServletResponse response ) throws IOException , ServletException 
	{		
		RequestDispatcher dispatcher = null;
		
		EmpresaService empresaService = new EmpresaService( );
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
