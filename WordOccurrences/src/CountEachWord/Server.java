package CountEachWord;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * This class represents a server application for counting the occurrences of each word in a string received from a client.
 * It listens for client connections on a specified port, accepts the input string from the client, counts the occurrences
 * of each word, and sends the result back to the client as a map of word-count pairs.
 *
 * @author Nick Zambri
 * @version 1.0
 * @since 2023-04-26
 */
public class Server {
    private static final int DEFAULT_PORT = 8888;

    /**
     * A ServerSocket for accepting client connections.
     */
    private ServerSocket serverSocket;

    /**
     * A logger for logging messages.
     */
    private static final Logger logger = Logger.getLogger(Server.class.getName());

    /**
     * Constructs a new Server object and initializes the components.
     */
    public Server(int port) {
        // Set up the server socket
        try {
            serverSocket = new ServerSocket(port);
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Could not listen on port " + port, e);
            System.exit(1);
        }
    }

    /**
     * Starts the server and listens for client connections.
     */
    public void start() {
        logger.info("Server started, listening for connections on port " + serverSocket.getLocalPort());

        while (true) {
            try (Socket clientSocket = serverSocket.accept()) {
                logger.info("Client connected from " + clientSocket.getInetAddress().getHostAddress());

                // Set up input and output streams
                ObjectInputStream inputStream = new ObjectInputStream(clientSocket.getInputStream());
                ObjectOutputStream outputStream = new ObjectOutputStream(clientSocket.getOutputStream());

                // Read input string from client
                String inputText = inputStream.readUTF();

                // Count words and send result back to client
                Map<String, Integer> wordCounts = WordOccurrences.countWords(inputText);
                outputStream.writeObject(wordCounts);

            } catch (IOException e) {
                logger.log(Level.SEVERE, "Error handling client request", e);
            }
        }
    }

    /**
     * The main method for starting the server.
     * @param args The command line arguments (not used).
     */
    public static void main(String[] args) {
        int port = DEFAULT_PORT;
        if (args.length > 0) {
            try {
                port = Integer.parseInt(args[0]);
            } catch (NumberFormatException e) {
                logger.log(Level.WARNING, "Invalid port number specified, using default port " + DEFAULT_PORT);
            }
        }
        Server server = new Server(port);
        server.start();
    }
}
