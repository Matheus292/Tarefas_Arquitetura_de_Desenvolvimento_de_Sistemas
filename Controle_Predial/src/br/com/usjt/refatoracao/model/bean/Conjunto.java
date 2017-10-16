/**
 *Classe responsavel pelas informações do conjunto
 */
package br.com.usjt.refatoracao.model.bean;

import java.io.Serializable;

/**
 * @author Matheus Ribeiro Barbosa Santos e Samuel Alves de Almeida
 */
public class Conjunto implements Serializable
{
	private static final long serialVersionUID = 1L;
	//Atributos
	private int id;
	private boolean disponibilidade;

	/**
	 *Construtor Padrão
	 */
	public Conjunto( )
	{

	}

	public int getId( )
	{
		return id;
	}

	public void setId( int id )
	{
		this.id = id;
	}

	public boolean getDisponibilidade( )
	{
		return disponibilidade;
	}

	public void setDisponibilidade( boolean disponibilidade )
	{
		this.disponibilidade = disponibilidade;
	}	

	/**
	 *Sobreescreve o metodo toString da classe Object
	 */
	@Override
	public String toString( )
	{
		return "" + getId( );
	}
}//Fim da Classe