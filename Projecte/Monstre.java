public class Monstre implements Combatent {

    // ATRIBUTS

    private String nom;                 // Nom del monstre
    private int vida;                  // Vida actual
    private int penalitzacio;          // Dany que fa si el jugador fuig
    private int valorExperiencia;      // Experiència que dona en morir

    // CONSTRUCTOR

    public Monstre() {
        this.nom = "Monstre";

        // Vida aleatòria entre 10 i 15
        this.vida = 10 + (int)(Math.random() * 6);

        // Penalització entre 0 i 3
        this.penalitzacio = (int) (Math.random() * 4);

        // L'experiència és el doble de la vida
        this.valorExperiencia = vida * 2;
    }

    public Monstre(String nom, int vida, int penalitzacio) {
        this.nom = nom;
        this.vida = vida;
        this.penalitzacio = penalitzacio;
        this.valorExperiencia = vida * 2;
    }

    // MÈTODES

    // Calcula el dany de l'atac (entre 1 i la vida actual)
    @Override
    public int calcularAtac() {
        return 1 + (int) (Math.random() * vida);
    }

    // Rep dany i resta vida
    @Override
    public void rebreDany(int quantitat) {
        vida = vida - quantitat;

        // Evita que la vida sigui negativa
        if (vida < 0) {
            vida = 0;
        }
    }

    // Comprova si el monstre està viu
    @Override
    public boolean estaViu() {
        return vida > 0;
    }

    // GETTERS

    public String getNom() {
        return nom;
    }

    public int getVida() {
        return vida;
    }

    public int getPenalitzacio() {
        return penalitzacio;
    }

    public int getValorExperiencia() {
        return valorExperiencia;
    }

    // TO STRING

    @Override
    public String toString() {
        return nom + " (Vida: " + vida + ")";
    }
}