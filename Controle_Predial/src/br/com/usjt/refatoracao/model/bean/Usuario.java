/**
 * Classe responsavel pelas informações do usuário
 */
package br.com.usjt.refatoracao.model.bean;

import java.io.Serializable;

/**
 * @authors Matheus Ribeiro Barbosa Santos e Samuel Alves de Almeida
 *
 */
public class Usuario implements Serializable 
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final String LOGADO = "logado";
	
	
	//Atributos
	private String login , senha ;
	
	/**
	 *Consttutor Padrão
	 */
	public Usuario( )
	{
		
	}

	/**
	 * @return the login
	 */
	public String getLogin( ) 
	{
		return login;
	}

	/**
	 * @param login the login to set
	 */
	public void setLogin( String login )
	{
		this.login = login;
	}

	/**
	 * @return the senha
	 */
	public String getSenha( )
	{
		return senha;
	}

	/**
	 * @param senha the senha to set
	 */
	public void setSenha( String senha )
	{
		this.senha = senha;
	}
	
}//Fim da classe