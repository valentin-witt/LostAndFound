package Timer;

import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;

public class CountDownTimerExample_3 {
    //declare tk and t
    Toolkit tk;
    Timer t;

    //constructor of CountDownTimerExample class
    public CountDownTimerExample_3() {
        tk = Toolkit.getDefaultToolkit();
        t = new Timer();
        //initial delay and subsequent rate
        t.schedule(new rt(), 0, 1 * 1000);
    }

    public static void main(String args[]) {
        System.out.println("Task is going to start. . .");
        new CountDownTimerExample_3();
        System.out.println("Task that is set up is scheduled. . .");
    }

    class rt extends TimerTask {
        //declare a variable beep
        int beep = 3;

        //task to be performed
        public void run() {
            //if BEEP VARIABLE IS GREATER THAN ZERO
            if (beep > 0) {
                //perform beep operation and print after each second
                tk.beep();
                System.out.println("One second over . . . Beep!");
                //decrement the value beep
                beep--;
            }
            //if beep variable is less than zero
            else {
                tk.beep();
                System.out.println("The Time's over. . .!");
                //AWT thread stops
                System.exit(0);
            }
        }
    }
}