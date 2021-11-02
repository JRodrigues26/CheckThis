import java.io.IOException;

public class Main {

    private static final int DEFAULT_PORT = 8080;

    public static void main(String[] args) throws IOException {

        int port = args.length > 0 ? Integer.parseInt(args[0]) : DEFAULT_PORT;

        Server testServer = new Server(port);

        testServer.openServer();



    }
}
