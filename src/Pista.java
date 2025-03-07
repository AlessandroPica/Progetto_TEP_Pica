import java.util.concurrent.Semaphore;

public class Pista {
    private String nome;
    private Semaphore semaforo;
    private int tempoDiscesa;

    public Pista(String nome, int capacita, int tempoDiscesa) {
        this.nome = nome;
        this.semaforo = new Semaphore(capacita);
        this.tempoDiscesa = tempoDiscesa;
    }

    public String getNome() {
        return nome;
    }

    public int getTempoDiscesa() {
        return tempoDiscesa;
    }

    public boolean entraPista(String sciatoreNome) {
        if (semaforo.tryAcquire()) {
            System.out.println(sciatoreNome + " sta scendendo sulla " + nome);
            return true;
        } else {
            return false;
        }
    }

    public void esciPista(String sciatoreNome) {
        System.out.println(sciatoreNome + " ha completato la discesa sulla " + nome);
        semaforo.release();
    }
}
