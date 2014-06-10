/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package wireworld;

import java.awt.Color;
import static java.awt.Color.black;

/**
 *
 * @author Kamilka
 */
public class Pusta implements Stan {
    private Color kolor;
    private int symbol;
    private Stan stanKomórki;

    /**
     *
     */
    @Override
    public void wyświetlStan() {
        System.out.println(" Stan : Pusta");
    }

    public Color kolor() {
        this.kolor=black;
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
