package it.unicam.cs.pa.jraceTrack.View;

import it.unicam.cs.pa.jraceTrack.Controller.Controller;
import it.unicam.cs.pa.jraceTrack.Model.Car;
import it.unicam.cs.pa.jraceTrack.Model.Player;
import it.unicam.cs.pa.jraceTrack.Model.TypePlayer;
import it.unicam.cs.pa.jraceTrack.Controller.MyFactoryControllerManager;
import it.unicam.cs.pa.jraceTrack.Model.Location.DefaultLocation;
import it.unicam.cs.pa.jraceTrack.Model.Location.MyFactoryLocation;

import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Logger;

public class ConsoleView implements View<DefaultLocation> {

    private final Controller<DefaultLocation> controller = MyFactoryControllerManager.getInstance().createController();
    private final static Logger logger = Logger.getGlobal();

    @Override
    public void open() throws IOException {
        logger.finest("console view aperta.");
        printHello();
        while(controller.isStart()){
            printCommand();
            processCommand();
        }
        printGoodBye();
    }

    private void printGoodBye() {
        System.out.println("Alla prossima gara!");
    }

    private void printCommand() {
        System.out.println("\n");
        System.out.println("0 - mostra tracciato");
        System.out.println("1 - mostra giocatori");
        System.out.println("2 - mostra posizione giocatore");
        System.out.println("3 - mostra prossime posizioni giocatore");
        System.out.println("4 - mostra le macchine in gara");
        System.out.println("5 - mostra stato macchine dei giocatori");
        System.out.println("6 - mostra stato della macchina di un giocatore");
        System.out.println("7 - muovi la macchina");
        System.out.println("8 - mostra il turno di un giocatore");
        System.out.println("9 - mostra tutto il percorso di un giocatore");
        System.out.println("10 - mostra il vincitore");
        System.out.println("11 - mostra il colore della macchina");
        System.out.println("999 - esci dal gioco");
    }

    private void processCommand() {
        Scanner input = new Scanner(System.in);
        switch (input.nextLine()){
            case "0":
                System.out.println(controller.getTrack().toString());
                break;
            case "1":
                System.out.println(controller.getPlayers().toString());
                break;
            case "2":
                Player<DefaultLocation> pCase2 = getPlayerFrom(input);
                printMsg(pCase2,"La posizione del giocatore è: " + pCase2.getCar().getLocation());
                break;
            case "3":
                Player<DefaultLocation> pCase3 = getPlayerFrom(input);
                printMsg(pCase3, "Le prossime posizioni del giocatore sono: " + controller.getNextLocs(pCase3.getCar().getLocation(), controller.getTrack()));
                break;
            case "4":
                System.out.println(controller.getCars(controller.getTrack()).toString());
                break;
            case "5":
                System.out.println(controller.getStatusCars(controller.getTrack()).toString());
                break;
            case "6":
                Player<DefaultLocation> pCase6 = getPlayerFrom(input);
                printMsg(pCase6, "Stato della macchina di " + pCase6.getName() + " è: " + controller.getStatus(pCase6.getCar().getLocation(), controller.getTrack()));
                break;
            case "7":
                Player<DefaultLocation> pCase7 = getPlayerFrom(input);
                if(pCase7.isMyTurn()){
                    if(pCase7.getType() == TypePlayer.BOT)
                        controller.moveUp(null,pCase7);
                    else if (pCase7.getType() == TypePlayer.INTERACTIVE){
                        typePlayerInteractive(input, pCase7);
                    }
                    System.out.println("La nuova posizione è: " + pCase7.getCar().getLocation());
                }else
                    System.err.println("Non è il turno di " + pCase7.getName() + "!");
                break;
            case "8":
                Player<DefaultLocation> pCase8 = getPlayerFrom(input);
                printMsg(pCase8, "Il turno del giocatore " + pCase8.getName() + " è: " + controller.getTurnPlayer(pCase8));
                break;
            case "9":
                Player<DefaultLocation> pCase9 = getPlayerFrom(input);
                printMsg(pCase9, "Percorso totale di " + pCase9.getName() + " : " + controller.getCarPath(pCase9.getCar()));
                break;
            case "10":
                controller.setWinnerPlayer(controller.getPlayers());
                if(controller.getWinner() != null)
                    printMsg(controller.getWinner(), "Il giocatore " + controller.getWinner().getName() + " ha vinto!");
                else
                    System.out.println("Non ci sono vincitori!");
                break;
            case "11":
                Player<DefaultLocation> pCase11 = getPlayerFrom(input);
                printMsg(pCase11,"Il colore della macchina di " + pCase11.getName() + " è: " + pCase11.getCar().getColor());
                break;
            case "999":
                this.close();
                break;
        }
    }

    private void typePlayerInteractive(Scanner input, Player<DefaultLocation> pCase7) {
        System.out.println("Inserisci la coordinata x della prossima posizione: ");
        int x = Integer.parseInt(input.next());
        System.out.println("Inserisci la coordinata y della prossima posizione: ");
        int y = Integer.parseInt(input.next());
        controller.moveUp(MyFactoryLocation.getInstance().createLocation(x,y), pCase7);
    }

    private void printMsg(Player<DefaultLocation> p, String message) {
        if(p != null && controller.getPlayers().contains(p))
            System.out.println(message);
    }

    private Player<DefaultLocation> getPlayerFrom(Scanner input) {
        System.out.println("Inserisci il nome del giocatore: ");
        String name = input.next();
        return controller.getPlayers().stream().filter(pl -> pl.getName().equalsIgnoreCase(name)).findFirst().orElse(null);
    }

    private void addFiles() throws IOException {
        controller.newGame();
        loadFile();
    }

    private void loadFile() throws IOException {
        controller.loadTrack();
        controller.loadPlayers();
    }

    private void printHello() throws IOException {
        System.out.println("*****************************************************************");
        System.out.println("*                                                               *");
        System.out.println("*        BENVENUT* NEL GIOCO FORMULA 1 CARTA E PENNA            *");
        System.out.println("*                                                               *");
        System.out.println("*****************************************************************");
        addFiles();
    }

    @Override
    public void close(){
        controller.finish();
        logger.finest("console view chiusa.");
    }
}
