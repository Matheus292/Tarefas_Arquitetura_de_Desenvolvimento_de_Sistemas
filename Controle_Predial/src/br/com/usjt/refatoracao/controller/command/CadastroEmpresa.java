/**
 * Classe responsavel pelo servlet que carrega a pagina de cadastro de empresa, que pega os conjuntos disponiveis
 * do banco de dados
 **/
package br.com.usjt.refatoracao.controller.command;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.usjt.refatoracao.model.bean.Conjunto;
import br.com.usjt.refatoracao.model.service.ConjuntoService;

/**
 *@author Matheus Ribeiro Barbosa Santos e Samuel Alves de Almeida
 */

public class CadastroEmpresa implements Command
{

	@Override
	public void executar( HttpServletRequest request , HttpServletResponse response ) throws ServletException , IOException
	{
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