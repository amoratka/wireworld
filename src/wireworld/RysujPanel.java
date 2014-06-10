package wireworld;

import java.awt.Color;
import java.awt.Graphics;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;

class RysujPanel extends JPanel {

    int wymiar = 20;
    Siatka siatka = new Siatka();

    private void rysuj(Graphics g) throws InterruptedException {

        for (int i = 0; i < siatka.r; i++) {
            for (int j = 0; j < siatka.c; j++) {
                g.setColor(siatka.tab[i * siatka.c + j].stanKomórki.kolor());
                g.fillRect(j * wymiar, i * wymiar, wymiar, wymiar);
            }
        }
        for (int i = 0; i < siatka.r; i++) {
            g.setColor(new Color(80, 80, 80));
            g.drawLine(0, i * wymiar, siatka.c * wymiar, i * wymiar);
        }
        for (int j = 0; j < siatka.c; j++) {
            g.setColor(new Color(80, 80, 80));
            g.drawLine(j * wymiar, 0, j * wymiar, siatka.r * wymiar);

        }
    }

    @Override
    public void paintComponent(Graphics g) {

        super.paintComponent(g);
        try {
            rysuj(g);
        } catch (InterruptedException ex) {
            Logger.getLogger(RysujPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
