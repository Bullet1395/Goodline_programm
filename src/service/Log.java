package service;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public class Log {
    private Logger logger;

    public Log() {
        logger = LogManager.getLogger(getClass());

        logger.trace("Entering application.");
    }

    public void traceLogging(String text){
        logger.trace(text);
    }

    public void infoLogging(String text){
        logger.info(text);
    }

    public void errorLogging(Exception e){
        logger.error("Failed: ", e.getMessage());
    }

    public void endLogging() {
        logger.trace("Exiting application.");
    }
}
