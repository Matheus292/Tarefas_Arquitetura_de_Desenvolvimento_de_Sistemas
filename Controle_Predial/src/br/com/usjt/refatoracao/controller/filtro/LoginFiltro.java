package br.com.usjt.refatoracao.controller.filtro;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.usjt.refatoracao.model.bean.Usuario;
import br.com.usjt.refatoracao.model.verificacao.Erro;

/**
 * Servlet Filter implementation class LoginFiltro
 */
@WebFilter( filterName = "meu_filtro" , urlPatterns = { "/controller.do", "/index.jsp" } ) 

public class LoginFiltro implements Filter
{

	/**
	 * Cosntrutor Padrao 
	 */
	public LoginFiltro( )
	{
		
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy( )
	{
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	
	public void doFilter( ServletRequest request , ServletResponse response , FilterChain chain ) throws IOException , ServletException 
	{
		HttpServletRequest requisicao = ( HttpServletRequest ) request;
		HttpSession session = requisicao.getSession( );

		Usuario usuario = ( Usuario ) session.getAttribute( Usuario.LOGADO );
		String path = requisicao.getContextPath( );
		String uri = requisicao.getRequestURI( );
		String comando = requisicao.getParameter( "command" );
		
		Erro erro = new Erro( ); 
		
		
		if( comando == null )
		{
			comando = "";
		}
	
		if( usuario == null && !uri.equals( path + "/login.jsp" )  && !comando.equals( "Login" )   )
		{			
			erro.setValor( 0 );
			session.setAttribute( "erro" , erro );
			( ( HttpServletResponse ) response ).sendRedirect( path + "/login.jsp" );
		}		
		else
		{				
			chain.doFilter( requisicao , response );	
		}
		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init( FilterConfig fConfig ) throws ServletException
	{

	}

}
