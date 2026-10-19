import java.util.ArrayList;

// Classe abstracta del personatge
public abstract class Personatge implements Combatent {

    // Atributs bàsics del personatge
    private String nom;
    private int vida;
    private int atac;
    private int agilitat;
    private int forsa;

    // Inventari de tresors (limitat per la força)
    private ArrayList<Tresor> inventari;

    // Experiència acumulada
    private int experiencia;

    // Posició dins la masmorra (fila i columna)
    private int posicioX;
    private int posicioY;

    // Constructor
    public Personatge(String nom, int vida, int atac, int agilitat, int forsa) {
        this.nom = nom;
        this.vida = vida;
        this.atac = atac;
        this.agilitat = agilitat;
        this.forsa = forsa;

        // Inicialitzem inventari buit
        this.inventari = new ArrayList<Tresor>();

        this.experiencia = 0;

        // Comença a la posició inicial
        this.posicioX = 0;
        this.posicioY = 0;
    }

    // Getter del nom
    public String getNom() {
        return nom;
    }

    // Retorna fila
    public int getFila() {
        return posicioX;
    }

    // Retorna columna
    public int getColumna() {
        return posicioY;
    }

    public int getExperiencia() {
        return experiencia;
    }

    public int getVida() {
        return vida;
    }

    public int getAgilitat() {
        return agilitat;
    }

    public int getForsa() {
        return forsa;
    }

    // Permet canviar posició
    public void setPosicio(int fila, int columna) {
        this.posicioX = fila;
        this.posicioY = columna;
    }

    // Calcula atac aleatori
    @Override
    public int calcularAtac() {
        return 1 + (int)(Math.random() * atac);
    }

    // Rep dany
    @Override
    public void rebreDany(int quantitat) {
        vida -= quantitat;

        if (vida < 0) {
            vida = 0;
        }
    }

    // Comprova si està viu
    @Override
    public boolean estaViu() {
        return vida > 0;
    }

    // Combat
    public void atacar(Monstre m) {

        if (m == null || !m.estaViu()) {
            System.out.println("No hi ha cap monstre viu per atacar.");
            return;
        }

        int exp = m.getValorExperiencia();

        int dany = calcularAtac();
        m.rebreDany(dany);
        System.out.println(nom + " ataca i fa " + dany + " de dany!");

        if (m.estaViu()) {
            int danyMonstre = m.calcularAtac();
            rebreDany(danyMonstre);
            System.out.println("El monstre contraataca i fa " + danyMonstre + " de dany!");
            System.out.println("Vida del personatge: " + vida);
        } else {
            experiencia += exp;
            System.out.println("Has matat el monstre! +" + exp + " XP");
        }
    }

    // Explorar sala
    public void explorar(Sala s) {

        System.out.println("Has explorat la sala.");
        System.out.println("Tipus de sala: " + s.getTipus());

        if (s.getMonstre() != null && s.getMonstre().estaViu()) {
            System.out.println("Hi ha un monstre: " + s.getMonstre());
        } else {
            System.out.println("No hi ha cap monstre.");
        }

        if (s.getTresor() != null) {
            System.out.println("Hi ha un tresor: " + s.getTresor());

            if (inventari.size() < forsa) {
                inventari.add(s.getTresor());
                System.out.println("Has agafat el tresor.");
                s.setTresor(null);
            } else {
                System.out.println("No pots portar mes tresors!");
            }
        } else {
            System.out.println("No hi ha cap tresor.");
        }
    }

    // Moviment
    public void moure(char direccio) {

        direccio = Character.toUpperCase(direccio);

        if (direccio == 'N') {
            posicioX--;
        } else if (direccio == 'S') {
            posicioX++;
        } else if (direccio == 'E') {
            posicioY++;
        } else if (direccio == 'O') {
            posicioY--;
        } else {
            System.out.println("Direccio no valida.");
        }
    }

    // Tirada força
    public boolean tiradaForsa() {
        int tirada = 1 + (int)(Math.random() * 12);
        return tirada <= forsa;
    }

    // Tirada agilitat
    public boolean tiradaAgilitat() {
        int tirada = 1 + (int)(Math.random() * 12);
        return tirada <= agilitat;
    }
}