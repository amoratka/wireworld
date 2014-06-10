package wireworld;

import java.awt.Color;

/**
 *
 * @author Kamilka
 */
public interface Stan {
    

    public void wyświetlStan();

    public Color kolor();

    public int symbol();
    
    public Stan nastepnyStan( int ilość);
   
   

}
