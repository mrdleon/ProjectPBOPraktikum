package thread;

import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JLabel;

public class ClockThread extends Thread {

    private JLabel labelJam;

    public ClockThread(JLabel labelJam) {

        this.labelJam = labelJam;

    }

    @Override
    public void run() {

        while(true) {

            Date date = new Date();

            SimpleDateFormat sdf =
                    new SimpleDateFormat("HH:mm:ss");

            javax.swing.SwingUtilities.invokeLater(() -> {

                labelJam.setText(
                        sdf.format(date)
                );

            });

            try {

                Thread.sleep(1000);

            } catch(Exception e) {

                System.out.println(e.getMessage());

            }

        }

    }

}