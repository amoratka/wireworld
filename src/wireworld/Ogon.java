package wireworld;

import java.awt.Color;
import static java.awt.Color.blue;
import static java.awt.Color.red;

/**
 *
 * @author Kamilka
 */
public class Ogon implements Stan {

    private Color kolor;
    private int symbol;

    /**
     *
     */
    @Override
    public void wyświetlStan() {
        System.out.println(" Stan : Ogon");
    }

    // public void kolor() {
    //   System.out.println( "Kolor : niebieski");
    // }
    @Override
    public Color kolor() {
        this.kolor = blue;
        return blue;
    }

    @Override
    public int symbol() {
        this.symbol = 1;
        return 1;
    }

    /**
     *
     * @param ilość
     * @return
     */
    @Override
    public Stan nastepnyStan(int ilość) {
        Stan Przewodnik = new Przewodnik();
        return new Przewodnik();
    }
}
