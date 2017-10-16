/**
 *Classe responsavel por menter as informações da empresa
 */
package br.com.usjt.refatoracao.model.bean;

import java.io.Serializable;

/**@author Matheus Ribeiro Barbosa Santos e Samuel Alves de Almeida
 */
public class Empresa implements Serializable
{
	private static final long serialVersionUID = 1L;

	//Atributos
	private String cnpj , razaoSocial , telefone , endereco , horarioAbertura , horarioFechamento;

	/**
	 *Construtor Padrão
	 */
	public Empresa( )
	{

	}


	public String getCnpj( ) 
	{
		return cnpj;
	}


	public void setCnpj( String cnpj )
	{
		this.cnpj = cnpj;
	}


	public String getRazaoSocial( )
	{
		return razaoSocial;
	}


	public void setRazaoSocial( String razaoSocial )
	{
		this.razaoSocial = razaoSocial;
	}


	public String getTelefone( )
	{
		return telefone;
	}


	public void setTelefone( String telefone )
	{
		this.telefone = telefone;
	}


	public String getEndereco( )
	{
		return endereco;
	}


	public void setEndereco( String endereco )
	{
		this.endereco = endereco;
	}


	public String getHorarioAbertura( )
	{
		return horarioAbertura;
	}


	public void setHorarioAbertura( String horarioAbertura )
	{
		this.horarioAbertura = horarioAbertura;
	}


	public String getHorarioFechamento( )
	{
		return horarioFechamento;
	}


	public void setHorarioFechamento( String horarioFechamento )
	{
		this.horarioFechamento = horarioFechamento;
	}	
	

}//Fim da classe