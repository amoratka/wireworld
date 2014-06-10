package wireworld;

import java.awt.Color;

public class Komórka {

    Stan stanKomórki;
    private Color kolor;
    int symbol;

    public void ustawStan(Stan stan) {
        this.stanKomórki = stan;
        this.symbol = stan.symbol();
    }

    public Stan podajStan() {
        return this.stanKomórki;
    }

    public void wyświetlStan() {
        this.stanKomórki.wyświetlStan();
    }

    public void kolor() {
        this.kolor = stanKomórki.kolor();
    }

    public int symbol() {
        return this.symbol;
    }

}
