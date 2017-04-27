package br.usjt.arqdesis.cco.aula03_exercio_para_entregar;

public class Cubo implements Poliedro 
{
	//Atributo
	private Quadrado quadrado;

	//Construtor Padrao
	public Cubo( )
	{
		this( 0.0 );
	}
	
	//Construtor Não Padrão
	public Cubo( double lado )
	{
		quadrado = new Quadrado( lado );
	}
	
	@Override
	public double volume( )
	{
		return Math.pow( quadrado.getBase( ) ,  3 );
	}

	@Override
	public String toString( ) 
	{
		return "Cubo [volume() = " + volume( ) + "]";
	}
	
	

}
