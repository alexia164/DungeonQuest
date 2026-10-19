public class Main {

    public static void main(String[] args) {

        // Crear el personatge jugador
        Guerrer jugador = new Guerrer("Heroi", 20, 4, 8, 8);

        // Crear la masmorra
        Masmorra.crearMasmorra(5, 5, jugador);

        // Començar la partida
        Masmorra.jugar();
    }
}