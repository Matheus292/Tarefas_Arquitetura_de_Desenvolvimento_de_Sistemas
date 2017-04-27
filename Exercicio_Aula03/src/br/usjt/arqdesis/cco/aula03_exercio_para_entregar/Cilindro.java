package br.usjt.arqdesis.cco.aula03_exercio_para_entregar;

public class Cilindro implements Poliedro 
{

	//Atributo
	private Circulo circulo ;
	private Retangulo retangulo;
	
	//Construtor Padrão	
	public Cilindro( ) 
	{
		this( 0.0 , 0.0 );
	}
	
	//Construtor Não Padrão
	public Cilindro( double raio , double altura )
	{
		retangulo = new Retangulo( );
		circulo = new Circulo( raio );
				
		retangulo.setAltura( altura );
	}
		
	@Override
	public double volume( )
	{
		return Math.pow( circulo.getRaio( ) , 3 ) * Math.PI * retangulo.getAltura( );
	}

	@Override
	public String toString( )
	{
		return "Cilindro [volume() = " + volume( ) + "]";
	}
	
}