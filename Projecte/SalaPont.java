public class SalaPont extends Sala {

    // CONSTRUCTOR

    public SalaPont() {
        super();
    }

    // MÈTODES

    @Override
    public boolean intentarSortir(Personatge personatge) {

        // Fa una tirada d'agilitat
        if (personatge.tiradaAgilitat()) {
            // Si té èxit, pot sortir
            System.out.println("Has creuat el pont amb èxit!");
            return true;
        } else {
            // Si falla, rep 1 punt de dany
            System.out.println("Has caigut del pont!");
            personatge.rebreDany(1);
            return false;
        }
    }

    @Override
    public String getTipus() {
        // Retorna el tipus de sala
        return "SalaPont";
    }
}