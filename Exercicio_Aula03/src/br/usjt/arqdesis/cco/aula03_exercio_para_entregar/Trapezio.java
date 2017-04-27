package br.usjt.arqdesis.cco.aula03_exercio_para_entregar;

public class Trapezio extends Poligono 
{
	//Atributo
	private double baseMaior;

	//Construtor Padrão
	public Trapezio( )
	{
		this( 0.0 , 0.0 , 0.0 );
	}	
	
	//Construtor Não Padrão		
	public Trapezio( double baseMenor , double altura , double baseMaior ) 
	{
		super( baseMenor , altura );
		setBaseMaior( baseMaior );
	}

	/******************************Get e Set*************************************************/
	public double getBaseMaior( )
	{
		return baseMaior;
	}

	public void setBaseMaior( double baseMaior )
	{
		this.baseMaior = ( baseMaior <= getBase( ) ? getBase( ) + 1 : baseMaior );
	}
	/****************************************************************************************/

	@Override
	public double area( ) 
	{
		return  ( ( getBase( ) + getBaseMaior( ) ) * getAltura( ) )  / 2 ;
	}
	
	@Override
	public double perimetro( ) 
	{		
		double x = ( getBaseMaior( ) - getBase( ) ) / 2 ;
		Retangulo r = new Retangulo( x , getAltura( ) );
		return ( 2 * r.diagonal( ) ) + getBaseMaior( ) + getBase( ) ;
	}

	@Override
	public String toString( ) 
	{
		return "Trapezio [area() = " + area( ) + ", perimetro() = " + perimetro( ) + "]";
	}
	
	

}
