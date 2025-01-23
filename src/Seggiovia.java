import java.util.concurrent.Semaphore;

public class Seggiovia {
    private Semaphore semaforo;

    public Seggiovia(int capacita) {
        this.semaforo = new Semaphore(capacita);
    }

    public void usaSeggiovia(String sciatoreNome) throws InterruptedException {
        semaforo.acquire();
        System.out.println(sciatoreNome + " sta usando la seggiovia per risalire");
        Thread.sleep(3000); // Simula il tempo di risalita
        System.out.println(sciatoreNome + " ha completato la risalita");
        semaforo.release();
    }
}
