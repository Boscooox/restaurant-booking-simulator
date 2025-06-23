
    import java.io.File;
    import java.util.Scanner;

    public class Main {
        public static void main(String[] args) {
            Scanner input = new Scanner(System.in);
            Ristorante ristorante = new Ristorante();

            // Tavoli iniziali
            ristorante.aggiungiTavolo(new TavoloInterno(1, 4, true));
            ristorante.aggiungiTavolo(new TavoloEsterno(2, 6, true));
            ristorante.aggiungiTavolo(new TavoloInterno(3, 2, false));


            String carica = "";

            while (!carica.equalsIgnoreCase("si") && !carica.equalsIgnoreCase("no")) {
                System.out.print("Vuoi caricare dal file? (si/no): ");
                carica = input.nextLine();

                if (!carica.equalsIgnoreCase("si") && !carica.equalsIgnoreCase("no")) {
                    System.out.println("Risposta non valida. Scrivi 'si' oppure 'no'.");
                }
            }

            if (carica.equalsIgnoreCase("no")) {
                System.out.println("Procedo senza caricare.");
            } else {
                System.out.print("Inserisci il nome del file: ");
                String nomeFile = input.nextLine();
                File f = new File(nomeFile);
                if (f.exists() && !f.isDirectory()) {
                    ristorante.caricaPrenotazioniDaFile(nomeFile);
                } else {
                    System.out.println("Il file non esiste.");
                }
            }

            int scelta;

            do {
                System.out.println("\n--- MENU ---");
                System.out.println("1. Visualizza tavoli disponibili");
                System.out.println("2. Crea prenotazione");
                System.out.println("3. Annulla prenotazione");
                System.out.println("4. Mostra tutte le prenotazioni");
                System.out.println("5. Salva prenotazioni su file");
                System.out.println("6. Crea prenotazione su tavolo specifico");
                System.out.println("0. Esci");
                System.out.print("Scelta: ");
                scelta = input.nextInt();
                input.nextLine(); // Consuma newline

                switch (scelta) {
                    case 1:
                        ristorante.stampaTavoliDisponibili();
                        break;

                    case 2:
                        System.out.print("Nome cliente: ");
                        String nome = input.nextLine();

                        System.out.print("Data (es. 10/06/2025): ");
                        String data = input.nextLine();

                        System.out.print("Numero persone: ");
                        int num = input.nextInt();
                        input.nextLine();

                        ristorante.creaPrenotazione(nome, data, num);
                        break;

                    case 3:
                        System.out.print("Nome cliente da annullare: ");
                        String nomeAnnulla = input.nextLine();
                        ristorante.annullaPrenotazione(nomeAnnulla);
                        break;


                    case 4:
                        ristorante.mostraPrenotazioni();
                        break;

                    case 5:
                        System.out.print("Nome file (es. prenotazioni.txt): ");
                        String nomeFile = input.nextLine();
                        ristorante.salvaPrenotazioniSuFile(nomeFile);
                        break;

                    case 6:
                        System.out.print("Nome cliente: ");
                        String nomeCliente6 = input.nextLine();
                        System.out.print("Data: ");
                        String data6 = input.nextLine();
                        System.out.print("Numero persone: ");
                        int persone6 = input.nextInt();
                        input.nextLine(); // consuma newline
                        System.out.print("Numero tavolo: ");
                        int numeroTavolo = input.nextInt();
                        input.nextLine();

                        ristorante.creaPrenotazione(nomeCliente6, data6, persone6, numeroTavolo);
                        break;

                    case 0:
                        System.out.println("Uscita dal programma.");
                        break;

                    default:
                        System.out.println("Scelta non valida.");
                }

            } while (scelta != 0);

            input.close();
        }
    }






