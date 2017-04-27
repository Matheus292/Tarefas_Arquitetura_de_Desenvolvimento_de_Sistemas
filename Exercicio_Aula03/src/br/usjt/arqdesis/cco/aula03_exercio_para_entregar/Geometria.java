package br.usjt.arqdesis.cco.aula03_exercio_para_entregar;

import java.util.ArrayList;
import java.util.List;

public class Geometria 
{

	public static void main( String[ ] args ) 
	{
		List< Figura > figura = new ArrayList< >( );

		figura.add( new Circulo( 5.0 ) );
		figura.add( new Retangulo( 6.0 , 7.0 ) );
		figura.add( new Quadrado( 4.0 ) );
		figura.add( new Triangulo( 5.0 , 2.0 ) );
		figura.add( new Losango( 3.0 ,  2.0 ) );
		figura.add( new Trapezio( 2.0 , 4.0 , 5.0 ) );

		for( Figura fig : figura )
			System.out.println( fig );

		List< Poliedro > volumes = new ArrayList< >( );

		volumes.add( new Cubo( 5.0 ) );
		volumes.add( new Piramide( 3.0 , 4.0 ) );
		volumes.add( new Cilindro( 5.0 , 4.0 ) );
		volumes.add( new Esfera( 5.0 ) );
		
		for( Poliedro v : volumes )
			System.out.println( v );

	}

}
