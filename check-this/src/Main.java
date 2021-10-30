import org.academiadecodigo.bootcamp.Prompt;

import org.academiadecodigo.bootcamp.scanners.string.StringInputScanner;

public class Main {

    private static final int DEFAULT_PORT = 55555;

    public static void main(String[] args) {

       /* Prompt prompt = new Prompt(System.in, System.out);

        StringInputScanner question1 = new StringInputScanner();
        question1.setMessage("What is your name?");

        String name = prompt.getUserInput(question1);*/

        Server server = new Server(DEFAULT_PORT);
        server.openServer();


    }
}
