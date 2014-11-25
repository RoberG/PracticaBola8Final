package com.example.android02;

import java.util.Random;

import android.content.res.Resources;
import android.view.View;
import android.widget.TextView;

public class MagicBall {
	
	private String[] respuestas;
	private Random aleatorio;
	private String respElegida;
	
	private static String color;

	public MagicBall() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public  String getPrediccion(Resources res)
    {
    	/*String respuesta="si";//1 MODO
		texto.setText(respuesta);*/
		
		/*String[] respuestas = new String[]//2 MODO
		{"En mi opinión, sí",
			"Es cierto",
			"Es decididamente así",
			"Probablemente",
			"Buen pronóstico",
			"Todo apunta a que sí",
			"Sin duda",
			"Sí",
			"Sí - definitivamente",
			"Debes confiar en ello",
			"Respuesta vaga, vuelve a intentarlo",
			"Pregunta en otro momento",
			"Será mejor que no te lo diga ahora",
			"No puedo predecirlo ahora",
			"Concéntrate y vuelve a preguntar",
			"No cuentes con ello",
			"Mi respuesta es no",
			"Mis fuentes me dicen que no",
			"Las perspectivas no son buenas",
			"Muy dudoso"};*/
    	

    	respuestas = res.getStringArray(R.array.respuestas);//3 MODO
		aleatorio = new Random();
		respElegida=respuestas[aleatorio.nextInt(20)];
		return(respElegida);
    }
	
	public String color()
	{
		int i=0;
		String[] soluciones = new String[]
					{"En mi opinión, sí",
					"Es cierto",
					"Es decididamente así",
					"Probablemente",
					"Buen pronóstico",
					"Todo apunta a que sí",
					"Sin duda",
					"Sí",
					"Sí - definitivamente",
					"Debes confiar en ello",
					"Respuesta vaga, vuelve a intentarlo",
					"Pregunta en otro momento",
					"Será mejor que no te lo diga ahora",
					"No puedo predecirlo ahora",
					"Concéntrate y vuelve a preguntar",
					"No cuentes con ello",
					"Mi respuesta es no",
					"Mis fuentes me dicen que no",
					"Las perspectivas no son buenas",
					"Muy dudoso"};
		
		while(!soluciones[i].equals(respElegida))
		{
			i++;
		}
		if(i<=9)
		{
			color="verde";
		}
		else
		{
			if(i>=10 && i<=16)
			{
				color="amarillo";
			}
			else
			{
				color="rojo";
			}
		}
		
		return(color);
	}

}
