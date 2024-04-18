package Utils;

import java.util.logging.Logger;

public class AppLogger  {

    private static Logger logger;

    private AppLogger() {
    }

    public static Logger getLogger() {
        if (logger == null) {
            logger = Logger.getLogger(AppLogger.class.getName());
        }
        return logger;
    }


}
