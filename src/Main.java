//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

      //ciclo con il menù numeraro
      //interazione con lo scanner (prendere l'inputo)
      //invoca i metodi della classe ristorante
    import java.util.Scanner;

    public class Main {
        public static void main(String[] args) {
            Scanner input = new Scanner(System.in);
            Ristorante ristorante = new Ristorante();

            // Tavoli iniziali (puoi personalizzarli)
            ristorante.aggiungiTavolo(new TavoloInterno(1, 4, true));
            ristorante.aggiungiTavolo(new TavoloEsterno(2, 6, true));
            ristorante.aggiungiTavolo(new TavoloInterno(3, 2, false));


            System.out.print("Vuoi caricare dal file si o no: ");
            String carica = input.nextLine();
            if (carica.equals("no")) {
                System.out.print("procedo senza caricare");
            } else {
                System.out.print("inserisci il nome del file: ");
                String nomeFile = input.nextLine();
                ristorante.caricaPrenotazioniDaFile(nomeFile);
            }


            int scelta;

            do {
                System.out.println("\n--- MENU ---");
                System.out.println("1. Visualizza tavoli disponibili");
                System.out.println("2. Crea prenotazione");
                System.out.println("3. Annulla prenotazione");
                System.out.println("4. Mostra tutte le prenotazioni");
                System.out.println("5. Salva prenotazioni su file");
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






