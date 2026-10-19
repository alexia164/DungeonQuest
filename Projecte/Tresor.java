public class Tresor {

    private String nom;
    private int valor;
    private double pes;

    public Tresor(String nom, int valor, double pes) {
        this.nom = nom;
        this.valor = valor;
        this.pes = pes;
    }

    public String getNom() {
        return nom;
    }

    public int getValor() {
        return valor;
    }

    public double getPes() {
        return pes;
    }

    @Override
    public String toString() {
        return nom + " (Valor: " + valor + " monedes d'or)";
    }
}