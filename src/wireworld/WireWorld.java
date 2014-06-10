package wireworld;

import java.io.IOException;
import javax.swing.SwingUtilities;
import static wireworld.ObsługaSiatki.nowaSiatka;
import static wireworld.ObsługaSiatki.odczytdanych;
import static wireworld.ObsługaSiatki.zapisz;

/**
 *
 * @author Kamilka
 */
public class WireWorld {
    
    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     * @throws java.lang.InterruptedException
     */
    public static void main(String[] args) throws IOException, InterruptedException {
        // TODO code application logic here
        String nazwa;
        int generacje = 5;
        nazwa = "plik";
    //    Siatka siatka;
      //  siatka = new Siatka();
        //odczytdanych("dane", siatka);
        int i = 0;
    /*    zapisz(siatka, nazwa, i);
        for (i = 1; i < generacje + 1; i++) {
            Siatka nowaSiatka = nowaSiatka(siatka);
            zapisz(nowaSiatka, nazwa, i);
            siatka = nowaSiatka;
        }*/
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                Wyświetlacz w= new Wyświetlacz();
                        w.setVisible(true);
            }

            
        });

    }
}

