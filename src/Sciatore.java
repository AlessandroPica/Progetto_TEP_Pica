import java.util.concurrent.ThreadLocalRandom;

public class Sciatore extends Thread {
    private final String nome;
    private final Pista[] piste;
    private final Seggiovia seggiovia;

    public Sciatore(String nome, Pista[] piste, Seggiovia seggiovia) {
        this.nome = nome;
        this.piste = piste;
        this.seggiovia = seggiovia;
    }


    public void run() {
        try {
            while (true) {
                // Scegli una pista casuale
                int sceltaPista = ThreadLocalRandom.current().nextInt(0, piste.length);
                Pista pistaScelta = piste[sceltaPista];

                // Tenta di entrare nella pista
                if (pistaScelta.entraPista(nome)) {
                    // Simula la discesa
                    Thread.sleep(pistaScelta.getTempoDiscesa() * 1000);
                    pistaScelta.esciPista(nome);
                }

                // Usa la seggiovia per risalire
                seggiovia.usaSeggiovia(nome);
            }
        } catch (InterruptedException e) {
            System.out.println("errore:" + e);
        }
    }
}
