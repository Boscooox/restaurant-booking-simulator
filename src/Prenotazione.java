public class Prenotazione {
    //nomeCliente
    //data
    //Numero di persone
    //Numero del tavolo assegnato

    private String nomeCliente;
    private String data;
    private int numPersone;
    private int numeroTavolo;

    //costruttore
    public Prenotazione(String nomeCliente, String data, int numPersone, int numeroTavolo) {
        this.nomeCliente = nomeCliente;
        this.data = data;
        this.numPersone = numPersone;
        this.numeroTavolo = numeroTavolo;
    }

    //prendi le informazioni

    public String getNomeCliente() {
        return nomeCliente;

    }

    public String getData() {
        return data;

    }

    public int getNumPersone() {
        return numPersone;

    }

    public int getNumeroTavolo() {
        return numeroTavolo;
    }

    @Override
    public String toString() {
        return "Prenotazione: " + nomeCliente + ", " + data + ", " + numPersone + " persone, Tavolo #" + numeroTavolo;
    }

}
