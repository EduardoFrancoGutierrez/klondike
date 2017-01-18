package klondike.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import klondike.model.Board;
import klondike.model.Deck;
import klondike.model.Ladders;
import klondike.model.StackCards;
import klondike.model.StackFamilyCards;

public class IOS {

    private static final int EMPTY_STACK_CARD_SIZE = 0;

    private static final int NOT_INTEGER = -1;

    private static final int POSITION_CARD_SHOW_INITIAL = -1;

    public void showTablero(Board board) {

        System.out.println();
        System.out.println("************************** TABLERO *****************************");
        this.showTitleOfDeckStackFamilyCard(board.getStackFamilyCards());
        this.showContentDeck(board.getDeck());
        this.showContentStackFamilyCard(board.getStackFamilyCards());
        this.showLadder(board.getLadders());
        System.out.println("*****************************************************************");
        System.out.println();

    }

    public int showMenu() {
        int readIOS;
        do {
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
            readIOS = this.read();
        } while (readIOS == NOT_INTEGER);
        return readIOS;
    }

    public int read() {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String number = "";
        try {
            number = bufferedReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Integer returnRead;
        if (this.isInteger(number))
            returnRead = Integer.parseInt(number);
        else
            returnRead = NOT_INTEGER;
        return returnRead;
    }

    public boolean isInteger(String s) {
        try {
            Integer.parseInt(s);
        } catch (NumberFormatException e) {
            return false;
        } catch (NullPointerException e) {
            return false;
        }
        return true;
    }

    public void showLadder(Ladders ladder) {
        for (int j = 1; j < Ladders.NUM_COLUMN + 1; j++) {
            System.out.print(String.format("%1$-25s", j + ".ESCALERA"));
        }
        System.out.println();
        for (int i = 0; i < Ladders.MAX_NUM_ROW; i++) {
            for (int j = 0; j < Ladders.NUM_COLUMN; j++) {
                StackCards stackCard = ladder.getStairsLadder().get(j);
                if (i < stackCard.size()) {
                    System.out.print(String.format("%1$-25s", stackCard.getSatckCards().get(i).toString()));
                } else
                    System.out.print(String.format("%1$-25s", " "));
            }
            System.out.println();
        }
    }

    public void showTitleOfDeckStackFamilyCard(List<StackFamilyCards> stacksFamily) {
        System.out.print(String.format("%1$-25s", 0 + ".BARAJA"));
        for (int i = 0; i < stacksFamily.size(); i++) {
            System.out.print(String.format("%1$-25s", i + 1 + ".PALO"));
        }
        System.out.println();
    }

    public void showContentDeck(Deck deck) {
        int positionShow = 0;
        if (deck.getPosCardShow() != POSITION_CARD_SHOW_INITIAL) {
            positionShow = deck.getPosCardShow();
        }
        if (deck.size() > 0) {
            System.out.print(String.format("%1$-25s", deck.getCards().get(positionShow).toString()));
        } else {
            System.out.print(String.format("%1$-25s", " "));
        }
    }

    public void showContentStackFamilyCard(List<StackFamilyCards> stacksFamily) {
        for (StackFamilyCards stack : stacksFamily) {
            int positionShow = 0;
            if (stack.getPosShowCard() != POSITION_CARD_SHOW_INITIAL)
                positionShow = stack.getPosShowCard();
            if ((stack.getCards() != null) && (stack.getCards().size() > EMPTY_STACK_CARD_SIZE))
                System.out.print(String.format("%1$-25s", stack.getCards().get(positionShow).toString()));
            else {
                System.out.print(String.format("%1$-25s", " "));
            }
        }
        System.out.println();
        System.out.println();

    }

    public int optionMenuDeck() {
        int readIOS;
        do {
            System.out.println("Elige la operacion:");
            System.out.println("0. Sacar la carta siguiente de la baraja");
            System.out.println("1. Mover la carta a una escalera");
            System.out.println("2. Mover la carta a un palo");
            System.out.println("3. Salir al menu principal");
            System.out.println("4. Exit");
            readIOS = this.read();
        } while (readIOS == NOT_INTEGER);
        return readIOS;

    }

    public int optionMenuLadder() {
        int readIOS;
        do {
            System.out.println("Elige la operacion:");
            System.out.println("0. Mover la carta a una escalera");
            System.out.println("1. Mover la carta a un palo");
            System.out.println("2. Dar la vuelta a la carta oculta");
            System.out.println("3. Salir al menu principal");
            System.out.println("4. Exit");
            readIOS = this.read();
        } while (readIOS == NOT_INTEGER);
        return readIOS;

    }

    public int optionMenuMoveCardLadder() {
        int readIOS;
        do {
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
            readIOS = this.read();
        } while (readIOS == NOT_INTEGER);
        return readIOS;

    }

    public int optionMenuMoveCardsToStackFamilyCard() {
        int readIOS;
        do {
            System.out.println("Elige la operacion:");
            System.out.println("1. Mover la carta a la 1º palo de cartas");
            System.out.println("2. Mover la carta a la 2º palo de cartas");
            System.out.println("3. Mover la carta a la 3º palo de cartas");
            System.out.println("4. Mover la carta a la 4º palo de cartas");
            System.out.println("5. Salir al menu principal");
            System.out.println("6. Exit");
            readIOS = this.read();
        } while (readIOS == NOT_INTEGER);
        return readIOS;

    }

    public void ShowFinishPlay() {
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("*************** HAS FINALIZADO EL JUEGO CON EXITO ***************");
    }
}
