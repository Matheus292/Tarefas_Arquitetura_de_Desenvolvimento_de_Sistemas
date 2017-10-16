/**
 * Responsavel por excluir a empresa
 */
package br.com.usjt.refatoracao.controller.command;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.usjt.refatoracao.model.bean.Empresa;
import br.com.usjt.refatoracao.model.service.ConjuntoService;
import br.com.usjt.refatoracao.model.service.ControleTemperaturaService;
import br.com.usjt.refatoracao.model.service.EmpresaService;

/**
 * @author Matheus Ribeiro Barbosa Santos e Samuel Alves de Almeida
 *
 */
public class ExcluirEmpresa implements Command
{

	@Override
	public void executar( HttpServletRequest request , HttpServletResponse response ) throws ServletException , IOException 
	{
		
		//Instancia os Java Beans
		Empresa empresa = new Empresa( );
		
		//Instancia os Services
		EmpresaService servicoEmpresa = new EmpresaService( );
		ControleTemperaturaService servicoControle = new ControleTemperaturaService( );
		ConjuntoService servicoConjunto = new ConjuntoService( );

		String cnpj = request.getParameter( "id" );

		empresa.setCnpj( cnpj );

		try 
		{
			servicoConjunto.desocuparConjuntos( empresa.getCnpj( ) );
			servicoControle.excluir( empresa );
			servicoEmpresa.excluir( empresa );
			
			ListarEmpresa lista = new ListarEmpresa( );
			lista.executar( request , response );
		
		} 
		catch ( SQLException e )
		{
			e.printStackTrace( );
		}

	}	
}