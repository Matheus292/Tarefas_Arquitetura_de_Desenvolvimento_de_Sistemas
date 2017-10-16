/**
 *Interface responsavel pelo FrontController
 *
 */

package br.com.usjt.refatoracao.controller.command;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *@authors Matheus Ribeiro Barbosa Santos e Samuel Alves de Almeida
 */

public interface Command 
{

	/**
	 * Responsavel por executar o servlet
	 * 
	 * @param HttpServletRequest , HttpServletResponse
	 */
	public void executar ( HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
	
}//Fim da interface