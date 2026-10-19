import java.util.Scanner;

public class Masmorra {

    private static Sala[][] matriu;
    private static boolean[][] explorades;
    private static Personatge jugador;
    private static int files;
    private static int columnes;

    public static void crearMasmorra(int f, int c, Personatge p) {

        files = f;
        columnes = c;
        jugador = p;

        matriu = new Sala[files][columnes];
        explorades = new boolean[files][columnes];

        for (int i = 0; i < files; i++) {
            for (int j = 0; j < columnes; j++) {

                double aleatori = Math.random() * 100;

                if (aleatori < 40) {
                    matriu[i][j] = new SalaComuna();
                } else if (aleatori < 55) {
                    matriu[i][j] = new SalaPont();
                } else if (aleatori < 70) {
                    matriu[i][j] = new SalaTeranyina();
                } else if (aleatori < 85) {
                    matriu[i][j] = new SalaBoira();
                } else {
                    matriu[i][j] = new SalaTrampa();
                }

                explorades[i][j] = false;
            }
        }

        // El jugador comença a la primera posició
        jugador.setPosicio(0, 0);

        // La primera sala és segura
        matriu[0][0].setMonstre(null);
    }

    public static void imprimirEstat() {

        System.out.println("Mapa de la masmorra:");

        for (int i = 0; i < files; i++) {
            for (int j = 0; j < columnes; j++) {

                if (jugador.getFila() == i && jugador.getColumna() == j) {
                    System.out.print("& ");
                } else if (explorades[i][j]) {
                    System.out.print("* ");
                } else {
                    System.out.print("- ");
                }
            }
            System.out.println();
        }
    }

    public static void jugar() {

        Scanner teclado = new Scanner(System.in);

        while (!esFinalPartida()) {

            imprimirEstat();

            int filaActual = jugador.getFila();
            int columnaActual = jugador.getColumna();

            Sala salaActual = matriu[filaActual][columnaActual];

            if (explorades[filaActual][columnaActual]) {
                mostrarSala(salaActual);
            } else {
                System.out.println("Sala no explorada.");
            }

            System.out.println("Opcions: (E)xplorar, (M)oure, (A)tacar");
            char opcio = teclado.next().toUpperCase().charAt(0);

            if (opcio == 'E') {

                if (!explorades[filaActual][columnaActual]) {
                    explorades[filaActual][columnaActual] = true;
                    salaActual.setExplorada(true);
                    jugador.explorar(salaActual);
                } else {
                    System.out.println("Ja esta explorada.");
                    mostrarSala(salaActual);
                }
            }

            else if (opcio == 'M') {

                if (salaActual.intentarSortir(jugador)) {

                    if (salaActual.getMonstre() != null && salaActual.getMonstre().estaViu()) {
                        int dany = salaActual.getMonstre().getPenalitzacio();
                        jugador.rebreDany(dany);
                        System.out.println("El monstre t'ha atacat en fugir! -" + dany);
                    }

                    if (jugador.estaViu()) {
                        System.out.println("Direccio (N, S, E, O):");
                        char direccio = teclado.next().toUpperCase().charAt(0);
                        jugador.moure(direccio);
                    }

                } else {
                    System.out.println("No has pogut sortir de la sala.");
                }
            }

            else if (opcio == 'A') {

                if (salaActual.getMonstre() != null && salaActual.getMonstre().estaViu()) {
                    jugador.atacar(salaActual.getMonstre());
                } else {
                    System.out.println("No hi ha cap monstre.");
                }
            }

            else {
                System.out.println("Opcio no valida.");
            }

            System.out.println();
        }

        mostrarResultats();
    }

    private static void mostrarSala(Sala s) {

        System.out.println("Sala explorada.");
        System.out.println("Tipus: " + s.getTipus());

        if (s.getMonstre() != null && s.getMonstre().estaViu()) {
            System.out.println("Monstre: " + s.getMonstre());
        } else {
            System.out.println("Sense monstre.");
        }

        if (s.getTresor() != null) {
            System.out.println("Tresor: " + s.getTresor());
        } else {
            System.out.println("Sense tresor.");
        }
    }

    public static boolean esFinalPartida() {

        if (!jugador.estaViu()) {
            return true;
        }

        if (jugador.getFila() < 0 || jugador.getFila() >= files ||
            jugador.getColumna() < 0 || jugador.getColumna() >= columnes) {
            return true;
        }

        return false;
    }

    private static void mostrarResultats() {

        int totalExplorades = 0;

        for (int i = 0; i < files; i++) {
            for (int j = 0; j < columnes; j++) {
                if (explorades[i][j]) {
                    totalExplorades++;
                }
            }
        }

        int totalSales = files * columnes;
        double percentatge = totalExplorades * 100.0 / totalSales;

        if (jugador.estaViu()) {
            System.out.println("Has escapat de la masmorra!");
        } else {
            System.out.println("Has mort!");
        }

        System.out.println("Experiencia: " + jugador.getExperiencia() + " XP");
        System.out.println("Sales explorades: " + totalExplorades);
        System.out.println("Percentatge de la masmorra explorada: " + percentatge + " %");
    }
}