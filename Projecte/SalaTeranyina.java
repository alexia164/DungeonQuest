public class SalaTeranyina extends Sala {

    // CONSTRUCTOR

    public SalaTeranyina() {
        super(); // Crida al constructor de Sala
    }

    // MÈTODES

    @Override
    public boolean intentarSortir(Personatge personatge) {

        // Fa una tirada de força
        if (personatge.tiradaForsa()) {
            // Si té èxit, pot sortir
            System.out.println("Has aconseguit desenganxar-te de la teranyina!");
            return true;
        } else {
            // Si falla, es queda a la sala
            System.out.println("Estàs atrapat a la teranyina!");
            return false;
        }
    }

    @Override
    public String getTipus() {
        // Retorna el tipus de sala
        return "SalaTeranyina";
    }
}