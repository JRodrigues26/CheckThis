import java.io.IOException;

public class Main {

    private static final int DEFAULT_PORT = 55555;

    public static void main(String[] args) throws IOException {

        Server testServer = new Server(DEFAULT_PORT);

        testServer.openServer();



    }
}
