package ChapterSeven;

import java.io.IOException;
import java.util.logging.*;

public class ServerLoggerExample {
    private static final Logger logger = Logger.getLogger(ServerLoggerExample.class.getName());

    public static void main(String[] args) {
        try {
            FileHandler fh = new FileHandler("server.log", true);
            fh.setFormatter(new SimpleFormatter());
            logger.addHandler(fh);

            logger.info("Server is starting...");
            // Simulate server events
            logger.warning("Client tried to access a restricted resource.");
            logger.severe("Server encountered an unexpected error!");

        } catch (IOException e) {
            logger.severe("Failed to create log file handler.");
        }
    }
}
