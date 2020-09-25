
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

public class Spammer {
    public static String sentences[] = {"GG just ranking up","rank","nah g stfu already","not spamming ranking up g","Banging your head against a wall for one hour burns 150 calories","In Switzerland it is illegal to own just one guinea pig"
                                        ,"The oldest your mom joke was discovered on a 3,500 year old Babylonian tablet","Cherophobia is an irrational fear of fun or happiness",
                                         "7% of American adults believe that chocolate milk comes from brown cows","Ronald McDonald is Donald McDonald in Japan because it makes pronunciation easier for the Japanese"};
    public Robot robot;
    public int idx = 0;
    public Timer timer ;
    private boolean first = true;

    public Spammer(Timer timer) throws AWTException {
        robot = new Robot();
        this.timer = timer;
    }

    public void run() {
        if(first) timer.start();
        first = false;
        if(idx >= sentences.length)idx=0;
        sentenceToKeyPress(sentences[idx++]);
    }


    private void sentenceToKeyPress(String s){

            for (int i = 0; i < s.length(); i++) {
                int keycode = KeyEvent.getExtendedKeyCodeForChar(s.charAt(i));
                if(keycode <= 90 && keycode > 8){
                    robot.keyPress(keycode);
                    robot.keyRelease(keycode);
                }
            }

            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);

    }
}
