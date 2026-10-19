public class SalaComuna extends Sala {

    // CONSTRUCTOR

    public SalaComuna() {
        super(); // Crida al constructor de Sala (genera tresor i monstre aleatori)
    }

    // MÈTODES

    @Override
    public boolean intentarSortir(Personatge personatge) {
        // En una sala comuna sempre es pot sortir
        return true;
    }

    @Override
    public String getTipus() {
        // Retorna el tipus de sala
        return "SalaComuna";
    }
}