import org.academiadecodigo.bootcamp.Prompt;
import org.academiadecodigo.bootcamp.scanners.string.StringInputScanner;

import java.io.*;
import java.net.Socket;

public class Player {

    private Socket playerSocket;
    private Board gameboard;

    private PrintWriter out;
    private Prompt prompt;
    private String name;
    private PrintStream printStream;

    public Player(Socket socket, Board gameboard) {
        try {
            this.playerSocket = socket;
            this.gameboard = gameboard;
            this.printStream = new PrintStream(this.playerSocket.getOutputStream()); // to print messages to the player terminal
            this.out = new PrintWriter(this.playerSocket.getOutputStream(), true);
            this.prompt = new Prompt(this.playerSocket.getInputStream(), printStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public synchronized void setName() throws IOException {
        StringInputScanner question1 = new StringInputScanner();
        question1.setMessage("whats your name" + "\n");
        String name = prompt.getUserInput(question1);
        this.name = name;
        System.out.println(name);
    }

    public void play() {
        StringInputScanner question = new StringInputScanner();
        question.setMessage("Your turn " + name + "?" + "\n");
        String move = prompt.getUserInput(question);
    }
}

