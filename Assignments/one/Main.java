package Assignments.one;

public class Main {

    public static void main(String[] args) {
        //Pris på aksjen vi regner med
        int prisPaAksje = 1000;

        //Genererer en fiktiv kursendringstabell basert på den prisen vi først oppga
        int[] kursEndringer = nyKursEndringsTabell(prisPaAksje);

        /*System.out.println("Kursendringer: ");
        for (double k : kursEndringer) {
            System.out.print(k + ", ");
        }*/

        double differanse = 0;
        int kjøpsDag = 0;
        int salgsDag = 0;

        //Starter tidsmåling
        long start = System.currentTimeMillis();

        //Omregner kursendringene til prisen på aksjen de forskjellige dagene
        int[] priser = new int[kursEndringer.length];
        for (int i = 0; i < kursEndringer.length; i++) {
            if (i == 0) { //starter med pris dag 0
                priser[i] = prisPaAksje + kursEndringer[i];
            } else { //regner på forrige dags pris
                priser[i] = priser[i - 1] + kursEndringer[i];
            }
        }

        /*System.out.println("\nPriser: ");
        for (double p : priser) {
            System.out.print(p + ", ");
        }*/

        //Finner beste dager for kjøp og salg for høyest profit
        for (int i = 0; i < priser.length; i++) {
            for (int j = i + 1; j < priser.length; j++) {
                if (priser[i] < priser[j] && priser[j] - priser[i] > differanse) {
                    differanse = Math.abs(priser[i] - priser[j]);
                    kjøpsDag = i;
                    salgsDag = j;
                }
            }
        }

        //Stopper tidsmåling
        long end = System.currentTimeMillis();
        long duration = (end - start);

        kjøpsDag += 1; //starter på dag 1
        salgsDag += 1;

        System.out.println("\nKjøper på dag " + kjøpsDag + " og selger på dag " + salgsDag);
        System.out.println("Differanse: " + differanse);
        System.out.println("\nMillisekunder brukt: " + duration);
    }

    //Setter opp en kursendringstabell basert på startpris
    private static int[] nyKursEndringsTabell(int pris) {

        int size = 100000;
        int[] array = new int[size];

        for (int i = 0; i < size; i++) {
            if (Math.random() > 0.5) {
                array[i] = -(int) (Math.random() * pris);
            } else {
                array[i] = (int) (Math.random() * pris);
            }
        }
        return array;
    }
}
