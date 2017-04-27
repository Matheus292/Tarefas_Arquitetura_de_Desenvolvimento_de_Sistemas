package br.usjt.arqdesis.cco.aula03_exercio_para_entregar;

public class Retangulo extends Poligono implements Diagonal 
{

	//Construtor Padrao
	public Retangulo( )
	{
		this( 0.0 , 0.0 );
	}
	
	//Construtor Não Padrão
	public Retangulo( double base , double altura )
	{
		super( base , altura );
	}
	
	@Override
	public  double diagonal( ) 
	{
		return Math.sqrt( Math.pow( getBase( ) , 2 ) + Math.pow( getAltura( ) , 2 ) );
	}

	@Override
	public double perimetro( ) 
	{
		return 2 * getAltura( ) + 2 * getBase( ) ;
	}

	@Override
	public String toString( ) 
	{
		return "Retangulo [diagonal() = " + diagonal( ) + ", perimetro() = "
				+ perimetro( ) + ", area() = " + area( ) + "]";
	}
}//Fim da Classe