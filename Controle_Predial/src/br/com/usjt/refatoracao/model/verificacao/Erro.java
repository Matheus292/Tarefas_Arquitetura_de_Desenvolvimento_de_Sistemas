package br.com.usjt.refatoracao.model.verificacao;

import java.io.Serializable;

public class Erro implements Serializable
{
	

	/**
	 * Constante
	 */
	private static final long serialVersionUID = 1L;

	//Atributo
	private int valor;
	
	/**
	 *Construtor privado
	 */
	public Erro( )
	{
		
	}

	/**
	 * @return the valor
	 */
	public int getValor( )
	{
		return valor;
	}

	/**
	 * @param valor the valor to set
	 */
	public void setValor( int valor )
	{
		this.valor = valor;
	}	
	
}
