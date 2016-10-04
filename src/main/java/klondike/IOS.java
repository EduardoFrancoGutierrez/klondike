package klondike;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class IOS {

   
    public void showTablero(Baraja baraja, Escaleras escalera){
            
            this.mostrarBaraja(baraja);
            this.mostrarEscalera(escalera);
          //  lectura=this.showMenu();
           
    }

    public int showMenu() {
       int lectura;
       do{
        System.out.println("Elige la operacion:");
        System.out.println("0. Sacar carta de la baraja");
        System.out.println("1. Seleccionar 1º pila de cartas");
        System.out.println("2. Seleccionar 2º pila de cartas");
        System.out.println("3. Seleccionar 3º pila de cartas");
        System.out.println("4. Seleccionar 4º pila de cartas");
        System.out.println("5. Seleccionar 5º pila de cartas");
        System.out.println("6. Seleccionar 6º pila de cartas");
        System.out.println("7. Seleccionar 7º pila de cartas");
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
            System.out.print(String.format("%1$-25s",j+".LIST"));
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
    public void mostrarBaraja(Baraja baraja){
        int poscionMostrar=0;
        if (baraja.getPosCartaMostrada()!=-1)
            poscionMostrar=baraja.getPosCartaMostrada();
        System.out.println(String.format("%1$-25s",0+".LIST"));
        System.out.print(String.format("%1$-25s",baraja.getCards().get(poscionMostrar).toString()));
        System.out.println();
        System.out.println();
    }
    
    public int opcionesMenuBaraja(){
        int lectura;
        do{
         System.out.println("Elige la operacion:");
         System.out.println("0. Sacar la carta siguiente de la baraja");
         System.out.println("1. Mover la carta a una pila");
         System.out.println("2. Salir al menu principal");
         System.out.println("8. Exit");
         lectura=this.leer();
        } while (lectura ==-1);
        return lectura;
        
    }
    
    public int opcionesMenuListaPila(){
        int lectura;
        do{
         System.out.println("Elige la operacion:");
         System.out.println("0. Mover la carta a una pila");
         System.out.println("1. Salir al menu principal");
         System.out.println("8. Exit");
         lectura=this.leer();
        } while (lectura ==-1);
        return lectura;
        
    }
    
    public int opcionesMenuMoverCarta(){
        int lectura;
        do{
         System.out.println("Elige la operacion:");
         System.out.println("0. Mover la carta a la 1º pila de cartas");
         System.out.println("1. Mover la carta a la 2º pila de cartas");
         System.out.println("2. Mover la carta a la 3º pila de cartas");
         System.out.println("3. Mover la carta a la 4º pila de cartas");
         System.out.println("4. Mover la carta a la 5º pila de cartas");
         System.out.println("5. Mover la carta a la 6º pila de cartas");
         System.out.println("6. Mover la carta a la 7º pila de cartas");
         System.out.println("7. Salir al menu principal");
         System.out.println("8. Exit");
         lectura=this.leer();
        } while (lectura ==-1);
        return lectura;
        
    }

}