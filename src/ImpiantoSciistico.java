import java.util.Scanner;

public class ImpiantoSciistico {
    public static void main(String[] args) {
        // Configurazione delle piste con tempi di discesa differenti
        Pista pista1 = new Pista("Pista 1", 3, 5); // Capacità 3, tempo di discesa 5 secondi
        Pista pista2 = new Pista("Pista 2", 1, 3); // Capacità 1, tempo di discesa 3 secondi
        Pista pista3 = new Pista("Pista 3", 2, 4); // Capacità 2, tempo di discesa 4 secondi

        Seggiovia seggiovia = new Seggiovia(2); // Capacità della seggiovia

        Pista[] piste = {pista1, pista2, pista3};

        // Creazione di 10 sciatori
        Sciatore[] sciatori = new Sciatore[10];

        for (int i = 0; i < 10; i++) {
            sciatori[i] = new Sciatore("Sciatore " + (i + 1), piste, seggiovia);
            sciatori[i].start();
        }

        // Chiude l'impianto dopo un certo periodo di tempo
        try {
            Thread.sleep(20000); // tempo prima della chiusura dell'impianto
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        seggiovia.chiudiImpianto();
    }
}