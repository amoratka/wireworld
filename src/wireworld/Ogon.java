package wireworld;

import java.awt.Color;
import static java.awt.Color.blue;

public class Ogon implements Stan {

    private Color kolor;
    private int symbol;

    @Override
    public void wyświetlStan() {
        System.out.println(" Stan : Ogon");
    }

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

    @Override
    public Stan nastepnyStan(int ilość) {
        Stan Przewodnik = new Przewodnik();
        return new Przewodnik();
    }
}
