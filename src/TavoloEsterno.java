public class TavoloEsterno extends Tavolo {
    private boolean coperto;

    public TavoloEsterno(int numero, int capienza, boolean coperto) {
        super(numero, capienza, true); // il tavolo è inizialmente disponibile
        this.coperto = coperto;
    }

    @Override
    public String calcolaDisponibilita() {
        return disponibilita ? "Esterno disponibile" : "Esterno occupato";
    }

    @Override
    public String toString() {
        return super.toString() + " [Esterno, " + (coperto ? "coperto" : "scoperto") + "]";
    }
}

