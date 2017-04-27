package br.usjt.arqdesis.cco.aula03_exercio_para_entregar;

public class Losango extends Poligono
{
	//Construtor Padrão
	public Losango( )
	{
		this( 0.0 , 0.0 );
	}

	//Construtor Não Padrão
	public Losango( double base , double altura )
	{
		super( base , altura );	
	}

	@Override
	public double perimetro( )
	{
		return 4 * getBase( );
	}

	@Override
	public String toString( ) 
	{
		return "Losango [perimetro() = " + perimetro( ) + ", area() = " + area( ) + "]";
	}
	
}//Fim da Classe