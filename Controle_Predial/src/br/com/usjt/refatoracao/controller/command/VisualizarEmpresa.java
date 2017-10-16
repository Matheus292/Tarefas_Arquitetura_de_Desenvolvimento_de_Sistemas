/**
 * Classe responsavel por cisualizar dados da empresa pelo jsp
 */
package br.com.usjt.refatoracao.controller.command;

import java.io.IOException;
import java.sql.SQLException;

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
public class VisualizarEmpresa implements Command
{

	@Override
	public void executar( HttpServletRequest request , HttpServletResponse response ) throws ServletException , IOException
	{
		//Instancia os Java Beans
		Empresa empresa = new Empresa( );
		ControleTemperatura controle = new ControleTemperatura( );

		//Instancia os Services
		EmpresaService servicoEmpresa = new EmpresaService( );
		ControleTemperaturaService servicoControle = new ControleTemperaturaService( );
		ConjuntoService servicoConjunto = new ConjuntoService( );		

		RequestDispatcher dispatcher = null;
		
		try
		{
			String id = request.getParameter( "id" );

			empresa = servicoEmpresa.consultar( id );										
			controle =  servicoControle.consultar( empresa );
			Conjunto conjunto = servicoConjunto.consultarConjuntoOcupado( empresa );

			request.setAttribute( "empresa" , empresa );
			request.setAttribute( "controle" , controle );
			request.setAttribute( "conjunto" , conjunto );					

			dispatcher = request.getRequestDispatcher( "visualizar.jsp" );
			dispatcher.forward( request , response );
		}
		catch ( SQLException sql )
		{
			sql.printStackTrace( );
		}
	}
}