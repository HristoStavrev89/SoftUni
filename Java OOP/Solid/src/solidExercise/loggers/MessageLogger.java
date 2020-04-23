package solidExercise.loggers;

import solidExercise.appenders.interfaces.Appender;
import solidExercise.enumerations.ReportLevel;
import solidExercise.loggers.interfaces.Logger;

public class MessageLogger implements Logger {
    private Appender[] appenders;


    public MessageLogger(Appender... args) {
        this.appenders = args;
    }


    @Override
    public void logInfo(String date, String message) {
        this.logMessage(date, ReportLevel.INFO, message);
    }

    @Override
    public void logWarning(String date, String message) {
        this.logMessage(date, ReportLevel.WARNING, message);
    }

    @Override
    public void logError(String date, String message) {
        this.logMessage(date, ReportLevel.ERROR, message);
    }

    @Override
    public void logCritical(String date, String message) {
        this.logMessage(date, ReportLevel.CRITICAL, message);
    }

    @Override
    public void logFatal(String date, String message) {
        this.logMessage(date, ReportLevel.FATAL, message);
    }





    private void logMessage(String date, ReportLevel reportLevel, String message) {
        for (Appender appender : this.appenders) {
            appender.append(date, reportLevel, message);
        }
    }
}
