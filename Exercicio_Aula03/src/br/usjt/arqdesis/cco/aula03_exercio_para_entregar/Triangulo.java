package br.usjt.arqdesis.cco.aula03_exercio_para_entregar;

public class Triangulo extends Poligono
{
	//Construtor Padrao
	public Triangulo( )
	{
		this( 0.0 , 0.0 );
	}

	//Construtor Não Padrão
	public Triangulo( double base , double altura )
	{
		super( base , altura );
	}


	@Override
	public double area( )
	{
		return super.area( ) / 2 ;
	}

	@Override
	public double perimetro( )
	{
		Retangulo r  = new Retangulo( getAltura( ) , getBase( ) );
		return getBase( ) + getAltura( ) + r.diagonal( ) ;
	}

	@Override
	public String toString( ) 
	{
		return "Triangulo [area() = " + area( ) + ", perimetro() = "
				+ perimetro() + "]";
	}



}
