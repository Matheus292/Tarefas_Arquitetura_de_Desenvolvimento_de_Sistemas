/**
 *Classe responsavel pelas informações do controle de temperatura 
 */
package br.com.usjt.refatoracao.model.bean;

import java.io.Serializable;

/**
 * @author Matheus Ribeiro Barbosa Santos e Samuel Alves de Almeida
 *
 */
public class ControleTemperatura implements Serializable
{
	private static final long serialVersionUID = 1L;
	//Atributos
	private int id;
	private short temperaturaMaxima;
	private String horarioInicial , horarioFinal;

	/**
	 *Construtor Padrão
	 */
	public ControleTemperatura( )
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

	public short getTemperaturaMaxima( )
	{
		return temperaturaMaxima;
	}

	public void setTemperaturaMaxima( short temperaturaMaxima )
	{
		this.temperaturaMaxima = temperaturaMaxima;
	}

	public String getHorarioInicial( )
	{
		return horarioInicial;
	}

	public void setHorarioInicial( String horarioInicial )
	{
		this.horarioInicial = horarioInicial;
	}

	public String getHorarioFinal( )
	{
		return horarioFinal;
	}

	public void setHorarioFinal( String horarioFinal )
	{
		this.horarioFinal = horarioFinal;
	}


}//Fim da classe