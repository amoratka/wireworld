/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package wireworld;

import java.awt.Color;
import static java.awt.Color.red;
import static java.awt.Color.yellow;
import static sun.misc.VM.getState;

/**
 *
 * @author Kamilka
 */
public class Przewodnik implements Stan {
    private Color kolor;
    private int symbol;
    private Stan stanKomórki;

    /**
     *
     */
    @Override
    public void wyświetlStan() {
        System.out.println(" Stan : Przewodnik");
    }

   

    @Override
    public Color kolor() {
        this.kolor=yellow;
        return yellow;
    }

    @Override
    public int symbol() {
        this.symbol = 4;
        return 4;
    }

    @Override
    public Stan nastepnyStan(int ilość) {
        Stan Głowa= new Głowa();
        if(ilość==1||ilość==2) return new Głowa();
        else return new Przewodnik();
    }
    
}
