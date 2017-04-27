package br.usjt.arqdesis.cco.aula03_exercio_para_entregar;

public abstract class Poligono extends Figura 
{

	//Atributos
	private double altura , base ;

	//Construtor não padrão
	public Poligono( double base , double altura ) 
	{
		setAltura( altura );
		setBase( base );
	}

	/*******************************Gets e Sets******************************************/
	public double getAltura( )
	{
		return altura;
	}

	public void setAltura( double altura )
	{
		this.altura = ( altura < 0.0 ? 0.0 : altura );
	}

	public double getBase( ) 
	{
		return base;
	}

	public void setBase( double base )
	{
		this.base = ( base < 0.0 ? 0.0 : base);
	}
	/*************************************************************************************/
	@Override
	public double area( )
	{
		return getBase( ) * getAltura( );
	}

}//Fim da Classe