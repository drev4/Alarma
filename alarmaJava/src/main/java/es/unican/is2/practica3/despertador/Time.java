/**
 * @(#) Time.java
 */

package es.unican.is2.practica3.despertador;


import java.util.Calendar;

/**
 * The Class Time.
 */
public class Time
{
	
	
	private Calendar alarma = Calendar.getInstance(); //Calendario que tendra el momento en el que sonara la alarma
	
	/**
	 * Constructor de la clase Time
	 *
	 * @param hora integer que indica la hora en la que la alarma sonara
	 * @param min integer que indica el minuto en el que sonara la alarma
	 * @param seg integer que indica el segundo en el que sonara la alarma
	 */
	public Time(int hora, int min, int seg) {
		//Seteamos la alarma con los parametros introducidos
		setAlarma1(hora, min, seg);

	}
	
	/**
	 * Gets the alarma.
	 *
	 * @return the alarma
	 */
	public Calendar getAlarma() {
		return alarma; 
	}
	
	/**
	 * Setea la el momento en el que sonara la alarma dentro del calendario
	 *
	 * @param hora hora de la alarma
	 * @param min minuto de la alarma
	 * @param seg segundo de la alarma
	 */
	private void setAlarma1(int hora, int min, int seg) {
		//Obtenemos los valores de año, mes y dia actuales
		int year = Calendar.getInstance().get(Calendar.YEAR);
		int month = Calendar.getInstance().get(Calendar.MONTH);
		int day = Calendar.getInstance().get(Calendar.DATE);
		//Seteamos la alarma en el calendario del dia actual
		alarma.set(year, month, day, hora, min, seg);
		
		//Si el momento seleccionado es anterior al actual, la alarma se setea para el dia siguiente
		if(hora < Calendar.getInstance().get(Calendar.HOUR)){
			alarma.add(Calendar.DATE, 1);
			
		}else if(hora == Calendar.getInstance().get(Calendar.HOUR)){
			if(min < Calendar.getInstance().get(Calendar.MINUTE)){
				alarma.add(Calendar.DATE, 1);
			}
		}
		
	}

}
