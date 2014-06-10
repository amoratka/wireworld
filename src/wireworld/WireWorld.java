package wireworld;

import java.io.IOException;
import javax.swing.SwingUtilities;

/**
 *
 * @author Kamilka
 */
public class WireWorld {

    public static void main(String[] args) throws IOException, InterruptedException {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                Wyświetlacz w = new Wyświetlacz();
                w.setVisible(true);
            }

        });

    }
}
