package br.com.usjt.refatoracao.service;

import java.sql.SQLException;
import java.util.List;

import br.com.usjt.refatoracao.dao.ControleTemperaturaDAO;
import br.com.usjt.refatoracao.model.ControleTemperatura;
import br.com.usjt.refatoracao.model.Empresa;

public class ControleTemperaturaService
{

	/**
	 *Construtor Padrão
	 */
	public ControleTemperaturaService( )
	{
	
	}
	
	/**
	 *Cadastra o controle de temperatura
	 *@param controleTemperatura , empresa
	 * @throws SQLException 
	 */
	public boolean cadastrar( ControleTemperatura controleTemperatura , Empresa empresa ) throws SQLException
	{
		ControleTemperaturaDAO dao = new ControleTemperaturaDAO( );
		return dao.cadastrar( controleTemperatura , empresa );
	}

	/**
	 *Metodo que serve para consultar os controles de temeperatura
	 * @throws SQLException 
	 *@ return controle
	 */
	public List<ControleTemperatura> consultar( ) throws SQLException
	{
		ControleTemperaturaDAO controle = new ControleTemperaturaDAO( );
		return controle.consultar(  );
	}
	

	/**
	 *Metodo que serve para consultar o controle de temeperatura
	 * @throws SQLException 
	 * @param empresa
	 * @return controle
	 
	 */
	public ControleTemperatura consultar( Empresa empresa ) throws SQLException
	{
		ControleTemperaturaDAO controle = new ControleTemperaturaDAO( );
		return controle.consultar( empresa );
	}
	
	
	/**
	 *Responsavel por alterar o controle de temperatura
	 *@param controleTemperatura ,empresa
	 *@return true, false
	 */
	public boolean alterar( ControleTemperatura controleTemperatura , Empresa empresa ) throws SQLException
	{
		ControleTemperaturaDAO dao = new ControleTemperaturaDAO( );
		return dao.alterar( controleTemperatura , empresa );
	}
	
	/**
	 *Responsavel por excluir o controle de temperatura no banco de dados
	 *@param controleTemperatura , empresa
	 *@return true,false
	 * @throws SQLException 
	 */
	public boolean excluir( Empresa empresa ) throws SQLException
	{
		ControleTemperaturaDAO dao = new ControleTemperaturaDAO( );
		return dao.excluir( empresa );
	}
	
	/**
	 *Responsavel por excluir o controle de temperatura no banco de dados
	 *@param controleTemperatura , empresa
	 *@return true,false
	 * @throws SQLException 
	 */

   public boolean excluir( String cnpj ) throws SQLException
   {
      ControleTemperaturaDAO dao = new ControleTemperaturaDAO( );
      return dao.excluir( cnpj );
   }
}