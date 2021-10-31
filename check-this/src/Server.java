import org.academiadecodigo.bootcamp.Prompt;
import org.academiadecodigo.bootcamp.scanners.string.StringInputScanner;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.LinkedList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {

    private ServerSocket serverSocket;
    private Socket clientSocket;
    private LinkedList<Socket> clientsSockets;
    private ExecutorService gamePool;

    public Server(int port) {
        try {

            System.err.println("SERVER OPEN");
            serverSocket = new ServerSocket(port);
            clientsSockets = new LinkedList<>();
            gamePool = Executors.newCachedThreadPool();


        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    public void openServer() throws IOException {
        while (true) {

            waitForClients();

            if ((clientsSockets.size() % 2) == 0) {
                System.err.println("WE CAN NOW START A NEW GAME");
                gamePool.submit(new Game(clientsSockets.get(clientsSockets.size()-1), clientsSockets.get(clientsSockets.size()-2)));

            }else {
                try {
                    PrintWriter out = new PrintWriter(this.clientSocket.getOutputStream(), true);
                    out.println("Waiting for another player");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void waitForClients() {
        try {

            clientSocket = serverSocket.accept();
            System.err.println(clientSocket.getInetAddress().getHostName());
            clientsSockets.add(clientSocket);


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
