package wireworld;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StreamTokenizer;
import static wireworld.Sąsiedztwo.otoczenie;

/**
 *
 * @author Kamilka
 */
public class ObsługaSiatki {

    public static int wartosc;

    public static void odczytdanych(FileReader pob, Siatka siatka) throws IOException {
        Komórka komórka = new Komórka();
        Stan Ogon = new Ogon();
        Stan Głowa = new Głowa();
        Stan Przewodnik = new Przewodnik();
        Stan Pusta = new Pusta();

        StreamTokenizer znak = new StreamTokenizer(pob);
        znak.nextToken();
        siatka.r = (int) znak.nval;
        znak.nextToken();
        siatka.c = (int) znak.nval;
        siatka.tab = new Komórka[siatka.r * siatka.c];
        int i;
        for (i = 0; i < siatka.r * siatka.c; i++) {

            znak.nextToken();
            wartosc = (int) znak.nval;
            if (wartosc == 1) {
                komórka.setState(Ogon);
            } else if (wartosc == 2) {
                komórka.setState(Głowa);
            } else if (wartosc == 4) {
                komórka.setState(Przewodnik);
            } else {
                komórka.setState(Pusta);
            }
            siatka.tab[i] = new Komórka();
            siatka.tab[i].setState(komórka.getState());

        }

    }

    public static void zapisz(Siatka siatka, String nazwa, int nr_generacji) throws IOException {
        nazwa = nazwa + nr_generacji;

        PrintWriter plik = null;

        try {
            plik = new PrintWriter(new FileWriter(nazwa));
        } catch (IOException e) {
            System.out.println("Pliku nie udalo sie otworzyc: " + e.getLocalizedMessage());
            System.exit(1);
        }

        int tmp = 0;
        plik.println(siatka.r + " " + siatka.c);
        for (int i = 0; i < siatka.r; i++) {
            for (int j = 0; j < siatka.c; j++) {
                plik.print(siatka.tab[i * siatka.c + j].symbol());
                if (j != siatka.c - 1) {
                    plik.print(" ");
                }
                tmp++;
            }
            if (i != siatka.r - 1) {
                plik.println();
            }
        }

        plik.close();

    }

    public static void wypisz(Siatka siatka) {
        for (int i = 0; i < siatka.r * siatka.c; i++) {
            System.out.print(siatka.tab[i].symbol());
        }
        System.out.println("");
    }

    public static Siatka nowaSiatka(Siatka siatka) {
        Siatka nowaSiatka;
        nowaSiatka = new Siatka();
        nowaSiatka.r = siatka.r;
        nowaSiatka.c = siatka.c;
        nowaSiatka.tab = new Komórka[nowaSiatka.r * nowaSiatka.c];
        int i;
        Komórka komórka = new Komórka();
        Stan Głowa = new Głowa();
        Stan Ogon = new Ogon();
        Stan Pusta = new Pusta();
        Stan Przewodnik = new Przewodnik();
        int c;
        int r;
        int tab[];
        int n = 9;
        int status;

        tab = new int[n];
        tab[0] = n;
        for (i = 0; i < siatka.r * siatka.c; i++) {

            c = i % siatka.c + 1;
            r = i / siatka.c + 1;
            status = siatka.tab[i].symbol();
            otoczenie(r, c, siatka, tab);
            int głowa = 0;

            for (int j = 1; j < tab[0]; j++) {
                if (tab[j] == 2) {
                    głowa++;

                }
            }

            nowaSiatka.tab[i] = new Komórka();
            nowaSiatka.tab[i].setState(siatka.tab[i].stanKomórki.nastepnyStan(głowa));
        }
        return nowaSiatka;

    }

}
