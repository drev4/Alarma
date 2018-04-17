using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Timers;

namespace WindowsFormsApplication4
{
    public class Programada : Estado
    {
        private Timer t1;
        private Alarma alarma;
        public override void alarmaOff(Alarma context)
        {

            context.Estado = getNoProgramada();
            getNoProgramada().entryAction(context);

        }

        public override void alarmaOn(Alarma context, int h, int m)
        {
            this.entryAction(context);
        }

        public override void entryAction(Alarma context)
        {
            alarma = context;
            t1 = new Timer();
            t1.Elapsed += timer_Elapsed;
            t1.Interval = 1000;
            t1.Start();
        }

        void timer_Elapsed(object sender, ElapsedEventArgs e)
        {
            if (DateTime.Now > alarma.alarma)
            {
                exitAction(alarma);
                t1.Stop();
            }
        }

        public override void entryAction(Alarma context, int sz)
        {
            throw new NotImplementedException();
        }

        public override void entryAction(Alarma context, int h, int m)
        {
            throw new NotImplementedException();
        }

        public override void exitAction(Alarma context)
        {
            context.Estado = getSonando();
            getSonando().entryAction(context);
        }

        public override void snooze(Alarma context, int inter)
        {
            throw new NotImplementedException();
        }

        public override void stop(Alarma context)
        {
            throw new NotImplementedException();
        }
    }
}