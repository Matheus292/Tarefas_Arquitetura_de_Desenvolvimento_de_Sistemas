/**
 * Classe responsavel pela requisição de login
 */
package br.com.usjt.refatoracao.controller.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.usjt.refatoracao.model.bean.Usuario;
import br.com.usjt.refatoracao.model.service.UsuarioService;
import br.com.usjt.refatoracao.model.verificacao.Erro;


/**
 * @author Matheus Ribeiro Barbosa Santos e Samuel Alves de Almeida
 *
 */
public class Login implements Command 
{

	@Override
	public void executar( HttpServletRequest request , HttpServletResponse response ) throws ServletException , IOException 
	{

		String login = request.getParameter( "login" );
		String senha = request.getParameter( "senha" );

		String path = request.getContextPath( );
		
		Usuario usuario = new Usuario( );

		usuario.setLogin( login );
		usuario.setSenha( senha );

		UsuarioService service = new UsuarioService( );

		HttpSession session = request.getSession( );

		Erro erro = new Erro( );
		
		if( service.validar( usuario ) )
		{	
			erro.setValor( 0 );
			session.setAttribute( Usuario.LOGADO , usuario );			
			session.setAttribute( "erro" , erro );
			response.sendRedirect( "index.jsp" );
		}
		else
		{
			erro.setValor( 1 );
			session.setAttribute( "erro" , erro );
			( ( HttpServletResponse ) response ).sendRedirect( path + "/login.jsp" );
			
		}

	}

}//Fim da classe