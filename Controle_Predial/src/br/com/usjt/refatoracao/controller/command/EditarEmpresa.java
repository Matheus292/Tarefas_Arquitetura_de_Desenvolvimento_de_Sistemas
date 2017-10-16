/**
 * Responsavel por editar os dados da empresa
 */
package br.com.usjt.refatoracao.controller.command;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.usjt.refatoracao.model.bean.Conjunto;
import br.com.usjt.refatoracao.model.bean.ControleTemperatura;
import br.com.usjt.refatoracao.model.bean.Empresa;
import br.com.usjt.refatoracao.model.service.ConjuntoService;
import br.com.usjt.refatoracao.model.service.ControleTemperaturaService;
import br.com.usjt.refatoracao.model.service.EmpresaService;

/**
 * @author Matheus Ribeiro Barbosa Santos e Samuel Alves de Almeida
 *
 */
public class EditarEmpresa implements Command
{

	@Override
	public void executar( HttpServletRequest request , HttpServletResponse response ) throws ServletException , IOException 
	{
		//Instancia os Java Beans
		Empresa empresa = new Empresa( );
		ControleTemperatura controle = new ControleTemperatura( );
		Conjunto conjunto = new Conjunto( );


		//Instancia os Services
		EmpresaService servicoEmpresa = new EmpresaService( );
		ControleTemperaturaService servicoControle = new ControleTemperaturaService( );
		ConjuntoService servicoConjunto = new ConjuntoService( );

		RequestDispatcher dispatcher = null;
		
		String cnpj = request.getParameter( "id" );			
		empresa.setCnpj( cnpj );		

		try
		{
			empresa = servicoEmpresa.consultar( empresa.getCnpj( ) );
			controle = servicoControle.consultar( empresa );
			conjunto = servicoConjunto.consultarConjuntoOcupado( empresa );

			List<Conjunto> desocupado =  servicoConjunto.consultarConjuntoDesocupado( );

			request.setAttribute( "lista" , desocupado );
			request.setAttribute( "empresa" , empresa );
			request.setAttribute( "controle" , controle );
			request.setAttribute( "ocupado" , conjunto );

			dispatcher = request.getRequestDispatcher( "alterar.jsp" );
			dispatcher.forward( request , response );

		}
		catch( SQLException exception )
		{

		}


	}



}