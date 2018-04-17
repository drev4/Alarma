using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Windows.Forms;

namespace WindowsFormsApplication4
{
    public class NoProgramada : Estado
    {
        public NoProgramada() { }

        public override void entryAction(Alarma context)
        {
            context.alarma = new DateTime();
            MessageBox.Show("Alarma no programada");
        }
        public override void exitAction(Alarma context)
        {
            context.Estado = getProgramada();
        }
        public override void alarmaOn(Alarma context, int h, int m)
        {
            this.exitAction(context);
            getProgramada().entryAction(context, h, m);
        }
    }
}