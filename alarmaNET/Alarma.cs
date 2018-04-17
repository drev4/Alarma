using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Windows.Forms;

namespace WindowsFormsApplication4
{
    public class Alarma
    {
        public DateTime alarma{ get; set;}
        public bool buzz { get; set; }
        public int intervaloSnooze { get; set; }
        private static int INTERVALO_ALARMA = 30;
        public int contadorSnooze { get; set; }

        public Estado Estado { get; set; }

        public Alarma()
        {
            Estado = Estado.init(this);
        }
        public void activarAlarma()
        {
            MessageBox.Show("Alarma activada");
        }
        public void desactivarAlarma()
        {
            MessageBox.Show("Alarma desactivada");
        }
        public void setEstado(Estado e)
        {
            this.Estado = e;
        }
        public void alarmaOn(int hora, int min)
        {
            Estado.alarmaOn(this, hora, min);
        }
        public void alarmaOff()
        {
            Estado.alarmaOff(this);
        }
        public void stop()
        {
            Estado.stop(this);
        }
        public void snooze(int inter)
        {
            Estado.snooze(this, inter);
        }
        public void changeBuzz()
        {
            Estado.buzz(this);
        }


    }
}