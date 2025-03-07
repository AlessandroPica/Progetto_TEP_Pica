import java.util.concurrent.Semaphore;

public class Seggiovia {
    private Semaphore semaforo;
    private boolean isOpen;

    public Seggiovia(int capacita) {
        this.semaforo = new Semaphore(capacita);
        this.isOpen = true;
    }

    public void usaSeggiovia(String sciatoreNome) throws InterruptedException {
        if (!isOpen) {
            System.out.println(sciatoreNome + " non può risalire, l'impianto è chiuso");
            return;
        }
        semaforo.acquire();
        System.out.println(sciatoreNome + " sta usando la seggiovia per risalire");
        Thread.sleep(3000); // tempo di risalita
        System.out.println(sciatoreNome + " ha completato la risalita");
        semaforo.release();
    }

    public void chiudiImpianto() {
        isOpen = false;
        System.out.println("L'impianto è stato chiuso");
    }

    public boolean isOpen() {
        return isOpen;
    }
}