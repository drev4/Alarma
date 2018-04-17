using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Windows.Forms;

namespace WindowsFormsApplication4
{
    public abstract class Estado
    {
        private static NoProgramada np = new NoProgramada();
        private static Programada p = new Programada();
        private static Snooze sz = new Snooze();
        private static Sonando so = new Sonando();

        public static Estado init(Alarma context)
        {
            np.entryAction(context);
            return np;
        }

        abstract public void entryAction(Alarma context);
        abstract public void entryAction(Alarma context, int h, int m);
        abstract public void entryAction(Alarma context, int sz);

        abstract public void exitAction(Alarma context);

        abstract public void snooze(Alarma context, int inter);

        public void buzz(Alarma context) {
            if (context.buzz)
            {
                context.buzz = false;
                MessageBox.Show("Radio desactivada");
            }else
            {
                context.buzz = true;
                MessageBox.Show("Radio activada");
            }
        }

        abstract public void stop(Alarma context);

        abstract public void alarmaOn(Alarma context, int h, int m);
        abstract public void alarmaOff(Alarma context);

        public Estado getNoProgramada() { return np; }
        public Estado getProgramada() { return p; }
        public Estado getSnooze() { return sz; }
        public Estado getSonando() { return so; }




    }
}