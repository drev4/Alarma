/**
 * @(#) Sonando.java
 */

package es.unican.is2.practica3.despertador;

import java.util.Timer;
import java.util.TimerTask;

public class Sonando extends Estados
{
	Timer t1;
	
	
	public Sonando(){
		
	}
	@Override
	public void entryAction(final Despertador context) {
		context.activarAlarma();
		t1 = new Timer();
		//Intervalo maximo
		
		TimerTask task = new TimerTask() {
			
			@Override
			public void run() {
				
				context.desactivarAlarma();
				context.setE(getSp());
				getSp().entryAction(context);
				
			}
		};
		//Pasar Intervalo a milisegundos
		t1.schedule(task, context.getINTERVALO_ALARMA()*60000);
		
	}
	
	@Override
	public void stop(Despertador context) {
		t1.cancel();
		t1.purge();
		context.desactivarAlarma();
		context.setE(getP());
		context.setContadorSnooze(0);
	}
	
	@Override
	public void snooze(Despertador context, int snooze) {
		t1.cancel();
		//t1.purge();
		
		context.desactivarAlarma();
		context.setContadorSnooze(context.getContadorSnooze()+1);
		
		context.setE(getSn());
		getSn().entryAction(context, snooze);
		
		
	}
	
}
