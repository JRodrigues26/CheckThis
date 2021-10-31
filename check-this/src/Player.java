import org.academiadecodigo.bootcamp.Prompt;
import org.academiadecodigo.bootcamp.scanners.string.StringInputScanner;

import java.io.*;
import java.net.Socket;

public class Player {

    private Socket playerSocket;
    private PrintWriter out;
    private Prompt prompt;
    private String name;
    private PrintStream printStream;

    public Player(Socket socket) {
        try {
            this.playerSocket = socket;
            this.printStream = new PrintStream(this.playerSocket.getOutputStream()); // to print messages to the player terminal
            this.out = new PrintWriter(this.playerSocket.getOutputStream(), true);
            this.prompt = new Prompt(this.playerSocket.getInputStream(), printStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public synchronized void setName(){
        StringInputScanner question1 = new StringInputScanner();
        question1.setMessage("whats your name" + "\n");
        String name = prompt.getUserInput(question1);
        this.name = name;
        System.out.println(name);
    }

    public String choseChecker() {
        StringInputScanner question = new StringInputScanner();
        question.setMessage("Your turn " + name + "?" + "\n");
        String move = prompt.getUserInput(question);
        return move;
    }

    public String moveChecker(){
        return null;
    }

}

