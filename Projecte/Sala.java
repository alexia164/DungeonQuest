public abstract class Sala {

    // ATRIBUTS

    protected Tresor tresor;      // Tresor que pot tenir la sala (o null)
    protected Monstre monstre;    // Monstre que pot tenir la sala (o null)
    protected boolean explorada;  // Indica si la sala ja ha estat explorada

    // CONSTRUCTOR

    public Sala() {

        // Genera un tresor aleatori (50% probabilitat)
        if (Math.random() < 0.5) {
            int valor = 1 + (int) (Math.random() * 100); // Valor entre 1 i 100
            double pes = 1 + Math.random(); // Pes entre 1 i 2
            tresor = new Tresor("Tresor", valor, pes);
        } else {
            tresor = null;
        }

        // Genera un monstre aleatori (50% probabilitat)
        if (Math.random() < 0.5) {
            monstre = new Monstre();
        } else {
            monstre = null;
        }

        // Inicialment la sala no està explorada
        explorada = false;
    }

    // MÈTODES

    public Tresor getTresor() {
        return tresor;
    }

    public Monstre getMonstre() {
        return monstre;
    }

    public boolean isExplorada() {
        return explorada;
    }

    public void setTresor(Tresor tresor) {
        this.tresor = tresor;
    }

    public void setMonstre(Monstre monstre) {
        this.monstre = monstre;
    }

    public void setExplorada(boolean explorada) {
        this.explorada = false;
    }

    // Mètode abstracte: cada tipus de sala implementa la seva lògica
    public abstract boolean intentarSortir(Personatge personatge);

    // Retorna el tipus de sala (per mostrar per pantalla)
    public abstract String getTipus();

    @Override
    public String toString() {

        String resultat = "Sala: ";

        // Informació del tresor
        if (tresor != null) {
            resultat += "Conte un " + tresor + ". ";
        } else {
            resultat += "No hi ha cap tresor. ";
        }

        // Informació del monstre
        if (monstre != null) {
            resultat += "Hi ha un " + monstre + ". ";
        } else {
            resultat += "No hi ha cap monstre. ";
        }

        return resultat;
    }
}