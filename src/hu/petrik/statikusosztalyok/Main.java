package hu.petrik.statikusosztalyok;


import java.util.Random;

public class Main {
    /*
    int nemStatikusAdattag;
    static int statikusTag;
    */

    public static void main(String[] args) {
        /*
        Main objektum = new Main();
        System.out.println(objektum.nemStatikusAdattag);
        System.out.println(Main.statikusTag);
        Math math = new Math();
        */

        for (int i = 0; i < 100; i++) {
            System.out.println(Veletlen.velEgesz(5, 10));
        }
        System.out.println();
        for (int i = 0; i < 50; i++) {
            System.out.println(Veletlen.velKarakter('A', 'Z'));
        }
        System.out.println();
        for (int i = 0; i < 5; i++) {
            System.out.println(Veletlen.velTeljesNev(true));
        }
        System.out.println();
        for (int i = 0; i < 5; i++) {
            System.out.println(Veletlen.velTeljesNev(false));
        }
    }
}
