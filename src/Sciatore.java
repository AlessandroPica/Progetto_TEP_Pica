import java.util.concurrent.ThreadLocalRandom;

public class Sciatore extends Thread {
    private String nome;
    private Pista[] piste;
    private Seggiovia seggiovia;
    private int i = 0;

    public Sciatore(String nome, Pista[] piste, Seggiovia seggiovia) {
        this.nome = nome;
        this.piste = piste;
        this.seggiovia = seggiovia;
    }

    public void run() {
        try {
            while (true) {
                boolean sceso = false;

                // Prova a scendere da una pista finché non riesce
                int sceltaPista = ThreadLocalRandom.current().nextInt(0, piste.length);
                Pista pistaScelta = piste[sceltaPista];
                while (!sceso) {
                    // Tenta di accedere alla pista
                    sceso = pistaScelta.entraPista(nome);
                    if (sceso) {
                        // Simula la discesa
                        Thread.sleep(pistaScelta.getTempoDiscesa() * 1000);
                        pistaScelta.esciPista(nome);
                    } else if (i == 0) {
                        System.out.println(nome + " non può scendere sulla " + pistaScelta.getNome() + " (pista piena)");
                        i++;
                    }
                }

                if (!seggiovia.isOpen()) {
                    System.out.println(nome + " ha concluso la sciata");
                    break;
                }else{
                    // Usa la seggiovia per risalire
                    seggiovia.usaSeggiovia(nome);
                }
            }
        } catch (InterruptedException e) {
            System.out.println("errore: " + e);
        }
    }
}