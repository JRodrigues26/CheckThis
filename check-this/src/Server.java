import java.io.IOException;
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


    public void openServer() {
        while (true) {

            waitForClients();

            if ((clientsSockets.size() % 2) == 0) {
                System.err.println("WE CAN NOW START A NEW GAME");
                gamePool.submit(new Game(clientsSockets));
                clientsSockets.clear();
                System.err.println("WAITING FOR MORE CLIENTS");
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
