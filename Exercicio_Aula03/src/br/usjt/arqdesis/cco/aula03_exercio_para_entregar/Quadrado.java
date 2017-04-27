package br.usjt.arqdesis.cco.aula03_exercio_para_entregar;

public class Quadrado extends Poligono implements Diagonal 
{

	//Construtor Padrão
	public Quadrado( )
	{
		this( 0.0 );
	}

	//Construtor Não Padrão
	public Quadrado( double lado )
	{
		super( lado , lado );
	}

	@Override
	public double diagonal( ) 
	{		
		return getBase( ) * Math.sqrt( 2.0 );
	}

	@Override
	public double perimetro( ) 
	{
		return 4 * getBase( );
	}

	@Override
	public String toString( )
	{
		return "Quadrado [diagonal() = " + diagonal( ) + ", perimetro() = " +
				perimetro( ) + ", area() = " + area( ) + "]";
	}
}//Fim da Classe