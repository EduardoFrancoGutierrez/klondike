package klondike;

import java.util.ArrayList;
import java.util.List;

public class Tablero {

    private static final int NUMBER_FAMILY = 4;

    private Baraja baraja;
    
    private Escaleras escaleras;
    
    private List<PilaFamiliaCartas> pilasFamily;

    
    public Tablero() {
        this.baraja = new Baraja();
        this.escaleras =  new Escaleras();;
        this.pilasFamily = inicializacionPilasFamily();
    }

    
    
   public void construccionDelTableroInicial(){
       this.baraja.construir();
       this.baraja.mezclar();
       this.escaleras.repartoCartasInicial(this.baraja);
   }
    
   public Baraja getBaraja() {
        return baraja;
    }
   
    public void setBaraja(Baraja baraja) {
        this.baraja = baraja;
    }

    public Escaleras getEscalera() {
        return escaleras;
    }

    public void setEscalera(Escaleras escalera) {
        this.escaleras = escalera;
    }

    public List<PilaFamiliaCartas> getPilasFamily() {
        return pilasFamily;
    }

    public void setPilasFamily(List<PilaFamiliaCartas> pilasFamily) {
        this.pilasFamily = pilasFamily;
    }
    
    
    private  List<PilaFamiliaCartas> inicializacionPilasFamily(){
        List<PilaFamiliaCartas> pilasFamilys = new ArrayList<PilaFamiliaCartas> ();
        for (int i=0; i<NUMBER_FAMILY;i++){
            PilaFamiliaCartas pilasFamily = new PilaFamiliaCartas();
            pilasFamilys.add(pilasFamily);
        }
        return pilasFamilys;
    }
    
    
}
