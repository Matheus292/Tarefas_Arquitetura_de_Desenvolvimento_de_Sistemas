/**
 * Classe responsavel por integrar a view de login com as classes de negocio
 */
package br.com.usjt.refatoracao.model.service;

import java.io.IOException;

import br.com.usjt.refatoracao.model.bean.Usuario;
import br.com.usjt.refatoracao.model.dao.UsuarioDAO;

/**
 * @author Matheus Ribeiro Barbosa Santos e Samuel Alves de Almeida
 *
 */
public class UsuarioService
{
	//Atributo
	private UsuarioDAO dao;
	
	/**
	 *Construutor
	 */
	public UsuarioService(  )
	{
		dao = new UsuarioDAO( );
	}
	
	
	/**
	 *Responsavel por chamar o metodo validar de UsuarioDAO
	 * @throws IOException 
	 */
	public boolean validar( Usuario usuario ) throws IOException
	{
		return dao.validar( usuario );
	}
	
}