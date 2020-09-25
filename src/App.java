import javax.swing.*;
import java.awt.*;

public class App {
    private static JLabel l = new JLabel("0");
    private static Spammer spammer;
    private static boolean stop = false;
    private static int seconds = -1;

    public static void main(String[] args) throws AWTException {

        JFrame f = new JFrame("Robot");
        JButton b = new JButton("Stop");

        b.setBounds(50, 100, 95, 30);
        l.setLocation(0,0);
        l.setBounds(100,100,100,100);
        f.add(b);
        f.add(l);
        f.setSize(400, 400);
        f.setLayout(null);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        b.addActionListener(actionEvent -> {
            if(stop) b.setText("Start");
            else  b.setText("Stop");

            stop = !stop;
        });

        spammer = new Spammer(new Timer(1000, e -> {
            seconds++;
            if (seconds == 60){
                seconds = 0;
                if (!stop){
                    spammer.run();
                }
            }
            l.setText(String.format("%d",seconds));

        }));
        stop = false;
        spammer.run();
    }
}
