package br.usjt.arqdesis.cco.aula03_exercio_para_entregar;

public class Esfera implements Poliedro 
{

	//Atributo
	private Circulo circulo;
	
	//Construtor Padrão
	public Esfera( )
	{
		this( 0.0 );
	}
	
	//Construtor Não Padrão
	public Esfera( double raio )
	{
		circulo = new Circulo( raio );
	}
	
	@Override
	public double volume( ) 
	{
		return ( 4.0 / 3.0 ) * Math.pow( circulo.getRaio( ) , 3 ) * Math.PI; 
	}

	@Override
	public String toString( )
	{
		return "Esfera [volume() = " + volume( ) + "]";
	}
}//Fim da Classe