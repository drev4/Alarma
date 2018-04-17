/**
 * @(#) Estados.java
 */

package es.unican.is2.practica3.despertador;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

// TODO: Auto-generated Javadoc
/**
 * The Class Estados.
 */
public abstract class Estados
{
	
	private static Programado p = new Programado();
	
	private static SinProgramar sp = new SinProgramar();

	private static Snooze sn = new Snooze();
	
	private static Sonando so = new Sonando();

	/**
	 * Iniciamos el Estado
	 *
	 * @param context contexto del sistema, objeto de la clase Despertador
	 * @return Estado actual
	 */
	public static Estados init(Despertador context){
		sp.entryAction(context);
		return sp;
	}
	
	public void entryAction(Despertador context){};
	public void entryAction(Despertador context, int h, int m, int s){};
	public void entryAction(Despertador context, int sn){};

	public void exitAction(Despertador context){};
	
	public void snooze(Despertador context, int s){};
	
	/*
	 * El metodo buzz activa o desactiva la radio en funcion de su estado actual
	 */
	public void buzz(Despertador context){
		if (context.getBuzz()) {
			context.setBuzz(false);
			JOptionPane.showMessageDialog(null, "Radio desactivada");
		}else{
			context.setBuzz(true);
			JOptionPane.showMessageDialog(null, "Radio activada");
		}
	};
	
	public void stop(Despertador context){};
	
	public void alarmaOn(Despertador context, int h, int m, int s){};
	
	public void alarmaOff(Despertador context, JPanel panel){};
	
	/**
	 * Gets Programado.
	 *
	 * @return Estado Programado
	 */
	public static Programado getP() {
		return p;
	}
	
	/**
	 * Gets Snooze.
	 *
	 * @return Estado Snooze
	 */
	public static Snooze getSn() {
		return sn;
	}
	
	/**
	 * Gets Sonando.
	 *
	 * @return Estado Sonando
	 */
	public static Sonando getSo() {
		return so;
	}
	
	/**
	 * Gets the SinProgramar.
	 *
	 * @return Estado SinProgramarPr
	 */
	public static SinProgramar getSp() {
		return sp;
	}
}
