public class SalaTrampa extends Sala {

    // CONSTRUCTOR

    public SalaTrampa() {
        super(); 
    }

    // MÈTODES

    @Override
    public boolean intentarSortir(Personatge personatge) {
        // Fa una tirada de força
        if (personatge.tiradaForsa()) {
            System.out.println("Has aguantat la trampa i has passat!");
            return true;
        } else {
            // Si falla, rep 2 punts de dany
            personatge.rebreDany(2);
            System.out.println("Has caigut en la trampa!");
            return false;
        }
    }

    @Override
    public String getTipus() {
        return "SalaTrampa";
    }
}