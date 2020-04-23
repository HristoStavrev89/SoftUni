package solidExercise.appenders.interfaces;

import solidExercise.enumerations.ReportLevel;

public interface Appender {
    void append(String data, ReportLevel reportLevel, String message);
    void setReportLevel(ReportLevel reportLevel);
}
