import java.io.BufferedReader;
import java.io.FileReader;
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

    // Overload prenotazione specificando il numero del tavolo
    public void creaPrenotazione(String nomeCliente, String data, int numPersone, int numeroTavolo) {
        for (Tavolo t : tavoli) {
            if (t.isDisponibile() && t.getNumero() == numeroTavolo && t.getCapienza() >= numPersone) {
                Prenotazione p = new Prenotazione(nomeCliente, data, numPersone, numeroTavolo);
                prenotazioni.add(p);
                t.setDisponibile(false);
                System.out.println("Prenotazione su tavolo specifico creata: " + p);
                return;
            }
        }
        System.out.println("Tavolo #" + numeroTavolo + " non disponibile o troppo piccolo.");
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

    // Metodo per caricare le prenotazioni da file
    public void caricaPrenotazioniDaFile(String nomeFile) {
        try (BufferedReader reader = new BufferedReader(new FileReader(nomeFile))) {
            String riga;
            while ((riga = reader.readLine()) != null) {
                String[] parti = riga.split(",");
                if (parti.length == 4) {
                   String nome = parti[0].split(":")[1].trim();
                   String data = parti[1].trim();
                   int numPersone = Integer.parseInt(parti[2].split(" ")[1].trim());
                   int numeroTavolo = Integer.parseInt(parti[3].split(" ")[2].substring(1));
                    Prenotazione p = new Prenotazione(nome, data, numPersone, numeroTavolo);
                    prenotazioni.add(p);

                    // Imposta il tavolo come occupato
                    for (Tavolo t : tavoli) {
                        if (t.getNumero() == numeroTavolo) {
                            t.setDisponibile(false);
                            break;
                        }
                    }
                }
            }
            System.out.println("Prenotazioni caricate da file.");
        } catch (IOException e) {
            System.out.println("Errore durante la lettura del file: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Errore nel formato del file: " + e.getMessage());
        }
    }

}

