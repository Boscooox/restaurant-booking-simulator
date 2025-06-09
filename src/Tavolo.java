public abstract class Tavolo {
    // numero del tavolo
    // capienza
    // disponibilità
    // metodo astratto
    // crea TavoloInterno e TavoloEsterno

    protected int numero;
    protected int capienza;
    protected boolean disponibilita;

    //costruttore
    public Tavolo (int numero, int capienza, boolean disponibilita) {
        this.numero = numero;
        this.capienza = capienza;
        this.disponibilita = disponibilita;

        }

   // metodo
   @Override
   public String toString() {
       return "Tavolo #" + numero + " (" + capienza + " posti) - " + (disponibilita ? "Libero" : "Occupato");
   }

   //metodo astratto
   public abstract String calcolaDisponibilita();

    public int getNumero() {
        return numero;
    }

    public int getCapienza() {
        return capienza;
    }

    public boolean isDisponibile() {
        return disponibilita;
    }

    public void setDisponibile(boolean disponibilita) {
        this.disponibilita = disponibilita;
    }























    }
