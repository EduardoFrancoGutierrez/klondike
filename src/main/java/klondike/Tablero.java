package klondike;

import java.util.ArrayList;
import java.util.List;

public class Tablero {

    private static final int NUMBER_FAMILY = 4;

    private Baraja baraja;
    
    private Escaleras escalera;
    
    private List<PilaFamiliaCartas> pilasFamily;



    
    public Tablero() {
        this.baraja = new Baraja();
        this.escalera =  new Escaleras();;
        this.pilasFamily = inicializacionPilasFamily();
    }



    private  List<PilaFamiliaCartas> inicializacionPilasFamily(){
        List<PilaFamiliaCartas> pilasFamilys = new ArrayList<PilaFamiliaCartas> ();
        for (int i=0; i<NUMBER_FAMILY;i++){
            PilaFamiliaCartas pilasFamily = new PilaFamiliaCartas();
            pilasFamilys.add(pilasFamily);
        }
        return pilasFamilys;
    }


    
   public Baraja getBaraja() {
        return baraja;
    }
   
    public void setBaraja(Baraja baraja) {
        this.baraja = baraja;
    }

    public Escaleras getEscalera() {
        return escalera;
    }

    public void setEscalera(Escaleras escalera) {
        this.escalera = escalera;
    }

    public List<PilaFamiliaCartas> getPilasFamily() {
        return pilasFamily;
    }

    public void setPilasFamily(List<PilaFamiliaCartas> pilasFamily) {
        this.pilasFamily = pilasFamily;
    }
    
    
    
    
    
}
