package wireworld;

import java.awt.Color;
import static java.awt.Color.yellow;

public class Przewodnik implements Stan {

    private Color kolor;
    private int symbol;
    private Stan stanKomórki;


    @Override
    public Color kolor() {
        this.kolor = yellow;
        return yellow;
    }

    @Override
    public int symbol() {
        this.symbol = 4;
        return 4;
    }

    @Override
    public Stan nastepnyStan(int ilość) {
        Stan Głowa = new Głowa();
        if (ilość == 1 || ilość == 2) {
            return new Głowa();
        } else {
            return new Przewodnik();
        }
    }

}
