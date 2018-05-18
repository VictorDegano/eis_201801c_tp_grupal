package gradle.cucumber;
import Fantasma.Fantasma;
import Pacman.Pacman;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Dados;
import cucumber.api.java.es.Entonces;

import java.util.List;

import static org.junit.Assert.*;


public class PacmanChocaStepdefs {

    private Pacman unPacman;
    private Fantasma unFantasma;
    private List<Fantasma> Fantasmas;

    @Dados("^Un Pacman y un Fantasma$")
    public void Un_Pacman_y_un_Fantasma()
    {
        unPacman  = new Pacman(Fantasmas);
        unFantasma     = new Fantasma();
    }

    @Cuando("^Chocan$")
    public void El_pacman_Y_el_Fantasma_chocan()
    {   unPacman.choca(unFantasma);   }

    @Entonces("^El Pacman Muere$")
    public void El_pacman_muere()
    {   assertTrue(! unPacman.estaVivo());    }


    @Dados("^Va a chocar un fantasma$")
    public void Un_Pacman_y_un_Fantasma_sin_cuerpo()
    {
        unPacman  = new Pacman(Fantasmas);
        unFantasma     = new Fantasma();
        unFantasma.sinCuerpo();
    }

    @Cuando("^Fantasma sin cuerpo$")
    public void El_pacman_Y_el_Fantasma_sin_cuerpo_chocan()
    {   unPacman.choca(unFantasma);   }

    @Entonces("^No fallece$")
    public void El_pacman_no_muere()
    {   assertTrue(unPacman.estaVivo() && !unFantasma.tieneCuerpo());    }
}
