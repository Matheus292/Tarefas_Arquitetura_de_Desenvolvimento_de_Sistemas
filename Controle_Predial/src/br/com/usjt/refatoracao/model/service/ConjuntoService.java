package br.com.usjt.refatoracao.model.service;

import java.sql.SQLException;
import java.util.List;

import br.com.usjt.refatoracao.model.bean.Conjunto;
import br.com.usjt.refatoracao.model.bean.Empresa;
import br.com.usjt.refatoracao.model.dao.ConjuntoDAO;

public class ConjuntoService 
{
	/**
	 *Construtor Padrão 
	 */
	public ConjuntoService( )
	{
		
	}
	
	/**
	 *Metodo responsavel por trazer todos conjuntos desocupados
	 * @throws SQLException 
	 */
   public List<Conjunto> consultarConjuntoDesocupado( ) throws SQLException
   {
      ConjuntoDAO dao = new ConjuntoDAO( );		
      return dao.consultarConjuntoDesocupado( );
   }
	
	/**
	 *Metodo que altera os conjuntos desocupado para ocupado
	 */
   public boolean ocuparConjuntos( List<Conjunto> conjuntos , Empresa empresa ) throws SQLException
   {
      ConjuntoDAO dao = new ConjuntoDAO( );
      return dao.ocuparConjuntos( conjuntos , empresa );
   }
   

	/**
	 *Metodo que altera os conjuntos ocupado para desocupado
	 */
  public boolean desocuparConjuntos( List<Conjunto> conjuntos  ) throws SQLException
  {
     ConjuntoDAO dao = new ConjuntoDAO( );
     return dao.desocuparConjuntos( conjuntos );
  }

  public boolean desocuparConjuntos( String cnpj  ) throws SQLException
  {
     ConjuntoDAO dao = new ConjuntoDAO( );
     return dao.desocuparConjuntos( cnpj );
  }
  
  
  
	/**
	 *Responsavel por mostrar todos os conjuntos pertecentes a alguma empresa
	 *@param empresa
	 *@return conjuntos
	 * @throws SQLException 
	 */
	public List<List<Conjunto>> consultarConjuntoOcupado( List<Empresa> empresa ) throws SQLException
	{
	   ConjuntoDAO dao = new ConjuntoDAO( );
	   return dao.consultarConjuntoOcupado( empresa );
   }
	
	/**
	 *Responsavel por mostrar todos os conjuntos pertecentes a alguma empresa
	 *@param empresa
	 *@return conjuntos
	 * @throws SQLException 
	 */
	public Conjunto consultarConjuntoOcupado( Empresa empresa ) throws SQLException
	{
		ConjuntoDAO dao = new ConjuntoDAO( );
		return dao.consultarConjuntoOcupado( empresa );
	}
}//Fim da classe