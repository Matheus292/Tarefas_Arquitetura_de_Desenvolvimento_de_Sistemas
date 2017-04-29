package br.com.usjt.refatoracao.service;

import java.sql.SQLException;
import java.util.List;

import br.com.usjt.refatoracao.dao.EmpresaDAO;
import br.com.usjt.refatoracao.model.Empresa;

public class EmpresaService
{
	/**
	 *Contrutor padrão 
	 */
	public EmpresaService( )
	{
		
	}
	

	/**
	 *Responsavel por cadastrar a empresa no banco de dados
	 *@param empresa
	 * @throws SQLException 
	 */
	public boolean cadastrar( Empresa empresa ) throws SQLException
	{
		EmpresaDAO dao = new EmpresaDAO( );
		return dao.cadastrar( empresa );
	}
	
	/**
	 *Responsavel por consultar as empresas no banco de dados
	 */
	public List<Empresa> consultar( ) throws SQLException
	{
		EmpresaDAO dao = new EmpresaDAO( );
		return dao.consultar( );
	}
	
	/**
	 *Responsavel por consultar as empresas no banco de dados
	 *@param cnpj
	 *@return empresa
	 */
	public Empresa consultar( String cnpj )throws SQLException
	{
		EmpresaDAO dao = new EmpresaDAO( );
		return dao.consultar( cnpj );
	}
	
	
	/**
	 *Responsavel por alterar a empresa no banco de dados 
	 *@param empresa
	 *@return true,false
	 */
	public boolean alterar( Empresa empresa ) throws SQLException
	{
		EmpresaDAO dao = new EmpresaDAO( );
		return dao.alterar( empresa );
	}
	
	/**
	 *Responsavel por excluir a empresa no banco de dados
	 *@param empresa
	 *@return true,false
	 */
	public boolean excluir( Empresa empresa ) throws SQLException
	{
		EmpresaDAO dao = new EmpresaDAO( );
		return dao.excluir( empresa );
	}
	
	
	/**
	 *Responsavel por excluir a empresa no banco de dados utilizando o cnpj
	 *@param empresa
	 *@return true,false
	 */
	
   public boolean excluirPorCnpj( String cnpj ) throws SQLException
   {
      EmpresaDAO dao = new EmpresaDAO( );
      return dao.excluirPorCnpj( cnpj );
   }
	
}//Fim da Classe
