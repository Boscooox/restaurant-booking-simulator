import java.util.List;
import java.util.ArrayList;
import java.io.FileWriter;
import java.io.IOException;

public class Ristorante {

    private List<Tavolo> tavoli;
    private List<Prenotazione> prenotazioni;

    // Costruttore
    public Ristorante() {
        tavoli = new ArrayList<>();
        prenotazioni = new ArrayList<>();
    }

    // Metodo per aggiungere un tavolo
    public void aggiungiTavolo(Tavolo tavolo) {
        tavoli.add(tavolo);
        System.out.println("Tavolo aggiunto: " + tavolo);
    }

    // Metodo per stampare i tavoli disponibili
    public void stampaTavoliDisponibili() {
        for (Tavolo t : tavoli) {
            if (t.isDisponibile()) {
                System.out.println(t);
            }
        }
    }

    // Metodo per creare una prenotazione
    public void creaPrenotazione(String nomeCliente, String data, int numPersone) {
        for (Tavolo t : tavoli) {
            if (t.isDisponibile() && t.getCapienza() >= numPersone) {
                Prenotazione p = new Prenotazione(nomeCliente, data, numPersone, t.getNumero());
                prenotazioni.add(p);
                t.setDisponibile(false);
                System.out.println("Prenotazione creata: " + p);
                return;
            }
        }
        System.out.println("Nessun tavolo disponibile per " + numPersone + " persone.");
    }

    // Metodo per mostrare tutte le prenotazioni
    public void mostraPrenotazioni() {
        if (prenotazioni.isEmpty()) {
            System.out.println("Nessuna prenotazione presente.");
        } else {
            for (Prenotazione p : prenotazioni) {
                System.out.println(p);
            }
        }
    }

    // Metodo per annullare una prenotazione
    public void annullaPrenotazione(String nomeCliente) {
        for (Prenotazione p : prenotazioni) {
            if (p.getNomeCliente().equalsIgnoreCase(nomeCliente)) {
                prenotazioni.remove(p);
                for (Tavolo t : tavoli) {
                    if (t.getNumero() == p.getNumeroTavolo()) {
                        t.setDisponibile(true);
                        break;
                    }
                }
                System.out.println("Prenotazione annullata per: " + nomeCliente);
                return;
            }
        }
        System.out.println("Prenotazione non trovata per: " + nomeCliente);
    }

    // Metodo per salvare prenotazioni su file
    public void salvaPrenotazioniSuFile(String nomeFile) {
        try (FileWriter writer = new FileWriter(nomeFile)) {
            for (Prenotazione p : prenotazioni) {
                writer.write(p.toString() + "\n");
            }
            System.out.println("Prenotazioni salvate su file.");
        } catch (IOException e) {
            System.out.println("Errore durante il salvataggio: " + e.getMessage());
        }
    }
}

