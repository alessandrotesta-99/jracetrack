package it.unicam.cs.pa.jraceTrack.View;

import it.unicam.cs.pa.jraceTrack.Controller.Controller;
import it.unicam.cs.pa.jraceTrack.Controller.DefaultController;
import it.unicam.cs.pa.jraceTrack.Model.*;
import it.unicam.cs.pa.jraceTrack.MyFactoryControllerManager;

import java.io.*;
import java.util.Scanner;

public class ConsoleView implements View<TrackLocation2D> {

   private final BufferedReader in;
   private final PrintStream out;
   private final PrintStream err;
   private final Controller<TrackLocation2D> controller = MyFactoryControllerManager.getInstance().createController();

    public ConsoleView(InputStream is, OutputStream os) {
        this(new BufferedReader(new InputStreamReader(is)),new PrintStream(os));
    }

    public ConsoleView(BufferedReader in, PrintStream out, PrintStream err /*StatePrinter<T> printer*/) {
        this.out = out;
        this.in = in;
        this.err = err;
    }

    public ConsoleView(BufferedReader in, PrintStream out) {
        this(in,out,out);
    }

    public ConsoleView() {
        this(new BufferedReader(new InputStreamReader(System.in)),System.out,System.err);
    }

    @Override
    public void open() throws IOException {
        printHello();
        while(controller.isStart()){
            printCommand();
            processCommand();
        }
        printGoodBye();
    }

    private void printGoodBye() {
        out.println("Alla prossima gara!");
    }

    private void printCommand() {
        out.println("\n");
        out.println("0 - mostra tracciato");
        out.println("1 - mostra giocatori");
        out.println("2 - mostra posizione giocatore");
        out.println("3 - mostra prossime posizioni giocatore");
        out.println("4 - mostra le macchine in gara");
        out.println("5 - mostra stato macchine dei giocatori");
        out.println("6 - mostra stato della macchina di un giocatore");
        out.println("7 - muovi la macchina");
        out.println("8 - mostra il turno di un giocatore");
        out.println("9 - mostra tutto il percorso di un giocatore");
        out.println("10 - mostra il vincitore");
        out.println("999 - esci dal gioco");
    }

    private void processCommand() {
        Scanner input = new Scanner(in);
        switch (input.nextLine()){
            case "0":
                out.println(controller.getTrack().toString());
                break;
            case "1":
                out.println(controller.getPlayers().toString());
                break;
            case "2":
                Player<TrackLocation2D> p = getPlayerFrom(input);
                printMsg(p,"La posizione del giocatore è: " + p.getCar().getLocation());
                break;
            case "3":
                Player<TrackLocation2D> p1 = getPlayerFrom(input);
                printMsg(p1, "Le prossime posizioni del giocatore sono: " + controller.getNextLocs(p1.getCar().getLocation(), controller.getTrack()));
                break;
            case "4":
                out.println(controller.getCars(controller.getTrack()).toString());
                break;
            case "5":
                out.println(controller.getStatusCars(controller.getTrack()).toString());
                break;
            case "6":
                Player<TrackLocation2D> p2 = getPlayerFrom(input);
                printMsg(p2, "Stato della macchina di " + p2.getName() + " è: " + controller.getStatus(p2.getCar().getLocation(), controller.getTrack()));
                break;
            case "7":
                Player<TrackLocation2D> p3 = getPlayerFrom(input);
                if(p3.isMyTurn()){
                    if(p3.getType() == TypePlayer.BOT)
                        controller.moveUp(new TrackLocation2D(5,8),p3);
                    out.println("La nuova posizione è: " + p3.getCar().getLocation());
                }else
                    err.println("Non è il turno di " + p3.getName() + "!");
                break;
            case "8":
                Player<TrackLocation2D> p4 = getPlayerFrom(input);
                printMsg(p4, "Il turno del giocatore " + p4.getName() + " è: " + controller.getTurnPlayer(p4));
                break;
            case "9":
                Player<TrackLocation2D> p5 = getPlayerFrom(input);
                printMsg(p5, "Percorso totale di " + p5.getName() + " : " + controller.getCarPath(p5.getCar()));
                break;
            case "10":
                controller.setWinnerPlayer(controller.getPlayers());
                if(controller.getWinner() != null)
                    printMsg(controller.getWinner(), "Il giocatore " + controller.getWinner().getName() + " ha vinto!");
                else
                    out.println("Non ci sono vincitori!");
                break;
            case "999":
                this.close();
                break;
        }
    }

    private void printMsg(Player<TrackLocation2D> p, String message) {
        if(p != null && controller.getPlayers().contains(p))
            out.println(message);
    }

    private Player<TrackLocation2D> getPlayerFrom(Scanner input) {
        out.println("Inserisci il nome del giocatore: ");
        String name = input.next();
        return controller.getPlayers().stream().filter(pl -> pl.getName().equalsIgnoreCase(name)).findFirst().orElse(null);
    }

    private void addFiles() throws IOException {
        loadFile();
        controller.newGame();
        out.println("File caricato!");
    }

    private void loadFile() throws IOException {
        controller.loadTrack();
        controller.loadPlayers();
    }

    private void printHello() throws IOException {
        out.println("*****************************************************************");
        out.println("*                                                               *");
        out.println("*        BENVENUT* NEL GIOCO FORMULA 1 CARTA E PENNA            *");
        out.println("*                                                               *");
        out.println("*****************************************************************");
        addFiles();
    }

    @Override
    public void close(){
        controller.finish();
    }
}
