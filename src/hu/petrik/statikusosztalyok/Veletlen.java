package hu.petrik.statikusosztalyok;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.Normalizer;
import java.text.SimpleDateFormat;
import java.util.*;

public final class Veletlen {
    private Veletlen() {
    }

    private static final Random rnd = new Random();
    private static final List<String> vezNevek = feltolt("files/veznev.txt");
    private static final List<String> ferfiKerNevek = feltolt("files/ferfikernev.txt");
    private static final List<String> noiKerNevek = feltolt("files/noikernev.txt");

    private static List<String> feltolt(String fajlnev) {
        List<String> lista = new ArrayList<>();
        try {
            Scanner file = new Scanner(new File(fajlnev));
            while (file.hasNext()) {
                String sor = file.nextLine();
                lista.add(sor);
            }
            file.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return lista;
    }

    public static int velEgesz(int min, int max) {
        return rnd.nextInt(max - min + 1) + min;
    }

    public static char velKarakter(char min, char max) {
        return (char) velEgesz(min, max);
    }

    public static String velVezetekNev() {
        return vezNevek.get(rnd.nextInt(vezNevek.size()));
    }

    /**
     * Véletlen magyar keresztnév generálása
     * @param nem A generált keresztnév neme. Férfi esetén true, Nő esetén false.
     * @return A generált keresztnév
     */
    public static String velKeresztNev(boolean nem) {
        String keresztNev;
        if (nem) {
            keresztNev = velFerfiKeresztNev();
        } else {
            keresztNev = velNoiKeresztNev();
        }
        return keresztNev;
    }

    private static String velFerfiKeresztNev() {
        return ferfiKerNevek.get(rnd.nextInt(ferfiKerNevek.size()));
    }

    private static String velNoiKeresztNev() {
        return noiKerNevek.get(rnd.nextInt(noiKerNevek.size()));
    }

    /**
     * Véletlen magyar név generálása
     * @param nem A generált név neme. Férfi esetén true, Nő esetén false.
     * @return A generált név
     */
    public static String velTeljesNev(boolean nem) {
        return velVezetekNev() + " " + velKeresztNev(nem);
    }

//1,3,5,7,8,10,12
//4,6,9,11
//2
    public static String velDatum(Integer ev1, Integer ev2) {
        Random rnd = new Random();
        return String.format("%s-%s-%s",rnd.nextInt(ev2)+ev1,rnd.nextInt(13)+1,rnd.nextInt(31)+1);
    }
    public static String velEmail(String nev){
        Random rnd = new Random();
        Boolean neme = true;
        Normalizer normalizer;
        if (rnd.nextInt(2) == 0) {
            neme = false;
        }
        else {
            neme = true;
        }
        int i = 0;
        i++;
        return String.format("%s%d@gmail.com",Normalizer.normalize(velTeljesNev(neme).toLowerCase(),
                Normalizer.Form.NFD),i) ;
    }




}
