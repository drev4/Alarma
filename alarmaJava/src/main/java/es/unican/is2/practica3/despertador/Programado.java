/**
 * @(#) Programado.java
 */

package es.unican.is2.practica3.despertador;

import java.awt.Color;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Programado extends Estados
{
	private Timer t1; //Timer que se ejecutar en el momento indicado por el usuario
	private Time aux; //Alarma del usuario
	
	public Programado() {
	}
	@Override
	public void entryAction(final Despertador context, int h, int m, int s) {
		
		aux = new Time(h, m, s);
		context.setHoraProgramada(aux);
		t1 = new Timer();
		
		
		
		TimerTask task = new TimerTask() {
			
			@Override
			public void run() {
				exitAction(context);
			}
		};
		t1.scheduleAtFixedRate(task, aux.getAlarma().getTime(), 86400000);//1 dia en ms
		
		JOptionPane.showMessageDialog(null, "Alarma creada correctamente para el " + aux.getAlarma().getTime());
	}
	
	@Override
	public void exitAction(Despertador context) {
		context.setE(getSo());
		getSo().entryAction(context);
	}
	
	@Override
	public void alarmaOff(Despertador context, JPanel pan) {
		
		pan.setBackground(Color.BLUE);
		context.setE(getSp());
		getSp().entryAction(context);
		aux = null;
		
		t1.cancel();
		t1.purge();
	}
	
	@Override
	public void alarmaOn(Despertador context, int h, int m, int s) {
		this.entryAction(context, h, m, s);
	}
	
	
}
