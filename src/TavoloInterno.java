public class TavoloInterno extends Tavolo {
    private boolean vicinoFinestra;

    public TavoloInterno(int numero, int capienza, boolean vicinoFinestra) {
        super(numero, capienza, true); // il tavolo è inizialmente disponibile
        this.vicinoFinestra = vicinoFinestra;
    }

    @Override
    public String calcolaDisponibilita() {
        return disponibilita ? "Interno disponibile" : "Interno occupato";
    }

    @Override
    public String toString() {
        return super.toString() + " [Interno, " + (vicinoFinestra ? "vicino finestra" : "no finestra") + "]";
    }
}

