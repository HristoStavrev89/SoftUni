package solidExercise;

import solidExercise.appenders.ConsoleAppender;
import solidExercise.appenders.FileAppender;
import solidExercise.appenders.interfaces.Appender;
import solidExercise.customFiles.LogFile;
import solidExercise.customFiles.interfaces.File;
import solidExercise.layouts.SimpleLayout;
import solidExercise.layouts.interfaces.Layout;
import solidExercise.loggers.MessageLogger;
import solidExercise.loggers.interfaces.Logger;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        Layout simpleLayout = new SimpleLayout();
        Appender consoleAppender = new ConsoleAppender(simpleLayout);

        File file = new LogFile();
        Appender fileAppender = new FileAppender(simpleLayout);
        ((FileAppender) fileAppender).setFile(file);

        Logger logger = new MessageLogger(consoleAppender, fileAppender);

        logger.logError("3/26/2015 2:08:11 PM", "Error parsing JSON.");
        logger.logInfo("3/26/2015 2:08:11 PM", "User Pesho successfully registered.");





    }
}
