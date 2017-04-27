package br.usjt.arqdesis.cco.aula03_exercio_para_entregar;

public class Circulo extends Figura 
{
	//Atributos
	private double raio;
	
	
	//Construtor Padrão
	public Circulo( )
	{
		this( 0.0 );
	}
	
	//Construtor Não Padrão
	public Circulo( double raio )
	{
		setRaio( raio );
	}
	
	/********************Gets e Sets*****************************************************/
	public double getRaio( )
	{
		return raio;
	}

	public void setRaio( double raio )
	{
		this.raio = raio;
	}

	/************************************************************************************/
	@Override
	public double area( ) 
	{
		return Math.PI * Math.pow( getRaio( ) , 2 );
	}

	@Override
	public double perimetro( )
	{
		return 2 * Math.PI * getRaio( );
	}

	
	@Override
	public String toString( )
	{
		return "Circulo [area() = " + area( ) + ", perimetro() = " + perimetro( ) + "]";
	}
}//Fim da classe