package br.com.usjt.refatoracao.controller.json;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import br.com.usjt.refatoracao.model.bean.Conjunto;
import br.com.usjt.refatoracao.model.bean.ControleTemperatura;
import br.com.usjt.refatoracao.model.bean.Empresa;

public class JSonFacade 
{

	/**
	 * Método responsavel por listar os dados do banco no arquivo JSON
	 */
	public static String mostraDados( List< Empresa > empLista , List< ControleTemperatura > tempLista , List< Conjunto > conjLista )
	{

		JSONArray vetor = new JSONArray( );


		Iterator< Empresa > iEmp = empLista.iterator( );
		Iterator< ControleTemperatura > iControle = tempLista.iterator( );
		Iterator< Conjunto > iConjunto = conjLista.iterator( );


		while( iEmp.hasNext( ) )
		{
			JSONObject objeto = new JSONObject( );


			Empresa emp = iEmp.next( );
			ControleTemperatura ct = iControle.next( );
			Conjunto conj = iConjunto.next( );

			try
			{
				objeto.put( "cnpj" , emp.getCnpj( ) );
				objeto.put( "razaoSocial" , emp.getRazaoSocial( ) );
				objeto.put( "endereco" , emp.getEndereco( ) );
				objeto.put( "telefone" , emp.getTelefone( ) );
				objeto.put( "abertura" , emp.getHorarioAbertura( ) );
				objeto.put( "fechamento" , emp.getHorarioFechamento( ) );
				objeto.put( "inicioArCondicionado" , ct.getHorarioInicial( ) );
				objeto.put( "fimArCondicionado" , ct.getHorarioFinal( ) );
				objeto.put( "temperaturaArCondicionado" , ct.getTemperaturaMaxima( ) );
				objeto.put( "conjuntoOcupado" , conj.getId( ) );

				vetor.put( objeto );
			}
			catch( JSONException e )
			{
				e.printStackTrace( );
			}			
		}

		return vetor.toString( ); 		
	}


	/**
	 *Método responsavel por montar o JSON
	 *@param HttpServletRequest request
	 *@return sb 
	 */
	public static StringBuilder montaJSon( HttpServletRequest request ) throws IOException
	{
		StringBuilder sb = new StringBuilder( );
		BufferedReader reader = request.getReader( );

		try
		{
			String line;

			while( ( line = reader.readLine( ) ) != null )
				sb.append( line ).append( '\n' );

		}
		finally
		{
			reader.close( );
		}	

		return sb;
	}


	/**
	 *Pega os dados da empresa via aequivo jSon
	 *@param cadeia String
	 * @throws IOException 
	 */
	public static Empresa jSonToEmpresa( String cadeia ) throws IOException
	{
		try
		{
			JSONObject registro = new JSONObject( cadeia );

			String cnpj = registro.getString( "cnpj" );
			String razaoSocial = registro.getString( "razaoSocial" );
			String endereco = registro.getString( "endereco" );
			String telefone = registro.getString( "telefone" );
			String horarioAbertura = registro.getString( "abertura" );
			String horarioFechamento = registro.getString( "fechamento" );

			//Instancia um novo objeto
			Empresa empresa = new Empresa( );

			empresa.setCnpj( cnpj );
			empresa.setRazaoSocial( razaoSocial );
			empresa.setEndereco( endereco );
			empresa.setTelefone( telefone );
			empresa.setHorarioAbertura( horarioAbertura );
			empresa.setHorarioFechamento( horarioFechamento );

			return empresa;

		}
		catch( JSONException jsone )
		{
			jsone.printStackTrace( );
			throw new IOException( jsone );
		}		
	}//Fim do metodo

	/**
	 *Pega os dados do controle de temperatura via arquivo jSon
	 * *@param cadeia String
	 * @throws IOException
	 */
	public static ControleTemperatura jSonToControle( String cadeia ) throws IOException
	{
		try
		{
			JSONObject registro = new JSONObject( cadeia );

			String inicioArCondicionado = registro.getString( "inicioArCondicionado" );
			String fimArCondicionado = registro.getString( "fimArCondicionado" );
			short temperatura = ( short )registro.getInt( "temperaturaArCondicionado" ) ;

			//Instancia objeto
			ControleTemperatura controle = new ControleTemperatura( );

			controle.setHorarioInicial( inicioArCondicionado );
			controle.setHorarioFinal( fimArCondicionado );
			controle.setTemperaturaMaxima( temperatura );

			return controle;

		}
		catch( JSONException e )
		{
			e.printStackTrace( );
			throw new IOException( e );
		}
	}//Fim do metodo

	/**
	 *Pega os dados do conjunto via arquivo jSon
	 * *@param cadeia String
	 * @throws IOException
	 */
	public static Conjunto jSonToConjunto( String cadeia ) throws IOException
	{
		try
		{
			JSONObject registro = new JSONObject( cadeia );

			int id = registro.getInt( "conjuntoOcupado" );

			//Instancia objeto
			Conjunto conjunto = new Conjunto( );

			conjunto.setId( id );


			return conjunto;
		}
		catch( JSONException e )
		{
			e.printStackTrace( );
			throw new IOException( e );
		}
	}//Fim do metodo

	/**
	 *Retorna os dados do objeto
	 *@return objeto: String
	 *@param empresa : Empresa , controle : ControleTemperatura , conjunto : Conjunto
	 *@throws IOException
	 */
	public static String dadosToJSon( Empresa empresa , ControleTemperatura controle , Conjunto conjunto ) throws IOException
	{
		JSONObject objeto = new JSONObject( );
		
		try
		{
			objeto.put( "cnpj" , empresa.getCnpj( ) );
			objeto.put( "razaoSocial" , empresa.getRazaoSocial( ) );
			objeto.put( "endereco" , empresa.getEndereco( ) );
			objeto.put( "telefone" , empresa.getTelefone( ) );
			objeto.put( "abertura" , empresa.getHorarioAbertura( ) );
			objeto.put( "fechamento" , empresa.getHorarioFechamento( ) );
			objeto.put( "inicioArCondicionado" , controle.getHorarioInicial( ) );
			objeto.put( "fimArCondicionado" , controle.getHorarioFinal( ) );
			objeto.put( "temperaturaArCondicionado" , controle.getTemperaturaMaxima( ) );
			objeto.put( "conjuntoOcupado" , conjunto.getId( ) );

		}
		catch( JSONException e )
		{
			e.printStackTrace( );
		}			


	return objeto.toString( ); 		

}



	/**
	 *Retorna a Exception no arquivo jSon
	 */
	public static String errorToJSon( Exception e )
	{
		JSONObject object = new JSONObject( );
		try 
		{
			object.put( "error" , e.toString( ) );
		}
		catch ( JSONException e1 ) 
		{
			e.printStackTrace();
		}
		return object.toString();

	}

}//Fim da classe