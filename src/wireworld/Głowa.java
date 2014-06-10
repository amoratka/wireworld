package wireworld;

import java.awt.Color;
import static java.awt.Color.red;

public class Głowa implements Stan {

    private final Color kolor = red;
    private final int symbol = 2;


    @Override
    public Color kolor() {
        return this.kolor;
    }

    @Override
    public int symbol() {
        return this.symbol;

    }

    @Override
    public Stan nastepnyStan(int ilość) {
        Stan Ogon = new Ogon();
        return new Ogon();
    }

}
