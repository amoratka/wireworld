package wireworld;

import java.awt.Color;
import static java.awt.Color.black;

public class Pusta implements Stan {

    private Color kolor;
    private int symbol;
    private Stan stanKomórki;

    public Color kolor() {
        this.kolor = black;
        return black;
    }

    @Override
    public int symbol() {
        this.symbol = 0;
        return 0;
    }

    @Override
    public Stan nastepnyStan(int ilość) {
        return new Pusta();
    }
}
