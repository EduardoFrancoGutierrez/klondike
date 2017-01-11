package klondike;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class IOS {

   
    public void showTablero(Tablero tablero){

        System.out.println();
        System.out.println("************************** TABLERO *****************************");
            this.mostrarBrajayPalos(tablero.getBaraja(),tablero.getPilasFamily());
            this.mostrarEscalera(tablero.getEscalera());
            System.out.println("*****************************************************************");
            System.out.println();
           
    }

    public int showMenu() {
       int lectura;
       do{
        System.out.println("Elige la operacion:");
        System.out.println("0. Seleccionar baraja");
        System.out.println("1. Seleccionar 1º escalera");
        System.out.println("2. Seleccionar 2º escalera");
        System.out.println("3. Seleccionar 3º escalera");
        System.out.println("4. Seleccionar 4º escalera");
        System.out.println("5. Seleccionar 5º escalera");
        System.out.println("6. Seleccionar 6º escalera");
        System.out.println("7. Seleccionar 7º escalera");
        System.out.println("8. Exit");
        lectura=this.leer();
       } while (lectura ==-1);
       return lectura;
    }
    public int leer(){
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String num="";
        try {
            num = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Integer retorno;
        if (this.isInteger(num))
            retorno=Integer.parseInt(num);
        else
            retorno =-1;
        return retorno;
    }
    
    public  boolean isInteger(String s) {
        try { 
            Integer.parseInt(s); 
        } catch(NumberFormatException e) { 
            return false; 
        } catch(NullPointerException e) {
            return false;
        }
        return true;
    }
    
    public void mostrarEscalera (Escaleras escalera){
        for (int j=1; j<Escaleras.NUM_COLUMNAS+1;j++){
            System.out.print(String.format("%1$-25s",j+".ESCALERA"));
        }
        System.out.println();
        for (int i=0; i< Escaleras.MAX_NUM_FILAS; i++) {
            for (int j=0; j<Escaleras.NUM_COLUMNAS;j++){
                PilaCartas pilaCarta= escalera.getEscaleras().get(j);
                if (i<pilaCarta.size()){
                    System.out.print(String.format("%1$-25s",pilaCarta.getPilaCartas().get(i).toString()));
                }
                else 
                    System.out.print(String.format("%1$-25s"," "));
            }
            System.out.println();
        }
    }
    public void mostrarBrajayPalos(Baraja baraja,List<PilaFamiliaCartas> pilasFamily){
        
        int poscionMostrar=0;
        if (baraja.getPosCartaMostrada()!=-1)
            poscionMostrar=baraja.getPosCartaMostrada();
        System.out.print(String.format("%1$-25s",0+".BARAJA"));
        for (int i=0; i<pilasFamily.size();i++){
            System.out.print(String.format("%1$-25s",i+1 +".PALO"));
        }
        System.out.println();
        System.out.print(String.format("%1$-25s",baraja.getCards().get(poscionMostrar).toString()));
        for (PilaFamiliaCartas pila: pilasFamily){
            poscionMostrar=0;
            if (pila.getPosCartaMostrada()!=-1)
                poscionMostrar=pila.getPosCartaMostrada();
            if ((pila.getCards()!=null) && (pila.getCards().size()>0))
                System.out.print(String.format("%1$-25s",pila.getCards().get(poscionMostrar).toString()));
        }
        System.out.println();
        System.out.println();
        
    }
    
    public int opcionesMenuBaraja(){
        int lectura;
        do{
         System.out.println("Elige la operacion:");
         System.out.println("0. Sacar la carta siguiente de la baraja");
         System.out.println("1. Mover la carta a una escalera");
         System.out.println("2. Mover la carta a un palo");
         System.out.println("3. Salir al menu principal");
         System.out.println("4. Exit");
         lectura=this.leer();
        } while (lectura ==-1);
        return lectura;
        
    }
    
    public int opcionesMenuEscalera(){
        int lectura;
        do{
         System.out.println("Elige la operacion:");
         System.out.println("0. Mover la carta a una escalera");
         System.out.println("1. Mover la carta a un palo");
         System.out.println("2. Dar la vuelta a la carta oculta");
         System.out.println("3. Salir al menu principal");
         System.out.println("4. Exit");
         lectura=this.leer();
        } while (lectura ==-1);
        return lectura;
        
    }
    
    public int opcionesMenuMoverCartaEscalera(){
        int lectura;
        do{
         System.out.println("Elige la operacion:");
         System.out.println("1. Mover la carta a la 1º escalera");
         System.out.println("2. Mover la carta a la 2º escalera");
         System.out.println("3. Mover la carta a la 3º escalera");
         System.out.println("4. Mover la carta a la 4º escalera");
         System.out.println("5. Mover la carta a la 5º escalera");
         System.out.println("6. Mover la carta a la 6º escalera");
         System.out.println("7. Mover la carta a la 7º escalera");
         System.out.println("8. Salir al menu principal");
         System.out.println("9. Exit");
         lectura=this.leer();
        } while (lectura ==-1);
        return lectura;
        
    }

    public int opcionesMenuMoverCartaAPalos(){
        int lectura;
        do{
         System.out.println("Elige la operacion:");
         System.out.println("1. Mover la carta a la 1º palo de cartas");
         System.out.println("2. Mover la carta a la 2º palo de cartas");
         System.out.println("3. Mover la carta a la 3º palo de cartas");
         System.out.println("4. Mover la carta a la 4º palo de cartas");
         System.out.println("5. Salir al menu principal");
         System.out.println("6. Exit");
         lectura=this.leer();
        } while (lectura ==-1);
        return lectura;
        
    }
}
