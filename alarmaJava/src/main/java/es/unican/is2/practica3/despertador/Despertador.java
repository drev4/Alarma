/**
 * @(#) Despertador.java
 */

package es.unican.is2.practica3.despertador;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Despertador
{
	private Time horaProgramada;
	
	private boolean buzz;
	
	private int intervaloSnooze;
	
	private static int INTERVALO_ALARMA = 30;
	
	private int contadorSnooze;
	
	private Estados e;
		
	public Despertador() {
		e = Estados.init(this);
	}
	public void activarAlarma( )
	{
		JOptionPane.showMessageDialog(null, "Alarma Sonando");
	}
	
	public void desactivarAlarma( )
	{
		JOptionPane.showMessageDialog(null, "La alarma ya no esta sonando");
	}
	
	public void setE(Estados e) {
		this.e = e;
	}
	
	public void alarmaOn(int i, int j, int k) {
		e.alarmaOn(this, i, j, k);
	}
	
	public void alarmaOff(JPanel panel) {
		e.alarmaOff(this, panel);
	}
	
	public void stop() {
		e.stop(this);
	}
	
	public void snooze(int i) {
		e.snooze(this,i);
	}
	
	public void buzz() {
		e.buzz(this);
	}
	
	public void setHoraProgramada(Time horaProgramada) {
		this.horaProgramada = horaProgramada;
	}
	
	public Time getHoraProgramada() {
		return horaProgramada;
	}
	
	public static int getINTERVALO_ALARMA() {
		return INTERVALO_ALARMA;
	}
	
	public void setContadorSnooze(int contadorSnooze) {
		this.contadorSnooze = contadorSnooze;
	}
	public int getContadorSnooze() {
		return contadorSnooze;
	}
	
	public boolean getBuzz(){
		return buzz;
	}
	public void setBuzz(boolean buzz) {
		this.buzz = buzz;
	}
	public Estados getEstado() {
		return e;
	}
	
}
