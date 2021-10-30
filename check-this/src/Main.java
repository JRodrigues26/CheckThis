public class Main {

    private static final int DEFAULT_PORT = 55555;

    public static void main(String[] args) {

     Server testserver = new Server(DEFAULT_PORT);

     testserver.openServer();

    }
}
