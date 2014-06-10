package wireworld;

import java.awt.Color;

/**
 *
 * @author Kamilka
 */
public class Komórka {

    Stan stanKomórki;
    private Color kolor;
    int symbol;

    public void setState(Stan stan) {
        this.stanKomórki = stan;
        this.symbol=stan.symbol();
    }

    public Stan getState() {
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
