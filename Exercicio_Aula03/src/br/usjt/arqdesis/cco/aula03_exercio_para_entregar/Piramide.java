package br.usjt.arqdesis.cco.aula03_exercio_para_entregar;

public class Piramide implements Poliedro
{
	//Atributo
	private Quadrado quadrado;
	private double alturaPiramide;

	//Construtor Padrão
	public Piramide( )
	{
		this( 0.0 , 0.0 );
	}

	//Construtor Não Padrão
	public Piramide( double ladoBase , double alturaPiramide )
	{
		quadrado = new Quadrado( ladoBase );
		setAlturaPiramide( alturaPiramide );
	}

	public double getAlturaPiramide( )
	{
		return alturaPiramide;
	}

	public void setAlturaPiramide( double alturaPiramide )
	{
		this.alturaPiramide = ( alturaPiramide >= 0.0 ? alturaPiramide : 0.0 );
	}

	@Override
	public double volume( ) 
	{
		return ( 1.0 / 3.0 ) * ( quadrado.area( ) * getAlturaPiramide( ) );
	}

	@Override
	public String toString( ) 
	{
		return "Piramide [volume() = " + volume( ) + "]";
	}
	
	

}