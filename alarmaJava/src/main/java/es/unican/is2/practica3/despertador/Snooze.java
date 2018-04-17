/**
 * @(#) Snooze.java
 */

package es.unican.is2.practica3.despertador;

import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JOptionPane;

public class Snooze extends Estados
{
	Timer t1;
	public Snooze(){
		
	}
	@Override
	public void entryAction(final Despertador context, int snooze) {
		if (context.getContadorSnooze() > 3) {
			this.stop(context);
		}else{
			t1 = new Timer();
			TimerTask task = new TimerTask() {
				
				@Override
				public void run() {
					
					context.setE(getSo());
					getSo().entryAction(context);
				}
			};
			
			t1.schedule(task, snooze*60000);
			
			JOptionPane.showMessageDialog(null, "La alarma volvera a asonar en " + snooze + " minutos");
		}
	}
	
	@Override
	public void stop(Despertador context) {
		t1.cancel();
		t1.purge();
		context.setE(getP());
		context.setContadorSnooze(0);
	}
	
}
