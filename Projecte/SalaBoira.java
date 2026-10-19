public class SalaBoira extends Sala {

    // CONSTRUCTOR

    public SalaBoira() {
        super(); // Genera tresor i monstre aleatori
    }

    // MÈTODES

    @Override
    public boolean intentarSortir(Personatge personatge) {
        // Utilitza la tirada d'agilitat ja definida al personatge
        if (personatge.tiradaAgilitat()) {
            System.out.println("Has trobat el camí entre la boira!");
            return true;
        } else {
            System.out.println("Estàs desorientat per la boira i no trobes la sortida.");
            return false;
        }
    }

    @Override
    public String getTipus() {
        return "SalaBoira";
    }
}