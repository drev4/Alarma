/**
 * @(#) SinProgrmar.java
 */

package es.unican.is2.practica3.despertador;

import javax.swing.JOptionPane;

public class SinProgramar extends Estados
{
	public SinProgramar() {
		
	}
	@Override
	public void entryAction(Despertador context) {
		context.setHoraProgramada(null);
		JOptionPane.showMessageDialog(null, "La alarma no esta programada");
	}
	
	@Override
	public void exitAction(Despertador context) {
		context.setE(getP());
	}
	
	@Override
	public void alarmaOn(Despertador context, int h, int m, int s) {
		
		this.exitAction(context);
		getP().entryAction(context, h, m, s);
		
	}
	
	
}
