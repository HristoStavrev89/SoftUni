package solidExercise.layouts.interfaces;

import solidExercise.enumerations.ReportLevel;

public interface Layout {
    String format(String data, ReportLevel reportLevel, String message);
}
