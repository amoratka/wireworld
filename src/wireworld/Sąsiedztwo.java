package wireworld;

/**
 *
 * @author Kamilka
 */
public class Sąsiedztwo {

    public static void otoczenie(int r, int c, Siatka siatka, int tab[]) {
        int z = 1;
        int x = 0;
        int y = 0;
        int k, l;

        int tmp = 1;
        for (k = -1; k < 2; k++) {
            for (l = -1; l < 2; l++) {
                x = (r + k) % siatka.r;
                y = (c + l) % siatka.c;

                if (x == 0) {
                    x = siatka.r;
                }
                if (y == 0) {
                    y = siatka.c;
                }

                if (x != r || y != c) {
                    tab[tmp] = siatka.tab[(x - 1) * siatka.c + y - 1].symbol();
                    tmp++;
                }
            }
        }
    }
}
//zwraca tablice z sąsiadami
